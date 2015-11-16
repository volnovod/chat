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
