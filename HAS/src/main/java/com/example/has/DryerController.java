package com.example.has;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DialogPane;

import java.io.*;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class DryerController implements Initializable {

        @FXML
        DialogPane dialogPane;

        @FXML
        ChoiceBox<String> programs;


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
        programs.setItems(FXCollections.observableArrayList("Auto dry:Less", "Auto dry:Normal","Auto dry:High","70 Minutes","35 Minutes"));
    }
    void save() throws IOException {
        File file = new File("D:\\Java2\\HAS\\history.txt");
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        writer.write("\nChoice: " +"Dryer");
        writer.write("\n Programs: " + programs.getValue());
        writer.write("\n Date & Time: "+ ZonedDateTime.now());
        writer.write("\n-------------------------------------------------");
        writer.close();
    }
}
