package com.chat.client;

import com.chat.client.controller.ClientSocket;
import com.chat.client.controller.RegistrationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by victor on 16.11.15.
 */
public class ClientMain extends Application {

    public static void main(String[] args) {
        launch(args);
//        try {
//            Socket socket = new Socket("192.168.1.143", 62000);
//            try {
//                InputStream inputStream = socket.getInputStream();
//                OutputStream outputStream = socket.getOutputStream();
//                Scanner in = new Scanner(inputStream);
//                PrintWriter writer = new PrintWriter(outputStream, true);
//
//                while (true){
//                    String line = in.nextLine();
//                    System.out.println("Server said: " + line);
//                    System.out.println("enter msg:");
//                    Scanner scanner = new Scanner(System.in);
//                    String msg = scanner.nextLine();
//                    writer.println(msg);
//                }
//            } finally {
//                socket.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));


        Scene scene = new Scene(loader.load());
        RegistrationController registrationController = loader.getController();
        ClientSocket clientSocket = new ClientSocket();
        registrationController.setSocket(clientSocket);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Alehan");
        primaryStage.show();
    }
}
