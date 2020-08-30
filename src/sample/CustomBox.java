package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import static javafx.scene.paint.Color.rgb;

public class CustomBox {

    private static TextField testField;

    public static String display(String pomTime, String shortTime, String longTime) throws FileNotFoundException {

        //AtomicBoolean answer = new AtomicBoolean(false);  // To check whether accept button was selected

        Color lightRedColor = rgb(197, 94, 94);
        Color offWhiteColor = rgb(255, 237, 229);
        Insets inset1 = new Insets(0.0);

        FileInputStream iStream20 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\saveButton.png");
        Image saveButton = new Image(iStream20);

        FileInputStream iStream21 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\loadButton.png");
        Image loadButton = new Image(iStream21);

        FileInputStream iStream22 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\acceptButton.png");
        Image acceptButton = new Image(iStream22);


        Stage customTimerStage = new Stage();             // Creating a stage
        customTimerStage.setTitle("Enter Custom Timer");  // Setting title of custom timer window
        customTimerStage.initModality(Modality.APPLICATION_MODAL);  // Blocks user interaction until info window is closed
        Text lengthLabel = new Text("Pomodoro");       // Label to hold length of pomodoro
        Text shrtBreakLabel = new Text("Short Break"); // Label to hold length of short break
        Text lngBreakLabel = new Text("Long Break");   // Label to hold length of long break
        TextField pomTxtFld = new TextField();            // TextField for pomodoro length ui
        TextField shtBKTF = new TextField();              // TextField for short break ui
        TextField lngBkTF = new TextField();              // TextField for long break ui
        GridPane customTimerPane = new GridPane();        // Creating a new GridPane

        testField = new TextField();

        Button saveButton2 = new Button();
        ImageView saveButtonImageView = new ImageView(saveButton);
        saveButton2.setGraphic(saveButtonImageView);
        saveButton2.setPadding(inset1);

        Button loadButton2 = new Button();
        ImageView loadButtonImageView = new ImageView(loadButton);
        loadButton2.setGraphic(loadButtonImageView);
        loadButton2.setPadding(inset1);

        Button acceptButton2 = new Button();
        ImageView acceptButtonImageView = new ImageView(acceptButton);
        acceptButton2.setGraphic(acceptButtonImageView);
        acceptButton2.setPadding(inset1);



        // Event handler to bring up save dialog box and save the inputs
        EventHandler<MouseEvent> save2Event = mouseEvent1 -> {

            // Body of event handler
            FileChooser fileChooser1 = new FileChooser();

            // Set extension filter for text files
            FileChooser.ExtensionFilter myFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser1.getExtensionFilters().add(myFilter);

            // Show save dialog box
            File myFile = fileChooser1.showSaveDialog(customTimerStage);

            if (myFile != null) {
                saveTextToFile(pomTxtFld.getText(), shtBKTF.getText(), lngBkTF.getText(), myFile);
            }
        };
        saveButton2.addEventFilter(MouseEvent.MOUSE_CLICKED, save2Event);

        // Default values for text fields
        String defaultPom = "25";
        String defaultShort = "5";
        String defaultLong = "15";

        pomTxtFld.setText(defaultPom);
        shtBKTF.setText(defaultShort);
        lngBkTF.setText(defaultLong);

        // Event handler to populate text fields by loading a text file
        EventHandler<MouseEvent> load2Event = mouseEvent12 -> {

            // Selecting file to use
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(customTimerStage);

            // Clear TextFields
            pomTxtFld.clear();
            shtBKTF.clear();
            lngBkTF.clear();

            // Populating textfields
            try {
                loadFile(selectedFile, pomTxtFld, shtBKTF, lngBkTF);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        loadButton2.addEventFilter(MouseEvent.MOUSE_CLICKED, load2Event);

        //boolean isDefaultPom = null;
        boolean isDefaultShort;
        boolean isDefaultLong;

//        if (pomTxtFld.getText().equals(defaultPom))
//            isDefaultPom = true;
        if (shtBKTF.getText().equals(defaultShort))
            isDefaultShort = true;
        if (lngBkTF.getText().equals(defaultLong))
            isDefaultLong = true;



        // Event handler for accept button
        EventHandler<MouseEvent> accept2Event = mouseEvent3 -> {
//            if (isDefaultPom != true)
//                System.out.println("not true");
            customTimerStage.close();
        };
        acceptButton2.addEventFilter(MouseEvent.MOUSE_CLICKED, accept2Event);


        // Removing default focus from pomTxtFld on window open
        BooleanProperty focus = new SimpleBooleanProperty(true); // Stores focus on stage load
        pomTxtFld.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
            if(newValue && focus.get()){
                customTimerPane.requestFocus(); // Delegate the focus to container
                focus.setValue(false);
            }
        });


        // Setting font style for labels
        lengthLabel.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 15));
        shrtBreakLabel.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lngBreakLabel.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 15));

        // Setting color of labels
        lengthLabel.setFill(lightRedColor);
        shrtBreakLabel.setFill(lightRedColor);
        lngBreakLabel.setFill(lightRedColor);

        // Setting the width and heights of the TextFields
        pomTxtFld.setPrefWidth(450);
        pomTxtFld.setPrefHeight(32);
        shtBKTF.setPrefHeight(32);
        lngBkTF.setPrefHeight(32);

        // Creating a new background fill
        BackgroundFill cstm = new BackgroundFill(offWhiteColor, CornerRadii.EMPTY, Insets.EMPTY);

        // Creating a new background
        Background customTimeBkgnd = new Background(cstm);

        // Adding background color to pane
        customTimerPane.setBackground(customTimeBkgnd);

        // Setting the padding for the GridPane
        customTimerPane.setPadding(new Insets(10, 10, 10, 10));

        // Setting vertical and horizontal gaps between the columns
        customTimerPane.setVgap(10);
        customTimerPane.setHgap(5);

        // Setting Grid alignment
        customTimerPane.setAlignment(Pos.TOP_LEFT);

        // Arranging all the nodes in the grid
        customTimerPane.add(lengthLabel,    0, 0);
        customTimerPane.add(pomTxtFld,      0, 1);
        customTimerPane.add(shrtBreakLabel, 0, 2);
        customTimerPane.add(shtBKTF,        0, 3);
        customTimerPane.add(lngBreakLabel,  0, 4);
        customTimerPane.add(lngBkTF,        0, 5);
        customTimerPane.add(testField, 0, 6);
        customTimerPane.add(saveButton2,    1, 6);
        customTimerPane.add(loadButton2,    1, 7);
        customTimerPane.add(acceptButton2,  1, 8);

        // Adding pane to a new scene and setting scene to the stage
        customTimerStage.setScene(new Scene(customTimerPane, 615, 330));
        customTimerStage.showAndWait();  // Displaying stage
                                         // Blocks user interaction until info window is closed

        pomTime = pomTxtFld.getText();
        shortTime = shtBKTF.getText();
        longTime = lngBkTF.getText();

        String returnValue = pomTime + "\n" + shortTime + "\n" + longTime;

        return returnValue;

    }

    // To create a saved file
    public static void saveTextToFile(String field1, String field2, String field3, File file) {
        try{
            PrintWriter myWriter;
            myWriter = new PrintWriter(file);
            myWriter.println(field1 + "\n" + field2 + "\n" + field3);
            myWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void loadFile(File myFile, TextField txt1, TextField txt2, TextField txt3) throws IOException {

        try (Scanner myScan = new Scanner(myFile)) {

            ArrayList<String> fileLine = new ArrayList<>();

            // Populating ArrayList with file line scans
            while (myScan.hasNextLine()) {
                fileLine.add(myScan.nextLine());
            }
            // Converting ArrayList to object array
            Object[] objects = fileLine.toArray();

            // Displaying elements
            txt1.setText(String.valueOf(objects[0]));
            txt2.setText(String.valueOf(objects[1]));
            txt3.setText(String.valueOf(objects[2]));
        }
    }

}
