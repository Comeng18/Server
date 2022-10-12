package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        StringBuilder hexDataBuilder = new StringBuilder();
        StringBuilder byteDataBuilder = new StringBuilder();
        try {
            // Connect to the server
            ServerSocket server = new ServerSocket(10001);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client Connected");
                hexDataBuilder = new StringBuilder();
                while (true) {
                    int byteData = socket.getInputStream().read();
                    System.out.println(byteData + " " + String.format("%02X", byteData));
                    byteDataBuilder.append(byteData);
                    hexDataBuilder.append(String.format("%02X", byteData));
//                    if (byteData < 0 || (char) byteData == '\n' || (char) byteData == '\r')
//                        break;
                }

//                socket.getOutputStream().write(0x01);
//                System.out.println("Hex Data: " + hexDataBuilder);
//                System.out.println("Hex Data: " + byteDataBuilder);
//                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hex Data: " + hexDataBuilder);
            System.out.println("Hex Data: " + byteDataBuilder);
        }
    }
}
