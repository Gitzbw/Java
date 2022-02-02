package QQ.QQClient.qqclient.service;

import QQ.QQClient.qqcommon.Message;
import QQ.QQClient.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread{
    private Socket socket;
    public ClientConnectServerThread(Socket socket)
    {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
       while(true)
       {
           try {
               ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
               Message ms = (Message) ois.readObject();
               if(ms.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND))
               {
                   String[] onlineUsers = ms.getContent().split(" ");
                   System.out.println("==========当前在线用户列表==========");
                   for (int i = 0; i < onlineUsers.length; i++) {
                       System.out.println("用户: " + onlineUsers[i]);
                   }
               }
               else
               {

               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
}
