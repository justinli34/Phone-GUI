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

import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javax.security.auth.login.AccountNotFoundException;
import javax.sound.sampled.*;

public class Music implements Initializable{

    @FXML
    private Label time;

    @FXML
    private Button homeButton;

    @FXML
    private AnchorPane musicApp;

    @FXML
    private Button song1;

    @FXML
    private Button song2;

    @FXML
    private Button song3;

    @FXML
    private Button song4;

    @FXML
    private Button pauseButton;

    public static Clip clip;

    public static boolean playing = false;
    @FXML
    private Button playButton;

    private static String song = "";

    public static String getSong(){
        return song;
    }

    @FXML
    void playSong1(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        if(!playing)
        {
            AudioInputStream audioInputStream;

            audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/faded.wav"));

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.start();
            playing = true;
            song = "Alan Walker - Faded";
        }
        else {
            clip.stop();
            AudioInputStream audioInputStream;

            audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/faded.wav"));

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.start();
            playing = true;
            song = "Alan Walker - Faded";
        }


    }

    @FXML
    void playSong2(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException {


        if(!playing)
        {
            AudioInputStream audioInputStream;

            audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/get busy.wav"));

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.start();
            playing = true;
            song = "Yeat - Get Busy";
        }
        else {
            clip.stop();
            AudioInputStream audioInputStream;

            audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/get busy.wav"));

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.start();
            playing = true;
            song = "Yeat - Get Busy";
        }


    }

    @FXML
    void playSong3(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        if(!playing)
        {
            AudioInputStream audioInputStream;

            audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/dont stop me now.wav"));

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.start();
            playing = true;
            song = "Queen - Don't Stop Me Now";
        }
        else {
            clip.stop();
            AudioInputStream audioInputStream;

            audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/dont stop me now.wav"));

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.start();
            playing = true;
            song = "Queen - Don't Stop Me Now";
        }


    }

    @FXML
    void playSong4(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException {


        if(!playing)
        {
            AudioInputStream audioInputStream;

            audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/karma police.wav"));

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.start();
            playing = true;
            song = "Radiohead - Karma Police";
        }
        else {
            clip.stop();
            AudioInputStream audioInputStream;

            audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/karma police.wav"));

            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.start();
            playing = true;
            song = "Radiohead - Karma Police";
        }


    }

    @FXML
    void pause(ActionEvent event)
    {
        clip.stop();
        playing = false;
    }

    @FXML
    void play(ActionEvent event){
        clip.start();
        playing = true;

    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) musicApp.getScene().getWindow();
        HelloApplication.displayHome(stage);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        playButton.setStyle(
                "-fx-background-radius: 50em; " +
                        "-fx-min-width: 60px; " +
                        "-fx-min-height: 60px; " +
                        "-fx-max-width: 60px; " +
                        "-fx-max-height: 60px;" +
                        "-fx-background-color: #FFFFFF;"
        );
        pauseButton.setStyle(
                "-fx-background-radius: 50em; " +
                        "-fx-min-width: 60px; " +
                        "-fx-min-height: 60px; " +
                        "-fx-max-width: 60px; " +
                        "-fx-max-height: 60px;" +
                        "-fx-background-color: #FFFFFF;"
        );
    }

}
