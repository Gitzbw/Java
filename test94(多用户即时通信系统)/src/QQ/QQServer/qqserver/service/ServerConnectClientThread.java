package QQ.QQServer.qqserver.service;



import QQ.QQClient.qqcommon.Message;
import QQ.QQServer.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userId;

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                System.out.println("服务端和客户端" + userId + "保持通信,读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message =(Message) ois.readObject();
                if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND))
                {
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);
                }
                else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT))
                {
                    System.out.println(message.getSender() + "退出");
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();
                    break;
                }
                else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES))
                {
                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.socket.getOutputStream());
                    oos.writeObject(message);
                }
                else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES))
                {
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        String onlineUserId = iterator.next().toString();
                        if(!onlineUserId.equals(message.getSender()))
                        {
                            ServerConnectClientThread serverConnectClientThread = hm.get(onlineUserId);
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(serverConnectClientThread.socket.getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                }
                else if(message.getMesType().equals(MessageType.MESSAGE_FILE_MES))
                {
                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.socket.getOutputStream());
                    oos.writeObject(message);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
