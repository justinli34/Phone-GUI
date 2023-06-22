package com.example.project6;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.text.DecimalFormat;

import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.AttributeView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javax.security.auth.login.AccountNotFoundException;
import javax.sound.sampled.*;


public class Clock implements Initializable{

    @FXML
    private AnchorPane clockApp;

    @FXML
    private Button resetButton;
    @FXML
    private Button startButton;
    @FXML
    private Label stopwatchLabel;
    @FXML
    private TextField minuteField;
    @FXML
    private TextField secondField;
    @FXML
    private Button alarmButton;
    @FXML
    private Label systemTime;
    private boolean counting = false;
    private double startTime;
    private double stopTime;
    private double time = 0;
    public static Clip clip;
    AudioInputStream audioInputStream;

    @FXML
    void reset(ActionEvent event) {
        stopwatchLabel.setText("00:00.00");
        time = 0;
    }

    @FXML
    void start(ActionEvent event) throws InterruptedException {

        if (!counting) {
            startButton.setText("Stop");
            startTime = System.currentTimeMillis();
            counting = true;
            stopwatchLabel.setText("Running");
            startButton.setStyle(
                    "-fx-background-radius: 50em; " +
                            "-fx-min-width: 60px; " +
                            "-fx-min-height: 60px; " +
                            "-fx-max-width: 60px; " +
                            "-fx-max-height: 60px;" +
                            "-fx-background-color: #cd5c5c; "
            );
        }
        else {
            DecimalFormat df = new DecimalFormat("00.00");
            DecimalFormat df2 = new DecimalFormat("00");
            startButton.setText("Start");
            stopTime = System.currentTimeMillis();
            counting = false;
            time += stopTime - startTime;
            stopwatchLabel.setText(df2.format((int)(time / 60000)) + ":" + df.format((time) / 1000));
            startButton.setStyle(
                    "-fx-background-radius: 50em; " +
                            "-fx-min-width: 60px; " +
                            "-fx-min-height: 60px; " +
                            "-fx-max-width: 60px; " +
                            "-fx-max-height: 60px;" +
                            "-fx-background-color: #90ee90; "
            );
        }
    }


    @FXML
    void goHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) clockApp.getScene().getWindow();
        HelloApplication.displayHome(stage);
    }

    @FXML
    void setAlarm(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(!minuteField.getText().equals("") || !secondField.getText().equals("")) {
            alarmButton.setText("Timer On");
            alarmButton.setStyle("-fx-background-color: #A9A9A9;");
            if (minuteField.getText().equals("")) {
                Integer a = Integer.parseInt(secondField.getText()) * 1000;
                audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/alarm.wav"));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                delay((a), () -> alarmButton.setStyle("-fx-background-color: #cd5c5c;"));
                delay((a), () -> alarmButton.setText("Time's Up"));
                delay((a), () -> clip.start());


            } else {
                Integer n = Integer.parseInt(minuteField.getText()) * 60000;
                Integer a = Integer.parseInt(secondField.getText()) * 1000;
                audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/alarm.wav"));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                delay((n + a), () -> alarmButton.setStyle("-fx-background-color: #cd5c5c;"));
                delay((n + a), () -> alarmButton.setText("Time's Up"));
                delay((a), () -> clip.start());
            }
        }
    }

    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        startButton.setStyle(
                "-fx-background-radius: 50em; " +
                        "-fx-min-width: 60px; " +
                        "-fx-min-height: 60px; " +
                        "-fx-max-width: 60px; " +
                        "-fx-max-height: 60px;" +
                        "-fx-background-color: #90ee90; "
        );
        resetButton.setStyle(
                "-fx-background-radius: 50em; " +
                        "-fx-min-width: 60px; " +
                        "-fx-min-height: 60px; " +
                        "-fx-max-width: 60px; " +
                        "-fx-max-height: 60px;"
        );
        Timeline clock = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e ->
                systemTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}
