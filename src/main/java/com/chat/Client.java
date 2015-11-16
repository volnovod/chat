package com.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by victor on 16.11.15.
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.1.143", 62000);
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                Scanner in = new Scanner(inputStream);
                PrintWriter writer = new PrintWriter(outputStream, true);

                while (true){
                    String line = in.nextLine();
                    System.out.println("Server said: " + line);
                    System.out.println("enter msg:");
                    Scanner scanner = new Scanner(System.in);
                    String msg = scanner.nextLine();
                    writer.println(msg);
                }
            } finally {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
