package com.example.project6;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.AttributeView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Calculator implements Initializable{
    private String ans = "";
    private ArrayList<String> inputs = new ArrayList<String>();
    @FXML
    public AnchorPane ap2;
    @FXML
    private Button eight;
    @FXML
    private Button five;
    @FXML
    private Button four;
    @FXML
    private Button homeButton;
    @FXML
    private Button nine;
    @FXML
    private Button one;
    @FXML
    private Button seven;
    @FXML
    private Button six;
    @FXML
    private Button three;
    @FXML
    private Button two;
    @FXML
    private Button zero;
    @FXML
    private Label panel;
    @FXML
    private Button allClear;
    @FXML
    private Button decimalButton;
    @FXML
    private Button signButton;
    @FXML
    private Button plusButton;
    @FXML
    private Button minusButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button divisionButton;
    @FXML
    private Button equalsButton;
    @FXML
    private Label time;

    @FXML
    void solve(ActionEvent event){
        inputs.add(ans);
        double solution = Double.parseDouble(inputs.get(0));

        for (int i = 1; i < inputs.size()-1; i+=2){
            if (inputs.get(i).equals("+")){
                solution += Double.parseDouble(inputs.get(i+1));
            }
            else if (inputs.get(i).equals("-")){
                solution -= Double.parseDouble(inputs.get(i+1));
            }
            else if (inputs.get(i).equals("*")){
                solution *= Double.parseDouble(inputs.get(i+1));
            }
            else if (inputs.get(i).equals("/")){
                solution /= Double.parseDouble(inputs.get(i+1));
            }
        }

        String s = Double.toString(solution);
        if (s.contains("E")){
            panel.setText(s.substring(0, s.indexOf("E") - 8) + s.substring(s.indexOf("E")));
        }
        else{
            panel.setText(s);
        }

        ans = "" + solution;
        inputs.clear();
    }

    @FXML
    void add(ActionEvent event){
        inputs.add(ans);
        inputs.add("+");
        ans = "";
    }

    @FXML
    void subtract(ActionEvent event){
        inputs.add(ans);
        inputs.add("-");
        ans = "";
    }

    @FXML
    void multiply(ActionEvent event){
        inputs.add(ans);
        inputs.add("*");
        ans = "";
    }

    @FXML
    void divide(ActionEvent event){
        inputs.add(ans);
        inputs.add("/");
        ans = "";
    }

    @FXML
    void changeSign(ActionEvent event){
        if (ans.charAt(0) == '-'){
            ans = ans.substring(1);
        }
        else {
            ans = "-" + ans;
        }
        panel.setText(ans);
    }

    @FXML
    void addDecimalPoint(ActionEvent event){
        if (ans.length() < 11 && !ans.contains(".")){
            ans += ".";
            panel.setText(ans);
        }
    }

    @FXML
    void inEight(ActionEvent event) {
        if (ans.length() < 11) {
            ans += "8";
            panel.setText(ans);
        }
    }

    @FXML
    void inFive(ActionEvent event) {
        if (ans.length() < 11) {
            ans += "5";
            panel.setText(ans);
        }
    }

    @FXML
    void inFour(ActionEvent event) {
        if (ans.length() < 11) {
            ans += "4";
            panel.setText(ans);
        }
    }

    @FXML
    void inNine(ActionEvent event) {
        if (ans.length() < 11) {
            ans += "9";
            panel.setText(ans);
        }
    }

    @FXML
    void inOne(ActionEvent event) {
        if (ans.length() < 11) {
            ans += "1";
            panel.setText(ans);
        }
    }

    @FXML
    void inSeven(ActionEvent event) {
        if (ans.length() < 11) {
            ans += "7";
            panel.setText(ans);
        }
    }

    @FXML
    void inSix(ActionEvent event) {
        if (ans.length() < 11) {
            ans += "6";
            panel.setText(ans);
        }
    }

    @FXML
    void inThree(ActionEvent event) {
        if (ans.length() < 11) {
            ans += "3";
            panel.setText(ans);
        }
    }

    @FXML
    void inTwo(ActionEvent event) {
        if (ans.length() < 11) {
            ans += "2";
            panel.setText(ans);
        }
    }

    @FXML
    void inZero(ActionEvent event) {
        if (ans.length() < 11) {
            ans += "0";
            panel.setText(ans);
        }
    }

    @FXML
    public void goHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ap2.getScene().getWindow();
        HelloApplication.displayHome(stage);
    }

    @FXML
    void clear(ActionEvent event) {
        ans = "";
        panel.setText("" + 0);
        inputs.clear();
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
