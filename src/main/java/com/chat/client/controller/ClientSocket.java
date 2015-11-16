package com.chat.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by victor on 16.11.15.
 */
public class ClientSocket {

    private Socket socket;
    private final int port = 61111;
    private final String url = "192.168.1.143";
    private PrintWriter writer;
    private Scanner reader;

    public ClientSocket() {
        try {
            this.socket = new Socket(this.url, this.port);
            this.reader = new Scanner(this.socket.getInputStream());
            this.writer = new PrintWriter(this.socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        this.writer.println(message);
    }
}
