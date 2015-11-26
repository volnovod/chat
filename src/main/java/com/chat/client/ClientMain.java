package com.chat.client;

import com.chat.client.controller.ChatViewController;
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
        FXMLLoader chatViewLoader = new FXMLLoader(getClass().getResource("/fxml/chatView.fxml"));

        Scene loginScene = new Scene(loginLoader.load());
        Scene registrationScene = new Scene(registrationLoader.load());
        Scene chatViewScene = new Scene(chatViewLoader.load());

        LoginController loginController = loginLoader.getController();
        RegistrationController registrationController = registrationLoader.getController();
        ChatViewController chatViewController = chatViewLoader.getController();

        loginController.setChatViewScene(chatViewScene);
        loginController.setRegistrationScene(registrationScene);
        loginController.setStage(primaryStage);
        ClientSocket clientSocket = new ClientSocket();
        clientSocket.sendMessage("logging");
        loginController.setSocket(clientSocket);

        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Alehan");
        primaryStage.show();
    }
}
