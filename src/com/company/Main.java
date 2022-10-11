package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        StringBuilder hexDataBuilder = new StringBuilder();
        try {
            // Connect to the server
            ServerSocket server = new ServerSocket(10001);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client Connected");
                hexDataBuilder = new StringBuilder();
                byte[] bytes = socket.getInputStream().readAllBytes();
                for (byte aByte : bytes)
                    hexDataBuilder.append(String.format("%02X", aByte));

//                socket.getOutputStream().write(0x01);
                System.out.println("Hex Data: " + hexDataBuilder);
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hex Data: " + hexDataBuilder);
        }
    }
}
