package com.example.has;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.*;
import java.time.ZonedDateTime;

public class MwController {

    @FXML
    RadioButton beverage;

    @FXML
    DialogPane dialogPane;

    @FXML
    RadioButton frozenDinner;

    @FXML
    RadioButton pizza;

    @FXML
    RadioButton popcorn;

    @FXML
    RadioButton potato;

    @FXML
    ToggleGroup programs;

    @FXML
    RadioButton reheat;

    @FXML
    TextField text;

    void save() throws IOException {
        File file = new File("D:\\Java2\\HAS\\history.txt");
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        writer.write("\nChoice: " +"Microwave");
        writer.write("\n Programs: " + "");
        writer.write("\n Time: "+text.getText()+" minutes");
        writer.write("\n Date & Time: "+ ZonedDateTime.now());
        writer.write("\n-------------------------------------------------");
        writer.close();
    }
    @FXML
    void text(ActionEvent event) {
        programs.getSelectedToggle().setSelected(false);
    }
    @FXML
    void bev(ActionEvent event) {
        text.setDisable(true);

    }

    @FXML
    void frozen(ActionEvent event) {
        text.setDisable(true);

    }

    @FXML
    void pi(ActionEvent event) {
        text.setDisable(true);

    }

    @FXML
    void pop(ActionEvent event) {
        text.setDisable(true);

    }

    @FXML
    void pot(ActionEvent event) {
        text.setDisable(true);
    }

    @FXML
    void reh(ActionEvent event) {
        text.setDisable(true);

    }


}
