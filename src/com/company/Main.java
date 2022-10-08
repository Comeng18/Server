package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        try {
            // Connect to the server
            ServerSocket server = new ServerSocket(10001);

            while (true) {

                Socket socket = server.accept();

                System.out.println("Client Connected");

                // Create input and output streams to read from and write to the server
                PrintStream out = new PrintStream(socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Read data from the server until we finish reading the document
                String line = in.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = in.readLine();
                }

            // Close our streams
            in.close();
            out.close();
            socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
