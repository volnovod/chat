package com.chat.client.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Date;

/**
 * Created by victor on 19.11.15.
 */
public class RegistrationController {

    private Scene nextScene;
    private Stage stage;
    private ClientSocket clientSocket;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField dayField;

    @FXML
    private TextField monthField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmpasswordField;

    @FXML
    private Button okButton;

    @FXML
    private Button exitButton;

    public ClientSocket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(ClientSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public Scene getNextScene() {
        return nextScene;
    }

    public void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void okButtonMouseEntered(){
        enableShadowOnButton(okButton);
    }

    @FXML
    public void okButtonMouseExited(){
        disableShadowOnButton(okButton);
    }

    @FXML
    public void exitButtonMouseEntered(){
        enableShadowOnButton(exitButton);
    }

    @FXML
    public void exitButtonMouseExited(){
        disableShadowOnButton(exitButton);
    }

    public void enableShadowOnButton(Button button){
        button.setEffect(new DropShadow());
    }

    public void disableShadowOnButton(Button button){
        button.setEffect(null);
    }

    @FXML
    public void saveClient(){
        String name = nameField.getText();
        String surname = surnameField.getText();
        Date birthDate = new Date(Integer.valueOf(yearField.getText()), Integer.valueOf(monthField.getText()),
                Integer.valueOf(dayField.getText()));
        String login = loginField.getText();
        String password = passwordField.getText();
        String passwdConfirm = confirmpasswordField.getText();
        if (passwordValidator(this.passwordField.getText(), this.confirmpasswordField.getText())){
            clientSocket.sendMessage("registration");
            clientSocket.sendMessage("n");
            clientSocket.sendMessage(name);
            clientSocket.sendMessage("sn");
            clientSocket.sendMessage(surname);
            clientSocket.sendMessage("d");
            clientSocket.sendMessage(birthDate.toString());
            clientSocket.sendMessage("l");
            clientSocket.sendMessage(login);
            clientSocket.sendMessage("p");
            clientSocket.sendMessage(password);
        } else {
            passwordField.setStyle(passwordField.getStyle()+"-fx-background-color: red");
            confirmpasswordField.setStyle(confirmpasswordField.getStyle()+"-fx-background-color: red");
        }
    }

    public boolean passwordValidator(String password, String passwordConfirm){
        if (password.equals(passwordConfirm)){
            return true;
        } else {
            return false;
        }
    }

    public void closeApplication(){
        Platform.exit();
        System.exit(0);
    }
}
