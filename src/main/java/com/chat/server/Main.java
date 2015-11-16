package com.chat.server;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by victor on 15.11.15.
 */
public class Main extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
//        ClientService service = new ClassPathXmlApplicationContext("transactionalContext.xml")
//                .getBean("clientService", ClientServiceImpl.class);
        ServerSocket serverSocket = new ServerSocket(62000);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        PrintWriter writer = new PrintWriter(outputStream, true);
        Scanner in = new Scanner(inputStream);

        writer.println("Alehan");

        boolean check = false;

        while(!check && in.hasNextLine()){
            String line = in.nextLine();
            writer.write("msg: " + line);
            if (line.equals("vitka")){
                check = true;
            }
        }

        socket.close();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
