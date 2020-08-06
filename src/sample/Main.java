package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


import javafx.scene.text.Font;
import javafx.stage.Stage;

// Classes I imported that didn't come with the sample
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import static javafx.scene.text.FontWeight.*;

import java.io.IOException;

import static javafx.scene.paint.Color.rgb;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Pomodoro Timer");

        // Creating button nodes.
        Button customTimerButton = new Button("Custom Timer");
        Button whatIsButton = new Button("What is Pomodoro Timer?");
        Button pomodoroButton = new Button("Pomodoro");
        Button shortBreakButton = new Button("Short Break");
        Button longBreakButton= new Button("Long Break");
        Button loopButton = new Button("Loop");



        // Creating a label node.
        Label titleLabel = new Label("Pomodoro Timer");

        // Creating a grid pane
        GridPane gridPane = new GridPane();

        // Creating an object of the hbox class to store custom timer and what is buttons.
        //HBox upperBox = new HBox();

        // Setting spacing in between "upperBox" nodes
        //upperBox.setSpacing(10.5);

        // Creating a color object for title text of what is popup text nodes
        Color titleTextColor = rgb(165, 43, 52);
        // Creating a color object for the background
        Color backgroundColor = rgb(197, 94, 94);
        // Creating color object for button background
        Color buttonBackground = rgb(255, 237, 229);
        // creating a background fill
        BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
        // creating a background
        Background backGround = new Background(backgroundFill);
        // set background to gridpane
        gridPane.setBackground(backGround);

        // Styling button nodes
        //customTimerButton.setStyle("-fx-background-color: titleTextColor;");


        // Adding nodes to pane
        gridPane.add(titleLabel,       0, 0);
        gridPane.add(customTimerButton,1, 0);
        gridPane.add(whatIsButton,     2, 0);

        gridPane.add(pomodoroButton,  0, 1);
        gridPane.add(shortBreakButton,1, 1);
        gridPane.add(longBreakButton, 2, 1);
        gridPane.add(loopButton,      3, 1);

        // Setting spacing between nodes on gridpane
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Creating the event handler to open a new information window when what is button is clicked
        EventHandler<MouseEvent> whatIsHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                // Opening a new window what button is clicked
                try {

                    Stage whatIsStage = new Stage();
                    whatIsStage.setTitle("What is a Pomodoro Timer?");

                    // Text to display discription of what is window purpose
                    Text whatIsText = new Text();
                    String description = "Online Pomodoro Timer\n\n" +
                            "TomatoTimers is a customizable and easy to use looping pomodoro timer to boost \nyour efficiency.\n" +
                            "\n" +
                            "About Pomodoro Technique\n" +
                            "Pomodoro™ Technique is a time management method developed by \nFrancesco Cirillo in the late 1980s. This technique use timer to break down works \ninto a set of intervals separated by breaks. Pomodoro technique increases \nproductivity by taking short scheduled breaks regularly.\n" +
                            "\n" +
                            "How to use Pomodoro/ Tomato timers:\n" +
                            "\n 1. Decide task to be done set timers to 25 minutes for one Pomodoro\n" +
                            "\n 2. Work on task until timer is complete\n" +
                            "\n 3. After timer completion, put a checkmark on to-do list\n" +
                            "\n 4. Take a 5 minutes short break\n" +
                            "\n 5. After four \"Pomodoros\" take a long break\n" +
                            "\n 6. Repeat to step 1\n" +
                            "\nUSE THE LOOP BUTTON TO DO STEP 1 UNTIL STEP 5 IN A ROW\n";

                    // Declaring paragraph title string variables
                    String onlinePTimer    = "Online Pomodoro Timer";
                    String aboutTechnique = "About Pomodoro Technique";
                    String howToUse       = "How to use Pomodoro/Tomato timers";

                    // Declaring paragraph string variables
                    String onlinePTimerParagraph = "TomatoTimers is a customizable and easy to use looping " +
                            "pomodoro timer to boost your efficiency.";
                    String aboutParagraph = "Pomodoro Technique is a time management method developed by " +
                            "Francesco Cirillo in the late 1980s. \nThis technique use timer to break down " +
                            "works into a set of intervals separated by breaks. Pomodoro \ntechnique increases " +
                            "productivity by taking short scheduled breaks regularly.";
                    String howToParagraph = " 1. Decide task to be done set timers to 25 minutes for one Pomodoro\n" +
                                            " 2. Work on task until timer is complete\n" +
                                            " 3. After timer completion, put a checkmark on to-do list\n" +
                                            " 4. Take a 5 minutes short break\n" +
                                            " 5. After four Pomodoro take a long break\n" +
                                            " 6. Repeat step 1\n\n" +
                                            "USE THE LOOP BUTTON TO DO STEP 1 UNTIL STEP 5 IN A ROW";

                    // Creating text objects and Storing paragraph and title string variables in text objects
                    Text title1 = new Text(onlinePTimer);
                    Text title2 = new Text(aboutTechnique);
                    Text title3 = new Text(howToUse);
                    Text para1 = new Text(onlinePTimerParagraph);
                    Text para2 = new Text(aboutParagraph);
                    Text para3 = new Text(howToParagraph);

                    // Setting the positions of the nodes
                    title1.setX(17);
                    title1.setY(35);
                    para1.setX(17);
                    para1.setY(60);

                    title2.setX(17);
                    title2.setY(85);
                    para2.setX(17);
                    para2.setY(110);

                    title3.setX(17);
                    title3.setY(170);
                    para3.setX(17);
                    para3.setY(195);

                    // Setting fonts of title text objects
                    title1.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 15));
                    title2.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 15));
                    title3.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 15));

                    // Setting color of title text objects
                    title1.setFill(titleTextColor);
                    title2.setFill(titleTextColor);
                    title3.setFill(titleTextColor);

                    // Setting font stylings for paragraphs objects
                    para1.setFont(Font.font("veranda", FontWeight.BOLD, FontPosture.REGULAR, 12));
                    para2.setFont(Font.font("veranda", FontWeight.BOLD, FontPosture.REGULAR, 12));
                    para3.setFont(Font.font("veranda", FontWeight.BOLD, FontPosture.REGULAR, 12));

                    // Setting color of paragraph text
                    para1.setFill(backgroundColor);
                    para2.setFill(backgroundColor);
                    para3.setFill(backgroundColor);


                    whatIsText.setText(description);

                    Group whatIsGroup = new Group(whatIsText);

                    // Creating a new pane and adding description text to it
                    Pane whatIsPane = new Pane(title1, title2, title3, para1, para2, para3);

                    // Creating a new background fill
                    BackgroundFill whatIsBackGroundFill = new BackgroundFill(buttonBackground, CornerRadii.EMPTY, Insets.EMPTY);

                    // Creating a new background
                    Background whatIsBackGround = new Background(whatIsBackGroundFill);

                    // Adding background color to pane
                    whatIsPane.setBackground(whatIsBackGround);

                    whatIsStage.setScene(new Scene(whatIsPane, 615, 330));
                    whatIsStage.show();

                } finally {

                }
            }
        };
        // Adding event filter for what is button click
        whatIsButton.addEventFilter(MouseEvent.MOUSE_CLICKED, whatIsHandler);

        // Creating event handler to open a new window when the custom timer button is clicked
        EventHandler<MouseEvent> customTimerHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Opening a new window when customer timer button is clicked
                try {
                    Stage customTimerStage = new Stage();             // Creating a stage
                    customTimerStage.setTitle("Enter Custom Timer");  // Setting title of custom timer window
                    Text lengthLabel = new Text("Pomodoro");       // Label to hold length of pomodoro
                    Text shrtBreakLabel = new Text("Short Break"); // Label to hold length of short break
                    Text lngBreakLabel = new Text("Long Break");   // Label to hold length of long break
                    TextField pomTxtFld = new TextField();            // TextField for pomodoro length ui
                    TextField shtBKTF = new TextField();              // TextField for short break ui
                    TextField lngBkTF = new TextField();              // TextField for long break ui

                    // Setting font style for labels
                    lengthLabel.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 15));
                    shrtBreakLabel.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 15));
                    lngBreakLabel.setFont(Font.font("impact", FontWeight.BOLD, FontPosture.REGULAR, 15));

                    // Setting color of labels
                    lengthLabel.setFill(backgroundColor);
                    shrtBreakLabel.setFill(backgroundColor);
                    lngBreakLabel.setFill(backgroundColor);

                    // Setting the width and heights of the TextFields
                    pomTxtFld.setPrefWidth(450);
                    pomTxtFld.setPrefHeight(32);
                    shtBKTF.setPrefHeight(32);
                    lngBkTF.setPrefHeight(32);

                    // Creating a new GridPane
                    GridPane customTimerPane = new GridPane();

                    // Creating a new background fill
                    BackgroundFill cstm = new BackgroundFill(buttonBackground, CornerRadii.EMPTY, Insets.EMPTY);

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

                    // Adding pane to a new scene and setting scene to the stage
                    customTimerStage.setScene(new Scene(customTimerPane, 615, 330));
                    customTimerStage.show();  // Displaying stage

                } finally {

                }
            }
        };
        // Adding event filter for custom timer button click
        customTimerButton.addEventFilter(MouseEvent.MOUSE_CLICKED, customTimerHandler);

        primaryStage.setScene(new Scene(gridPane, 700, 575));

        primaryStage.show();
        //sfsdf
    }


    public static void main(String[] args) {
        launch(args);
    }
}
