package com.example.has;

import javafx.css.Size;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.StreamCorruptedException;

public class HelloController {
    @FXML
    private Button login;
    
    Stage stage;
    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private PasswordField password;


    @FXML
    void click(ActionEvent event) throws IOException {
        if (password.getText().equals("1234"))
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homePage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Home Automation System");
            stage.setScene(scene);
            stage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText("Please Enter a valid PIN!");
            alert.showAndWait();
            //alertHandling("Error Massage","Please Enter Valid PIN",false,false);
        }
    }
}