package com.chat.client.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

/**
 * Created by victor on 19.11.15.
 */
public class RegistrationController {

    private Scene nextScene;
    private Stage stage;
    private ClientSocket clientSocket;

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

    }

    public void closeApplication(){
        Platform.exit();
        System.exit(0);
    }
}
