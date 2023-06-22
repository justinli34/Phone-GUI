package com.example.project6;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Lockscreen implements Initializable {
    @FXML
    private PasswordField passwordBox;
    @FXML
    public AnchorPane ap4;
    @FXML
    private Label time;
    @FXML
    private Label dateLabel;

    private String ddate = "";


    @FXML
    void unlock(ActionEvent event) throws IOException{
        if (passwordBox.getText().equals(Settings.getPassword())){
            Stage stage = (Stage) ap4.getScene().getWindow();
            HelloApplication.displayHome(stage);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String bg = Settings.getLockBackground();
        ap4.setBackground(new Background(new BackgroundImage((new Image(bg, 500, 680, false, true)), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        String a = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM:dd"));
        int monthNumber = Integer.parseInt(a.substring(0, 2));
        String monthName = "";
        switch (monthNumber) {
            case 1 -> monthName = "January";
            case 2 -> monthName = "February";
            case 3 -> monthName = "March";
            case 4 -> monthName = "April";
            case 5 -> monthName = "May";
            case 6 -> monthName = "June";
            case 7 -> monthName = "July";
            case 8 -> monthName = "August";
            case 9 -> monthName = "September";
            case 10 -> monthName = "October";
            case 11 -> monthName = "November";
            case 12 -> monthName = "December";
        }

        dateLabel.setText(monthName + " " + a.substring(3, 5));
        dateLabel.setAlignment(Pos.CENTER);

    }
}
