package com.chat.client;

import com.chat.client.controller.ClientSocket;
import com.chat.client.controller.LoginController;
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
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        FXMLLoader registrationLoader = new FXMLLoader(getClass().getResource("/fxml/registration.fxml"));

        Scene loginScene = new Scene(loginLoader.load());
        Scene registrationScene = new Scene(registrationLoader.load());

        LoginController loginController = loginLoader.getController();
        RegistrationController registrationController = registrationLoader.getController();

        loginController.setNextScene(registrationScene);
        loginController.setStage(primaryStage);
        ClientSocket clientSocket = new ClientSocket();
        loginController.setSocket(clientSocket);

        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Alehan");
        primaryStage.show();
    }
}
