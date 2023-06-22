package com.example.project6;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.project6.HelloApplication.events;

public class Calendar implements Initializable {
    @FXML
    private AnchorPane calendarApp;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button homeButton;

    @FXML
    private Label time;

    @FXML
    private TextArea eventText;

    @FXML
    void datePicked(ActionEvent event){
        LocalDate d = datePicker.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedString = d.format(formatter);
        events.add(eventText.getText());
        events.add(formattedString);

        eventText.setText("");

        for (int i = events.size() - 3; i >= 0; i--){
            if (events.get(i).equals(formattedString)){
                eventText.setText(events.get(i+1));
            }
        }
    }

    @FXML
    void goHome(ActionEvent event) throws IOException{
        LocalDate d = datePicker.getValue();
        if (d != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
            String formattedString = d.format(formatter);
            events.add(eventText.getText());
            events.add(formattedString);
        }


        Stage stage = (Stage) calendarApp.getScene().getWindow();
        HelloApplication.displayHome(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}