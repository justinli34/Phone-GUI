package com.example.project6;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DecimalFormat;

import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.AttributeView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Settings extends HelloController implements Initializable  {
    @FXML
    private AnchorPane settingsApp;

    @FXML
    private Label time;

    @FXML
    private ChoiceBox homescreenPicker;

    @FXML
    private ChoiceBox lockscreenPicker;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    private static String background = "akirahome.jpg";

    private static String name = "My Phone";

    private static String password = "1234";

    private static String lockBackground = "akiralock.jpg";

    public static String getPassword() {
        return password;
    }

    @FXML
    void changeName(ActionEvent event) {
        name = nameField.getText();
    }

    public static String getName(){
        return name;
    }

    @FXML
    void changePassword(ActionEvent event) {
        password = passwordField.getText();
    }

    @FXML
    void changeHomescreen(ActionEvent event) {
        if (homescreenPicker.getValue().equals("Butterflies")){
            background = "butterfly.jpg";
        }
        else if (homescreenPicker.getValue().equals("Flowers")){
            background = "flowers.jpg";
        }
        else if (homescreenPicker.getValue().equals("Donuts")){
            background = "donuts.jpg";
        }
        else if (homescreenPicker.getValue().equals("Car")){
            background = "akirahome.jpg";
        }
    }

    public static String getBackground(){
        return background;
    }

    public static String getLockBackground(){
        return lockBackground;
    }

    @FXML
    void changeLockscreen(ActionEvent event) {
        if (lockscreenPicker.getValue().equals("Butterflies")){
            lockBackground = "butterfly.jpg";
        }
        else if (lockscreenPicker.getValue().equals("Flowers")){
            lockBackground = "flowers.jpg";
        }
        else if (lockscreenPicker.getValue().equals("Donuts")){
            lockBackground = "donuts.jpg";
        }
        else if (lockscreenPicker.getValue().equals("Akira")){
            lockBackground = "akiralock.jpg";
        }
    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) settingsApp.getScene().getWindow();
        HelloApplication.displayHome(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        Timeline clock = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e ->
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        homescreenPicker.getItems().add("Butterflies");
        homescreenPicker.getItems().add("Flowers");
        homescreenPicker.getItems().add("Donuts");
        homescreenPicker.getItems().add("Car");

        lockscreenPicker.getItems().add("Butterflies");
        lockscreenPicker.getItems().add("Flowers");
        lockscreenPicker.getItems().add("Donuts");
        lockscreenPicker.getItems().add("Akira");
    }
}
