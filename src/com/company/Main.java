package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        // Connect to the server
        ServerSocket server = new ServerSocket(10001);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client Connected");
            StringBuilder hexData = new StringBuilder();
            while (true) {
                int byteData = socket.getInputStream().read();
                hexData.append(Integer.toHexString(byteData));
                if ((char) byteData == '\n' || (char) byteData == '\r')
                    break;
            }
            socket.getOutputStream().write(0x01b);
            System.out.println(hexData);
            socket.close();
        }
    }
}
