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
                byte[] bytes = socket.getInputStream().readAllBytes();
                System.out.println("Byte Data: ");
                System.out.println(bytes);
//                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
//                BufferedReader in = new BufferedReader(inputStreamReader);

//                // Read data from the server until we finish reading the document
//                String line = in.readLine();
//                while (bytes != null) {
//                    System.out.println(line);
//                    line = in.readLine();
//                }
            System.out.println("Hex Data: ");
            System.out.println(bytesToHex(bytes));
            // Close our streams
//            in.close();
            out.close();
            socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
