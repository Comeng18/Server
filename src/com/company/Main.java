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
            StringBuilder hexDataBuilder = new StringBuilder();
            StringBuilder byteDataBuilder = new StringBuilder();
            while (true) {
                int byteData = socket.getInputStream().read();
                byteDataBuilder.append(byteData);
                hexDataBuilder.append(Integer.toHexString(byteData));
                if ((char) byteData == '\n' || (char) byteData == '\r')
                    break;
            }
            socket.getOutputStream().write(0x00b);
            System.out.println("Hex Data: " + hexDataBuilder);
            System.out.println("Byte Data: " + byteDataBuilder);
            socket.close();
        }
    }
}
