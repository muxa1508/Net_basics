package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        startClient();
    }

    protected static String HOST = "127.0.0.1";
    protected static int PORT = 8083;

    public static void startClient() throws IOException {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Hello world!");
            String resp = in.readLine();
            System.out.println(resp);
        }
    }
}
