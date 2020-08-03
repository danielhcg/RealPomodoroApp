package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

// Classes I imported that didn't come with the sample
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.Group;

import java.io.IOException;

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
                            " 2. Work on task until timer is complete\n" +
                            " 3. After timer completion, put a checkmark on to-do list\n" +
                            " 4. Take a 5 minutes short break\n" +
                            " 5. After four \"Pomodoros\" take a long break\n" +
                            " 6. Repeat to step 1\n" +
                            "\nUSE THE LOOP BUTTON TO DO STEP 1 UNTIL STEP 5 IN A ROW\n";
                    whatIsText.setText(description);

                    Group whatIsGroup = new Group(whatIsText);

                    whatIsStage.setScene(new Scene(whatIsGroup, 450, 450));
                    whatIsStage.show();

                } finally {

                }

            }
        };
        // Adding even filter for what is button click
        whatIsButton.addEventFilter(MouseEvent.MOUSE_CLICKED, whatIsHandler);



        primaryStage.setScene(new Scene(gridPane, 700, 575));
        primaryStage.show();
        //sfsdf
    }


    public static void main(String[] args) {
        launch(args);
    }
}
