package com.elizwy.javatech.network.javabaseoio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String request;
            while ((request = reader.readLine()) != null) {
                if("Done".equals(request)){
                    break;
                }
                System.out.println(request);
                writer.println("success receive");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
