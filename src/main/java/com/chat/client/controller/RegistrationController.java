package com.chat.client.controller;

import com.chat.server.model.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseEvent;

/**
 * Created by victor on 16.11.15.
 */
public class RegistrationController {

    private String login;
    private String password;
    private ClientSocket socket;


    @FXML
    private Button loginButton;

    @FXML
    private Button registrationButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    public ClientSocket getSocket() {
        return socket;
    }

    public void setSocket(ClientSocket socket) {
        this.socket = socket;
    }

    public void loginButtonMouseEntered(){
        enableShadowOnButton(loginButton);
    }

    public void loginButtonMouseExited(){
        disableShadowOnButton(loginButton);
    }

    public void registrationButtonMouseEntered(){
        enableShadowOnButton(registrationButton);
    }

    public void registrationButtonMouseExited(){
        disableShadowOnButton(registrationButton);
    }

    public void enableShadowOnButton(Button button){
        button.setEffect(new DropShadow());
    }

    public void disableShadowOnButton(Button button){
        button.setEffect(null);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login(){
        setLogin(this.loginField.getText());
        if (loginValidator()){
            setPassword(this.passwordField.getText());
            this.socket.sendMessage("l");
            this.socket.sendMessage(getLogin());
            this.socket.sendMessage("p");
            this.socket.sendMessage(getPassword());
        } else {
            System.out.println("login error");
        }



    }

    public void registration(){

    }

    public boolean loginValidator(){
        String login = this.loginField.getText();
        if(login.equals("")){
            return false;
        }
        if (login.equals(" ")){
            return false;
        }
        if (login.contains(" ")){
            return false;
        }
        else {
            return true;
        }
    }
}
