package com.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by victor on 16.11.15.
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(62000);
            Socket socket = serverSocket.accept();
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                PrintWriter writer = new PrintWriter(outputStream, true);
                Scanner in = new Scanner(inputStream);

                writer.println("Alehan");

                boolean check = false;

                while(!check && in.hasNextLine()){
                    String line = in.nextLine();
                    System.out.println("Client say: " + line);
                    writer.println("msg: " + line);
                    if (line.equals("vitka")){
                        check = true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
