package QQClient.qqclient.service;

import QQClient.qqcommon.Message;
import QQClient.qqcommon.MessageType;
import QQClient.qqcommon.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class UserClientService {
    private User u = new User();
    private Socket socket;

    public boolean checkUser(String userId,String pwd)
    {
        u.setUserid(userId);
        u.setPasswd(pwd);
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();
            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED))
            {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
