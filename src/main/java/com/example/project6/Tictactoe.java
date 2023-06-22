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

import java.text.DecimalFormat;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Tictactoe implements Initializable{
    @FXML
    private Button bottomLeft;

    @FXML
    private Button bottomMid;

    @FXML
    private Button bottomRight;

    @FXML
    private Button homeButton;

    @FXML
    private Button midLeft;

    @FXML
    private Button midMid;

    @FXML
    private Button midRight;

    @FXML
    private Label oCount;

    @FXML
    private Button resetButton;

    @FXML
    private Button topLeft;

    @FXML
    private Button topMid;

    @FXML
    private Button topRight;

    @FXML
    private Label xCount;

    @FXML
    private AnchorPane tictactoeApp;

    @FXML
    private Label time;

    @FXML
    private Label winLabel;

    private int x = 1;
    private int xc = 0;
    private int oc = 0;

    @FXML
    void goHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) tictactoeApp.getScene().getWindow();
        HelloApplication.displayHome(stage);
    }

    @FXML
    void mark1(ActionEvent event){
        mark(topLeft);
    }
    @FXML
    void mark2(ActionEvent event){
        mark(topMid);
    }
    @FXML
    void mark3(ActionEvent event){
        mark(topRight);
    }
    @FXML
    void mark4(ActionEvent event){
        mark(midLeft);
    }
    @FXML
    void mark5(ActionEvent event){
        mark(midMid);
    }
    @FXML
    void mark6(ActionEvent event){
        mark(midRight);
    }
    @FXML
    void mark7(ActionEvent event){
        mark(bottomLeft);
    }
    @FXML
    void mark8(ActionEvent event){
        mark(bottomMid);
    }
    @FXML
    void mark9(ActionEvent event){
        mark(bottomRight);
    }
    void mark(Button b) {
        if (b.getText().equals("") && x < 10){
            if (x % 2 == 1 && x < 10) {
                b.setText("X");
            }
            else if (x % 2 == 0 && x < 10){
                b.setText("O");
            }
            x++;
            if (x == 10){
                winLabel.setText(" Draw!");
            }
            checkGameState();
        }
    }

    void checkGameState(){
        //horizontal
        if (topLeft.getText().equals(topMid.getText()) && topMid.getText().equals(topRight.getText()) && !topLeft.getText().equals("")){
            x = 10;
            gameStateHelper(topLeft);
        }
        else if (midLeft.getText().equals(midMid.getText()) && midMid.getText().equals(midRight.getText())&& !midLeft.getText().equals("")){
            x = 10;
            gameStateHelper(midLeft);
        }
        else if (bottomLeft.getText().equals(bottomMid.getText()) && bottomMid.getText().equals(bottomRight.getText())&& !bottomLeft.getText().equals("")){
            x = 10;
            gameStateHelper(bottomLeft);
        }
        //vertical
        else if (topLeft.getText().equals(midLeft.getText()) && midLeft.getText().equals(bottomLeft.getText())&& !topLeft.getText().equals("")){
            x = 10;
            gameStateHelper(topLeft);
        }
        else if (topMid.getText().equals(midMid.getText()) && midMid.getText().equals(bottomMid.getText())&& !topMid.getText().equals("")){
            x = 10;
            gameStateHelper(topMid);
        }
        else if (topRight.getText().equals(midRight.getText()) && midRight.getText().equals(bottomRight.getText())&& !topRight.getText().equals("")){
            x = 10;
            gameStateHelper(topRight);
        }
        //diagonal
        else if (topRight.getText().equals(midMid.getText()) && midMid.getText().equals(bottomLeft.getText())&& !topRight.getText().equals("")){
            x = 10;
            gameStateHelper(topRight);
        }
        else if (topLeft.getText().equals(midMid.getText()) && midMid.getText().equals(bottomRight.getText())&& !topLeft.getText().equals("")){
            x = 10;
            gameStateHelper(topLeft);
        }
    }

    void gameStateHelper(Button b){
        if (b.getText().equals("X")){
            xc++;
            xCount.setText("X: " + xc);
            winLabel.setText("X Wins!");
        }
        else{
            oc++;
            oCount.setText("O: " + oc);
            winLabel.setText("O Wins!");
        }
    }

    @FXML
    void reset(ActionEvent event) {
        topLeft.setText("");
        topMid.setText("");
        topRight.setText("");
        midLeft.setText("");
        midMid.setText("");
        midRight.setText("");
        bottomLeft.setText("");
        bottomMid.setText("");
        bottomRight.setText("");
        x = 1;
        winLabel.setText("");
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
