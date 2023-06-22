package com.example.project6;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.AttributeView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Notepad implements Initializable{

    @FXML
    private Label time;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField fontSizeBox;

    @FXML
    private Button homeButton;

    @FXML
    private TextArea note;

    @FXML
    private AnchorPane noteApp;

    private static String text = "";

    @FXML
    String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

    @FXML
    void changeColor(ActionEvent event) {
        String n = fontSizeBox.getText();
        Color myColor = colorPicker.getValue();
        String s = toRGBCode(myColor);
        note.setStyle("-fx-text-fill: " + s + "; -fx-font-size: " + n + "px;");
    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        text = note.getText();
        Stage stage = (Stage) noteApp.getScene().getWindow();
        HelloApplication.displayHome(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        note.setText(text);
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }
}
