package com.example.has;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;

public class HomePageController {


    @FXML
    void aboutUs(ActionEvent event) {

    }
    @FXML
    void history(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("history.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Your History");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void alarmClock(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("alarm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Home Automation System");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void dishwasher(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dishwasher.fxml"));
        DialogPane pane = fxmlLoader.load();
        DishController dishControllerr= fxmlLoader.getController();
        Dialog<ButtonType>dialog=new Dialog<>();
        dialog.setDialogPane(pane);
        dialog.setTitle("Dishwasher");
        Optional<ButtonType>clickedButton = dialog.showAndWait();
        if(clickedButton.get()==ButtonType.APPLY)
        {
            if(dishControllerr.programs.getValue()==null&&dishControllerr.temprature==null&&dishControllerr.rpm==null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Required");
                alert.setHeaderText("Please select Options");
                alert.showAndWait();
            }
            else
            {
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Your dishwasher is started");
                alert.showAndWait();
                dishControllerr.save();

            }
        }
    }

    @FXML
    void door(MouseEvent event) {

    }

    @FXML
    void dryer(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dryer.fxml"));
        DialogPane pane = fxmlLoader.load();
        DryerController dryerController= fxmlLoader.getController();
        Dialog<ButtonType>dialog=new Dialog<>();
        dialog.setDialogPane(pane);
        dialog.setTitle("Dryer");
        Optional<ButtonType>clickedButton = dialog.showAndWait();
        if(clickedButton.get()==ButtonType.APPLY)
        {
            if(dryerController.programs.getValue()==null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Required");
                alert.setHeaderText("Please select Options");
                alert.showAndWait();
            }
            else
            {
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Your dryer is started");
                alert.showAndWait();
                dryerController.save();

            }
        }


    }
    @FXML
    void light(MouseEvent event) {

    }

    @FXML
    void microwave(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("microwave.fxml"));
        DialogPane pane = fxmlLoader.load();
        MwController mwController = fxmlLoader.getController();
        Dialog<ButtonType>dialog=new Dialog<>();
        dialog.setDialogPane(pane);
        dialog.setTitle("Microwave");

        Optional<ButtonType>clickedButton = dialog.showAndWait();
        if(clickedButton.get()==ButtonType.APPLY)
        {
            if(mwController.text.getText()==null || mwController.programs.getToggles().isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Required");
                alert.setHeaderText("Please select Options");
                alert.showAndWait();
            }
            else
            {
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Your Microwave is started");
                alert.showAndWait();
                    mwController.save();
            }
        }


    }

    @FXML
    void washingMachine(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wm.fxml"));
        DialogPane pane = fxmlLoader.load();
        WmController wmController = fxmlLoader.getController();
        Dialog<ButtonType>dialog=new Dialog<>();
        dialog.setDialogPane(pane);
        dialog.setTitle("Washing Machine");
        Optional<ButtonType>clickedButton = dialog.showAndWait();
        if(clickedButton.get()==ButtonType.APPLY)
        {
            if(wmController.speedPerfect.getValue()==null&&wmController.rpm.getValue()==null&&wmController.programs.getValue()==null&&wmController.temprature.getValue()==null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Required");
                alert.setHeaderText("Please select Options");
                alert.showAndWait();
            }
            else
            {
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Your Washing machine is started");
                alert.showAndWait();
                wmController.save();

            }
        }
    }
}
