package QQ.QQClient.qqclient.service;

import QQ.QQClient.qqcommon.Message;
import QQ.QQClient.qqcommon.MessageType;

import java.io.FileOutputStream;
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
                   System.out.println("\n==========当前在线用户列表==========");
                   for (int i = 0; i < onlineUsers.length; i++) {
                       System.out.println("用户: " + onlineUsers[i]);
                   }
               }
               else if(ms.getMesType().equals(MessageType.MESSAGE_COMM_MES))
               {
                   System.out.println("\n" + ms.getSender() + "对" + ms.getGetter() + "说: " + ms.getContent());
               }
               else if(ms.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES))
               {
                   System.out.println("\n" + ms.getSender() + "对所有人说: " + ms.getContent());
               }
               else if(ms.getMesType().equals(MessageType.MESSAGE_FILE_MES))
               {
                   System.out.println("\n" + ms.getSender() + "给" + ms.getGetter() + "发送了文件到 " + ms.getDest());
                   FileOutputStream fileOutputStream = new FileOutputStream(ms.getDest());
                   fileOutputStream.write(ms.getFileBytes());
                   fileOutputStream.close();
                   System.out.println("\n保存文件成功");
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
}
