package com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket Socket = new DatagramSocket(8888);
        byte data[] = "hello".getBytes();
        DatagramPacket Packet = new DatagramPacket(data, data.length, InetAddress.getLoopbackAddress(), 9999);
        Socket.send(Packet);
        Socket.close();
    }
}
