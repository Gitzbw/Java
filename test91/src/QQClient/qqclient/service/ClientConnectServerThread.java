package QQClient.qqclient.service;

import QQClient.qqcommon.Message;

import java.io.IOException;
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
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
}
