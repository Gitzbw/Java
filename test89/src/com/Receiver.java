package com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket Socket = new DatagramSocket(9999);
        byte buf[] = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        Socket.receive(datagramPacket);
        int len = datagramPacket.getLength();
        byte data[] = datagramPacket.getData();
        String s = new String(data,0,len);
        System.out.println(s);
        Socket.close();
    }
}
