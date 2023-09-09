package com.example.has;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class WmController implements Initializable {

    @FXML
    DialogPane dialogPane;

    @FXML
    ChoiceBox<String> programs;

    @FXML
    ChoiceBox<String> rpm;

    @FXML
    ChoiceBox<String> speedPerfect;

    @FXML
    ChoiceBox<String> temprature;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        programs.setItems(FXCollections.observableArrayList("Mixed Load","Super Quick/15","Super Quick/30","Cottons","Jeans","Wool","Delicate","Silk","Drain"));
        speedPerfect.setItems(FXCollections.observableArrayList("Yes","No"));
        temprature.setItems(FXCollections.observableArrayList("15`C","30`C","60`C"));
        rpm.setItems(FXCollections.observableArrayList("800","1000","1200"));
    }
    void save() throws IOException {
        File file = new File("D:\\Java2\\HAS\\history.txt");
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        writer.write("\nChoice: " +"Washing Machine");
        writer.write("\n Program: "+programs.getValue());
        writer.write("\n RPM: "+rpm.getValue());
        writer.write("\n Temperature: "+temprature.getValue());
        writer.write("\n Speed Perfect: "+speedPerfect.getValue());
        writer.write("\n Date & Time: "+ ZonedDateTime.now());
        writer.write("\n-------------------------------------------------");
        writer.close();
    }

}
