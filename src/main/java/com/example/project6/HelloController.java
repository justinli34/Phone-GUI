package com.example.project6;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public AnchorPane ap;

    @FXML
    private Button calculatorButton;

    @FXML
    private Button noteButton;

    @FXML
    private Label time;

    @FXML
    private Button powerButton;

    @FXML
    private Button playButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Label trackName;

    @FXML
    void powerOff(ActionEvent event) throws IOException{
        Stage stage = (Stage) ap.getScene().getWindow();
        HelloApplication.displayLockscreen(stage);
    }

    @FXML
    void displayCalculator(ActionEvent event) throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        HelloApplication.displayCalculator(stage);
    }

    @FXML
    void displayNotepad(ActionEvent event) throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        HelloApplication.displayNotepad(stage);

    }

    @FXML
    void displayClock(ActionEvent event) throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        HelloApplication.displayClock(stage);

    }

    @FXML
    void displayTictactoe(ActionEvent event) throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        HelloApplication.displayTictactoe(stage);

    }

    @FXML
    void displaySettings(ActionEvent event) throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        HelloApplication.displaySettings(stage);
    }

    @FXML
    void displayCalendar(ActionEvent event) throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        HelloApplication.displayCalendar(stage);
    }

    @FXML
    void displayMusic(ActionEvent event) throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        HelloApplication.displayMusic(stage);
    }
    @FXML
    void pause(ActionEvent event)
    {
        Music.clip.stop();
        Music.playing = false;
    }

    @FXML
    void play(ActionEvent event){
        Music.clip.start();
        Music.playing = true;

    }


    @Override
    public void initialize(URL url, ResourceBundle rb){
        String bg = Settings.getBackground();
        ap.setBackground(new Background(new BackgroundImage((new Image(bg,500,680,false,true)), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        pauseButton.setStyle(
                "-fx-background-radius: 50em; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;" +
                        "-fx-background-color: #FFFFFF;"
        );
        playButton.setStyle(
                "-fx-background-radius: 50em; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px; " +
                        "-fx-max-height: 50px;" +
                        "-fx-background-color: #FFFFFF;"
        );

        trackName.setText(Music.getSong());
        trackName.setAlignment(Pos.CENTER);
    }

}