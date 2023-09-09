package com.example.has;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.Timer;

public class AlarmController implements Initializable {
    @FXML
    private ComboBox<Integer> hour;

    @FXML
    private ComboBox<Integer> minute;
    @FXML
    private Label musicLabel;

    private Alert alert;

    private int response;

    private Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    private Label clock;
    private JFileChooser fc;
    private File selectedFile;



    private int value=0,index=0;

    private String choice,program;
    @FXML
    private Button listenMusic;

    @FXML
    private Button save;

    @FXML
    void addMusic(ActionEvent event) {
        fc = new JFileChooser();
        response = fc.showOpenDialog(null);
        if (response == fc.APPROVE_OPTION) {
            selectedFile = fc.getSelectedFile();
            musicLabel.setText("Music: " + fc.getSelectedFile());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Music Required");
            alert.setHeaderText("Please Choose Alarm Music!");
            alert.showAndWait();
        }
    }
    @FXML
    void hourCombo(ActionEvent event) {
    }
    @FXML
    void listenMusic(ActionEvent event) {
        if (musicLabel.getText() != "") {
            if (listenMusic.getText().equals("Listen")) {
                playAlarm();
                listenMusic.setText("Stop Sound");
            } else if (listenMusic.getText().equals("Stop Sound")) {
                stopAlarm();
                listenMusic.setText("Listen");
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Music Required");
            alert.setHeaderText("Please Choose Alarm Music!");
            alert.showAndWait();
        }
    }
    @FXML
    void minuteCombo(ActionEvent event) {
    }
    @FXML
    void setAlarm(ActionEvent event) {
        if (musicLabel.getText() != "" && value==1) {
            alarmTime(hour.getValue().intValue(), minute.getValue().intValue());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Music Required");
            alert.setHeaderText("Please Choose Alarm Music!");
            alert.showAndWait();
        }
    }

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
        hour.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24));
        minute.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60));

    }
    public void playAlarm() {
        media = new Media(selectedFile.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
    public void stopAlarm() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
    public void alarmTime(final int hour, final int minute) {

                int time=0;
                while(time!=1)
                {
                    Calendar c = Calendar.getInstance();
                    int h = c.get(Calendar.HOUR);
                    int m = c.get(Calendar.MINUTE);
                     if(h==hour && m == minute) {
                         System.out.println(time);
                         time = 1;
                         playAlarm();
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("Alarm");
                         alert.setHeaderText(choice+" has been started");
                         alert.showAndWait();
                         stopAlarm();
                     }
                        else
                        {
                            time=0;
                            System.out.println(time);
                        }
                    }
                }
    @FXML
    void dishWasher(ActionEvent event) {
        List<String> choices = new ArrayList<String>();

        choices.add("Short Heated Dry");
        choices.add("Long Heated Dry");
        choices.add("Sanitize");
        ChoiceDialog<String> programs = new ChoiceDialog<>("Short Heated Dry", choices);
        programs.setTitle("Dishwasher Functions");
        programs.setHeaderText("Which program do you wanna set?");
        programs.setContentText("Your choice:");
        Optional<String> result = programs.showAndWait();
        if(result.isPresent())
        {
            choice="Dishwasher";
            value=1;
            program=programs.getSelectedItem();
        }
    }
    @FXML
    void door(ActionEvent event) {

    }
    @FXML
    void dryer(ActionEvent event) {
        List<String> choices = new ArrayList<String>();
        choices.add("Auto dry:Less");
        choices.add("Auto dry:Normal");
        choices.add("Auto dry:High");
        choices.add("70 Minutes");
        choices.add("35 Minutes");
        ChoiceDialog<String> programs = new ChoiceDialog<>("Auto dry:Normal", choices);
        programs.setTitle("Dryer Functions");
        programs.setHeaderText("Which program do you wanna set?");
        programs.setContentText("Your choice:");
        Optional<String> result = programs.showAndWait();
        if(result.isPresent())
        {
            choice = "Microwave";
            value = 1;
            program=programs.getSelectedItem();

        }
    }
    @FXML
    void lightFan(ActionEvent event) {

    }
    @FXML
    void microWave(ActionEvent event) {
        List<String> choices = new ArrayList<String>();
        choices.add("Popcorn");
        choices.add("Potato");
        choices.add("Pizza");
        choices.add("Beverage");
        choices.add("Frozen Dinner");
        choices.add("Reheat");
        ChoiceDialog<String> programs = new ChoiceDialog<>("Popcorn", choices);
        programs.setTitle("Microwave Functions");
        programs.setHeaderText("Which program do you wanna set?");
        programs.setContentText("Your choice:");
        Optional<String> result = programs.showAndWait();
        if(result.isPresent())
        {
            choice="Microwave";
            value=1;
            program=programs.getSelectedItem();
        }
    }
    @FXML
    void washingMachine(ActionEvent event) {
        List<String> choices = new ArrayList<String>();
        choices.add("Mixed Load");
        choices.add("Quick Wash(15 min)");
        choices.add("Quick wash(30 min)");
        choices.add("Rinse");
        choices.add("Drain");
        choices.add("Spin");
        ChoiceDialog<String> programs = new ChoiceDialog<>("Mixed Load", choices);
        programs.setTitle("Washing Machine Functions");
        programs.setHeaderText("Which program do you wanna set?");
        programs.setContentText("Your choice:");
        Optional<String> result = programs.showAndWait();
        if(result.isPresent())
        {
            choice="Wshing Machine";
            value=1;
            program=programs.getSelectedItem();
        }
    }
    @FXML
    void saveButton(ActionEvent event) throws IOException {
        if(value==1) {

            File file = new File("D:\\Java2\\HAS\\history.txt");
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            writer.write("\nChoice: " + choice);
            writer.write("\n Program: "+program);
            writer.write("\n Set Alarm: "+hour.getValue()+":"+minute.getValue());
            writer.write("\n Date & Time: "+ ZonedDateTime.now());
            writer.write("\n-------------------------------------------------");
            writer.close();
        }
    }
}

