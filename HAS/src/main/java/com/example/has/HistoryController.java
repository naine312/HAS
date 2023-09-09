package com.example.has;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import java.io.*;
import java.util.Scanner;

public class HistoryController {

    @FXML
    private TextArea textArea;

    @FXML
    void action(MouseEvent event) {
        try {
            File file = new File("D:\\Java2\\HAS\\history.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while( (line = reader.readLine())!=null)
            {
                textArea.appendText(line+"\n");
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }