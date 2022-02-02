package QQ.QQServer.qqserver.service;

import QQ.QQClient.qqcommon.Message;
import QQ.QQClient.qqcommon.MessageType;
import QQ.QQClient.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class QQServer {
    private ServerSocket ss = null;
    private static ConcurrentHashMap<String,User> validUsers = new ConcurrentHashMap<>();//可以处理并发的集合 线程安全
    static {
        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("400",new User("400","123456"));
        validUsers.put("500",new User("500","123456"));
        validUsers.put("600",new User("600","123456"));
    }

    private boolean checkUser(String userId,String pwd)
    {
        User user = validUsers.get(userId);
        if(user == null)
        {
            return false;
        }
        if(!user.getPasswd().equals(pwd))
        {
            return false;
        }
        return true;
    }

    public QQServer() {
        try {
            ss = new ServerSocket(9999);
            while(true)
            {
                Socket socket = ss.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u =(User) ois.readObject();
                Message message = new Message();
                if(checkUser(u.getUserid(), u.getPasswd()))
                {
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, u.getUserid());
                    serverConnectClientThread.start();
                    ManageClientThreads.addClientThread(u.getUserid(),serverConnectClientThread);
                }
                else
                {
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
