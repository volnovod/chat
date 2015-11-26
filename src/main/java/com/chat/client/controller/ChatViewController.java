package com.chat.client.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;

/**
 * Created by victor on 27.11.15.
 */
public class ChatViewController {

    @FXML
    private Button exitButton;

    @FXML
    private Button sendMessageButton;

    public void exitButtonMouseEntered(){
        enableShadowOnButton(exitButton);
    }

    public void exitButtonMouseExited(){
        disableShadowOnButton(exitButton);
    }

    public void sendMessageButtonMouseEntered(){
        enableShadowOnButton(sendMessageButton);
    }

    public void sendMessageButtonMouseExited(){
        disableShadowOnButton(sendMessageButton);
    }

    public void enableShadowOnButton(Button button){
        button.setEffect(new DropShadow());
    }

    public void disableShadowOnButton(Button button){
        button.setEffect(null);
    }

    @FXML
    public void exit(){
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void sendMessage(){

    }
}
