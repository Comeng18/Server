package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        // Connect to the server
        ServerSocket server = new ServerSocket(10001);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client Connected");
            socket.getOutputStream().write(0x01b);
            StringBuilder hexDataBuilder = new StringBuilder();
            StringBuilder byteDataBuilder = new StringBuilder();
            while (true) {
                int byteData = socket.getInputStream().read();
                System.out.println(byteData + " " + String.format("%02X", byteData));
                byteDataBuilder.append(byteData);
                hexDataBuilder.append(String.format("%02X", byteData));
                if (byteData < 0 || (char) byteData == '\n' || (char) byteData == '\r')
                    break;
            }
            socket.getOutputStream().write(0x00b);
            System.out.println("Hex Data: " + hexDataBuilder);
            System.out.println("Byte Data: " + byteDataBuilder);
            socket.close();
        }
    }
}
