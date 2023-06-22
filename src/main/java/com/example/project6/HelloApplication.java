package com.example.project6;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    public static ArrayList<String> events = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Lockscreen.class.getResource("lockscreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 680);
        stage.setTitle("My Phone");
        Image image = new Image("logo.png");
        stage.getIcons().add(image);

        stage.setScene(scene);
        stage.show();
    }

    public static void displayLockscreen(Stage stage) throws IOException {
        FXMLLoader lockLoader = new FXMLLoader(Lockscreen.class.getResource("lockscreen.fxml"));
        Scene scene = new Scene(lockLoader.load(), 500, 680);
        stage.setTitle(Settings.getName());
        stage.setScene(scene);
    }

    public static void displayHome(Stage stage) throws IOException {
        FXMLLoader homeLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(homeLoader.load(), 500, 680);
        stage.setTitle(Settings.getName());
        stage.setScene(scene);
    }

    public static void displayCalculator(Stage stage) throws IOException{
        FXMLLoader calcLoader = new FXMLLoader(Calculator.class.getResource("calculator.fxml"));
        Scene scene = new Scene(calcLoader.load(), 500, 680);
        stage.setTitle(Settings.getName());
        stage.setScene(scene);
    }

    public static void displayNotepad(Stage stage) throws IOException{
        FXMLLoader noteLoader = new FXMLLoader(Notepad.class.getResource("notepad.fxml"));
        Scene scene = new Scene(noteLoader.load(), 500, 680);
        stage.setTitle(Settings.getName());
        stage.setScene(scene);
    }

    public static void displayClock(Stage stage) throws IOException{
        FXMLLoader clockLoader = new FXMLLoader(Clock.class.getResource("clock.fxml"));
        Scene scene = new Scene(clockLoader.load(), 500, 680);
        stage.setTitle(Settings.getName());
        stage.setScene(scene);
    }

    public static void displayTictactoe(Stage stage) throws IOException{
        FXMLLoader tictactoeLoader = new FXMLLoader(Tictactoe.class.getResource("tictactoe.fxml"));
        Scene scene = new Scene(tictactoeLoader.load(), 500, 680);
        stage.setTitle(Settings.getName());
        stage.setScene(scene);
    }

    public static void displaySettings(Stage stage) throws IOException{
        FXMLLoader settingsLoader = new FXMLLoader(Settings.class.getResource("settings.fxml"));
        Scene scene = new Scene(settingsLoader.load(), 500, 680);
        stage.setTitle(Settings.getName());
        stage.setScene(scene);
    }

    public static void displayCalendar(Stage stage) throws IOException{
        FXMLLoader calendarLoader = new FXMLLoader(Calendar.class.getResource("calendar.fxml"));
        Scene scene = new Scene(calendarLoader.load(), 500, 680);
        stage.setTitle(Settings.getName());
        stage.setScene(scene);
    }

    public static void displayMusic(Stage stage) throws IOException{
        FXMLLoader musicLoader = new FXMLLoader(Music.class.getResource("music.fxml"));
        Scene scene = new Scene(musicLoader.load(), 500, 680);
        stage.setTitle(Settings.getName());
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}