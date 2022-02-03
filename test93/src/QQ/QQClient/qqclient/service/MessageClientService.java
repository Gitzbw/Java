package QQ.QQClient.qqclient.service;

import QQ.QQClient.qqcommon.Message;
import QQ.QQClient.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MessageClientService {
    public void sendMessageToOne(String content,String senderId,String getterId)
    {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setContent(content);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setSendTime(new java.util.Date().toString());
        System.out.println(senderId + "对" + getterId + "说: " + content);
        try {
            ClientConnectServerThread clientConnectServerThread =
                    ManageClientConnectServerThread.getClientConnectServerThread(senderId);
            Socket socket = clientConnectServerThread.getSocket();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToAll(String content,String senderId)
    {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
        message.setContent(content);
        message.setSender(senderId);
        message.setSendTime(new java.util.Date().toString());
        System.out.println(senderId + "对所有人说: " + content);
        try {
            ClientConnectServerThread clientConnectServerThread =
                    ManageClientConnectServerThread.getClientConnectServerThread(senderId);
            Socket socket = clientConnectServerThread.getSocket();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
