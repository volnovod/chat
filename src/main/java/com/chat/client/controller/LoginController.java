package com.chat.client.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

/**
 * Created by victor on 16.11.15.
 */
public class LoginController {

    private String login;
    private String password;
    private ClientSocket socket;
    private Scene chatViewScene;
    private Scene registrationScene;
    private boolean isLogin;
    private Stage stage;


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

    public Scene getRegistrationScene() {
        return registrationScene;
    }

    public void setRegistrationScene(Scene registrationScene) {
        this.registrationScene = registrationScene;
    }

    public Scene getChatViewScene() {
        return chatViewScene;
    }

    public void setChatViewScene(Scene chatViewScene) {
        this.chatViewScene = chatViewScene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
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
            String loginResult = this.socket.recieveMessage();
            if (loginResult.equals("Login successful")){
                setChatViewScene();
            }
        }
    }

    private void setChatViewScene(){
        getStage().setScene(getChatViewScene());
    }

    public void registration(){
            stage.setScene(getChatViewScene());
    }

    public boolean loginValidator(){
        String login = this.loginField.getText();
        if(login.equals("")){
            return false;
        }
        return !(login.contains(" "));
    }
}
