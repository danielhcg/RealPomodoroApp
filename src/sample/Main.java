package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

// Classes I imported that didn't come with the sample
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.paint.Color;

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


        // Creating a color object
        Color backgroundColor = rgb(197, 94, 94);
        // creating a background fill
        BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
        // creating a background
        Background backGround = new Background(backgroundFill);
        // set background to gridpane
        gridPane.setBackground(backGround);



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

                    // Declaring paragraph title string variables
                    String onlinePTimer    = "Online Pomodoro Timer";
                    String aboutTechnique = "About Pomodoro Technique";
                    String howToUse       = "How to use Pomodoro/Tomato timers";

                    // Declaring paragraph string variables
                    String onlinePTimerParagraph = "TomatoTimers is a customizable and easy to use looping " +
                            "pomodoro timer to boost your efficiency.";
                    String aboutParagraph = "Pomodoro™ Technique is a time management method developed by " +
                            "Francesco Cirillo in the late 1980s. This technique use timer to break down " +
                            "works into a set of intervals separated by breaks. Pomodoro technique increases " +
                            "productivity by taking short scheduled breaks regularly.";
                    String howToParagraph = " 1. Decide task to be done set timers to 25 minutes for one Pomodoro" +
                                            " 2. Work on task until timer is complete" +
                                            " 3. After timer completion, put a checkmark on to-do list" +
                                            " 4. Take a 5 minutes short break" +
                                            " 5. After four Pomodoro take a long break" +
                                            " 6. Repeat step 1" +
                                            "USE THE LOOP BUTTON TO DO STEP 1 UNTIL STEP 5 IN A ROW";

                    // Creating text objects and Storing paragraph and title string variables in text objects
                    Text title1 = new Text(onlinePTimer);
                    Text title2 = new Text(aboutTechnique);
                    Text title3 = new Text(howToUse);
                    Text para1 = new Text(onlinePTimerParagraph);
                    Text para2 = new Text(aboutParagraph);
                    Text para3 = new Text(howToParagraph);

                    // Setting the positions of the texts
                    title1.setX(50);
                    title1.setY(75);
                    para1.setX(50);
                    para1.setY(100);

                    title2.setX(50);
                    title2.setY(125);
                    para2.setX(50);
                    para2.setY(150);

                    title3.setX(50);
                    title3.setY(175);
                    para3.setX(50);
                    para3.setY(200);


                    whatIsText.setText(description);

                    Group whatIsGroup = new Group(whatIsText);

                    // Creating a new pane and adding description text to it
                    Pane whatIsPane = new Pane(title1, title2, title3, para1, para2, para3);

                    // Creating a new background fill
                    BackgroundFill whatIsBackGroundFill = new BackgroundFill(Color.rgb(255, 237, 229), CornerRadii.EMPTY, Insets.EMPTY);

                    // Creating a new background
                    Background whatIsBackGround = new Background(whatIsBackGroundFill);

                    // Adding background color to pane
                    whatIsPane.setBackground(whatIsBackGround);

                    whatIsStage.setScene(new Scene(whatIsPane, 798, 543));
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
