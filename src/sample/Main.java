package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

import javafx.animation.Timeline;
import javafx.animation.KeyValue;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import static javafx.scene.paint.Color.rgb;

// Classes I imported that didn't come with the sample
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;



public class Main extends Application {

    // Variables for timer
    private static final Integer STARTTIME = 1500;
    private Timeline timeline;
    private final Label timerLabel = new Label();
    private final IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);

    // To hold the times that the user specifies
    String duration = "25";
    String shortBreak = "5";
    String longBreak = "15";

    int durationInt, shortBreakInt, longBreakInt;


    @Override
    public void start(Stage primaryStage) throws Exception{

        /**-------------------------------------Variable Declarations-------------------------------------------*/



        // Creating colors to use in app
        Color lightRedColor = rgb(197, 94, 94);

        // Creating inset length for button borders, not sure why they appear when I import the images
        Insets inset1 = new Insets(0.0);

        // Images to be used throughout the app
        FileInputStream iStream1 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\titleImage.png");
        Image titleImage = new Image(iStream1);       // Title image


        FileInputStream iStream2 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\studyImage1.png");
        Image studyImage1 = new Image(iStream2);      // Main tomato image 1
        FileInputStream iStream3 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\shortBreakImage1.png");
        Image shortBreakImage1 = new Image(iStream3); // Short break tomato image 1
        FileInputStream iStream4 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\longBreakImage.png");
        Image longBreakImage = new Image(iStream4);   // Long break tomato image 1


        FileInputStream iStream5 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\studyImage2.png");
        Image studyImage2 = new Image(iStream5);      // Main tomato image 2
        FileInputStream iStream6 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\shortBreakImage2.png");
        Image shortBreakImage2 = new Image(iStream6); // Short break tomato image 2
        FileInputStream iStream7 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\longBreakImage2.png");
        Image longBreakImage2 = new Image(iStream7);  // Long break tomato image 2


        FileInputStream iStream8 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedMainPom.png");
        Image selectedMainPom = new Image(iStream8);    // Selected main pomodoro image
        FileInputStream iStream9 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedShortBreak.png");
        Image selectedShortBreak = new Image(iStream9); // Selected short break button image
        FileInputStream iStream10 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedLongBreak.png");
        Image selectedLongBreak = new Image(iStream10);  // Selected long break button image
        FileInputStream iStream11 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedLoop.png");
        Image selectedLoop = new Image(iStream11);        // Selected loop button image
        FileInputStream iStream12 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedCustom.png");
        Image selectedCustom = new Image(iStream12);     // Selected custom button image
        FileInputStream iStream13 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedWhatIs.png");
        Image selectedWhatIs = new Image(iStream13);     // Selected what is button image


        FileInputStream iStream14 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedMainPom.png");
        Image unselectedMainPom = new Image(iStream14);    // Unselected main pomodoro image
        FileInputStream iStream15 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedShortBreak.png");
        Image unselectedShortBreak = new Image(iStream15); // Unselected short break button image
        FileInputStream iStream16 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedLongBreak.png");
        Image unselectedLongBreak = new Image(iStream16);  // Unselected long break button image
        FileInputStream iStream17 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedLoop.png");
        Image unselectedLoop = new Image(iStream17);       // Unselected loop button image
        FileInputStream iStream18 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedCustom.png");
        Image unselectedCustom = new Image(iStream18);     // Unselected custom button image
        FileInputStream iStream19 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedWhatIs.png");
        Image unselectedWhatIs = new Image(iStream19);     // Unselected what is button image
        FileInputStream iStream20 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\restartButton.png");
        Image restartButtonImage = new Image(iStream20);     // Restart timer button image
        FileInputStream iStream21 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\startButton.png");
        Image startButtonImage = new Image(iStream21);     // Start timer button image
        FileInputStream iStream22 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\pauseButton.png");
        Image pauseButtonImage = new Image(iStream22);     // Pause timer button image


        GridPane root = new GridPane();          // Creating a grid pane


        /**----------------------------------------------Nodes-----------------------------------------------------*/
        ImageView titleView = new ImageView(titleImage); // To hold title image

        ToggleButton pomodoroToggle = new ToggleButton();
        ToggleButton shortToggle    = new ToggleButton();
        ToggleButton longToggle     = new ToggleButton();
        ToggleButton loopToggle     = new ToggleButton();
        ToggleButton whatIsToggle   = new ToggleButton();
        ToggleButton customToggle   = new ToggleButton();
        Button       restartButton  = new Button();
        Button       startButton    = new Button();
        Button       pauseButton    = new Button();

        // Grouping toggle buttons together
        ToggleGroup toggleGroup = new ToggleGroup();

        customToggle.   setToggleGroup(toggleGroup);
        whatIsToggle.   setToggleGroup(toggleGroup);
        pomodoroToggle. setToggleGroup(toggleGroup);
        shortToggle.    setToggleGroup(toggleGroup);
        longToggle.     setToggleGroup(toggleGroup);
        loopToggle.     setToggleGroup(toggleGroup);


        // Image views to store the images of buttons for toggling effect (Selected/Unselected)
        ImageView mainToggleIV   = new ImageView();
        ImageView shortToggleIV  = new ImageView();
        ImageView longToggleIV   = new ImageView();
        ImageView loopToggleIV   = new ImageView();
        ImageView whatIsToggleIV = new ImageView();
        ImageView customToggleIV = new ImageView();
        ImageView restartTimerIV = new ImageView(restartButtonImage);
        ImageView startTimerIV   = new ImageView(startButtonImage);
        ImageView pauseTimerIV   = new ImageView(pauseButtonImage);


        // Setting toggle effect image views to respective toggle button nodes
        pomodoroToggle. setGraphic(mainToggleIV);
        shortToggle.    setGraphic(shortToggleIV);
        longToggle.     setGraphic(longToggleIV);
        loopToggle.     setGraphic(loopToggleIV);
        whatIsToggle.   setGraphic(whatIsToggleIV);
        customToggle.   setGraphic(customToggleIV);
        restartButton.  setGraphic(restartTimerIV);
        startButton.    setGraphic(startTimerIV);
        pauseButton.    setGraphic(pauseTimerIV);



        // Setting the padding for each toggle button bc there's a border that forms when I display the images
        pomodoroToggle .setPadding(inset1);
        shortToggle    .setPadding(inset1);
        longToggle     .setPadding(inset1);
        loopToggle     .setPadding(inset1);
        whatIsToggle   .setPadding(inset1);
        customToggle   .setPadding(inset1);
        restartButton  .setPadding(inset1);
        startButton    .setPadding(inset1);
        pauseButton    .setPadding(inset1);


        // Binding selection images to respective toggle image views for each button
        mainToggleIV.imageProperty().bind(Bindings
                .when(pomodoroToggle.selectedProperty())
                .then(selectedMainPom)
                .otherwise(unselectedMainPom)
        );
        shortToggleIV.imageProperty().bind(Bindings
                .when(shortToggle.selectedProperty())
                .then(selectedShortBreak)
                .otherwise(unselectedShortBreak)
        );
        longToggleIV.imageProperty().bind(Bindings
                .when(longToggle.selectedProperty())
                .then(selectedLongBreak)
                .otherwise(unselectedLongBreak)
        );
        loopToggleIV.imageProperty().bind(Bindings
                .when(loopToggle.selectedProperty())
                .then(selectedLoop)
                .otherwise(unselectedLoop)
        );
        whatIsToggleIV.imageProperty().bind(Bindings
                .when(whatIsToggle.selectedProperty())
                .then(selectedWhatIs)
                .otherwise(unselectedWhatIs)
        );
        customToggleIV.imageProperty().bind(Bindings
                .when(customToggle.selectedProperty())
                .then(selectedCustom)
                .otherwise(unselectedCustom)
        );


        // Changing button image when user hovers over a specific button

        ImageView selectedMainPomHover =    new ImageView(selectedMainPom);      // ImageView's for when
        ImageView selectedShortBreakHover = new ImageView(selectedShortBreak);   // a button is hovered
        ImageView selectedLongBreakHover =  new ImageView(selectedLongBreak);    // over
        ImageView selectedLoopHover =       new ImageView(selectedLoop);
        ImageView selectedWhatIsHover =     new ImageView(selectedWhatIs);
        ImageView selectedCustomHover =     new ImageView(selectedCustom);

        pomodoroToggle.addEventHandler(MouseEvent.MOUSE_MOVED,           // Selected main pomodoro button
                mouseEvent -> pomodoroToggle.setGraphic(selectedMainPomHover)
        );
        shortToggle.addEventHandler(MouseEvent.MOUSE_MOVED,             // Selected short break button
                mouseEvent -> shortToggle.setGraphic(selectedShortBreakHover)
        );
        longToggle.addEventHandler(MouseEvent.MOUSE_MOVED,              // Selected long break button
                mouseEvent -> longToggle.setGraphic(selectedLongBreakHover)
        );
        loopToggle.addEventHandler(MouseEvent.MOUSE_MOVED,              // Selected loop button
                mouseEvent -> loopToggle.setGraphic(selectedLoopHover)
        );
        whatIsToggle.addEventHandler(MouseEvent.MOUSE_MOVED,            // Selected what is button
                mouseEvent -> whatIsToggle.setGraphic(selectedWhatIsHover)
        );
        customToggle.addEventHandler(MouseEvent.MOUSE_MOVED,            // Selected custom button
                mouseEvent -> customToggle.setGraphic(selectedCustomHover)
        );

        pomodoroToggle.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET,  // Unselected main pomodoro button
                mouseEvent -> pomodoroToggle.setGraphic(mainToggleIV)
        );
        shortToggle.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET,     // Unselected short break button
                mouseEvent -> shortToggle.setGraphic(shortToggleIV)
        );
        longToggle.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET,      // Unselected long break button
                mouseEvent -> longToggle.setGraphic(longToggleIV)
        );
        loopToggle.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET,      // Unselected loop button
                mouseEvent -> loopToggle.setGraphic(loopToggleIV)
        );
        whatIsToggle.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET,    // Unselected what is button
                mouseEvent -> whatIsToggle.setGraphic(whatIsToggleIV)
        );
        customToggle.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET,    // Unselected custom button
                mouseEvent -> customToggle.setGraphic(customToggleIV)
        );


        // Creating the animation for the main tomato image at the center of the screen
        ImageView tomato1 = new ImageView(studyImage1);
        ImageView tomato2 = new ImageView(studyImage2);

        Group tomato = new Group(tomato1);

        tomato1.setFitHeight(250);                                 // Set the size of the ImageView's
        tomato1.setFitWidth(250);
        tomato2.setFitHeight(250);
        tomato2.setFitWidth(250);

        Timeline main_tomato_image_timeline = new Timeline();      // New timeline set to cycle indefinitely
        main_tomato_image_timeline.setCycleCount(Timeline.INDEFINITE);

        main_tomato_image_timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1.0),
                (ActionEvent event) -> {                           // KeyFrame to switch image @ 1st second
                    tomato.getChildren().setAll(tomato2); }
        ));
        main_tomato_image_timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2.0),
                (ActionEvent event) -> {                           // KeyFrame to switch image @ 2nd second
                    tomato.getChildren().setAll(tomato1); }
        ));
        main_tomato_image_timeline.play();                         // Timeline execute command


        // Creating event handlers to change the animation image when certain buttons are clicked
        EventHandler<MouseEvent> changeMainToggle = mouseEvent -> {
            tomato1.setImage(studyImage1);
            tomato2.setImage(studyImage2);
        };  // When the main Pomodoro button is clicked
        pomodoroToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, changeMainToggle);

        EventHandler<MouseEvent> changeShortBreakImageToggle = mouseEvent -> {
            tomato1.setImage(shortBreakImage1);
            tomato2.setImage(shortBreakImage2);
            pomodoroToggle.setGraphic(mainToggleIV);
        };  // When short break button is clicked
        shortToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, changeShortBreakImageToggle);

        EventHandler<MouseEvent> changeLongBreakImageToggle = mouseEvent -> {
            tomato1.setImage(longBreakImage);
            tomato2.setImage(longBreakImage2);
        };  // When long break button is clicked
        longToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, changeLongBreakImageToggle);

        EventHandler<MouseEvent> changeToggleLoopImage = mouseEvent -> {
            tomato1.setImage(studyImage1);
            tomato2.setImage(studyImage2);
        };  // When loop button is clicked
        loopToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, changeToggleLoopImage);


        // Adding nodes to pane
        //                      column  row
        root.add(titleView,     0, 0);
        root.add(pomodoroToggle,0, 1);
        root.add(tomato,        0, 2);
        root.add(timerLabel,    0, 3);
        root.add(customToggle,  1, 0);
        root.add(shortToggle,   1, 1);
        root.add(whatIsToggle,  2, 0);
        root.add(longToggle,    2, 1);
        root.add(loopToggle,    3, 1);
        root.add(restartButton,0, 4);
        root.add(startButton,  0, 5);
        root.add(pauseButton,  0, 6);

        // Setting spacing between nodes on root pane
        root.setHgap(10);
        root.setVgap(10);


        // Creating the display for the timer
        timerLabel.textProperty().bind(timeSeconds.asString()); // Bind timerLabel text property to timeSeconds property
        timerLabel.setTextFill(Color.WHITE);
        timerLabel.setStyle("-fx-font-size: 4em;");

        restartButton.setOnAction(actionEvent -> {
            System.out.println("restart button works");
        });

        startButton.setOnAction(actionEvent -> {
            System.out.println("start button works");

            // Converting string values of times to integers
            durationInt = Integer.parseInt(duration);
            shortBreakInt = Integer.parseInt(shortBreak);
            longBreakInt = Integer.parseInt(longBreak);

            System.out.println(durationInt);

        });

        pauseButton.setOnAction(actionEvent -> {
            System.out.println("Puase button works");
        });

        longToggle.setOnAction(actionEvent -> {
            if (timeline != null) {
                timeline.stop();
            }
            timeSeconds.set(STARTTIME);
            timeline = new Timeline();
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(STARTTIME+1),
                            new KeyValue(timeSeconds, 0)));
            timeline.playFromStart();
        });  // Event handler for timer of 'longToggle' to trigger start of timer

        // Event handler that invokes the InfoBox class and calls the display method
        whatIsToggle.setOnAction(e -> InfoBox.display());

//        System.out.println(CustomBox.display(duration, shortBreak, longBreak));
//        String totalTime;
//        totalTime = CustomBox.display(duration, shortBreak, longBreak);
//        String[] timeArray = totalTime.split(" ");
//        duration = timeArray[0];
//        shortBreak = timeArray[1];
//        longBreak = timeArray[2];

//        AtomicReference<String> duration3 = null;
        String duration3;
        String shortBreak3;
        String longBreak3;

        // Event handler that invokes the CustomBox class and calls the display method
        customToggle.setOnAction(e -> {
            String duration2 = duration;
            String shortBreak2 = shortBreak;
            String longBreak2 = longBreak;

            try {

                //System.out.println(CustomBox.display(duration2, shortBreak2, longBreak2));

                String totalTime;
                totalTime = CustomBox.display(duration2, shortBreak2, longBreak2);
                String[] timeArray = totalTime.split(" ");


                duration2 = timeArray[0];
                shortBreak2 = timeArray[1];
                longBreak2 = timeArray[2];

//                assert false;
//                duration3.set(duration2);

                System.out.println("These are the times in try block: " + duration2 +" "+ shortBreak2 +" "+ longBreak2);


                //duration = duration2;


            } catch (Exception e1) { }
            //System.out.println(CustomBox.display(duration, shortBreak, longBreak));
            System.out.println("These are the times outside try block: " + duration2 +" "+ shortBreak2 +" "+ longBreak2);

            duration = duration2;
            shortBreak = shortBreak2;
            longBreak = longBreak2;

            //System.out.println(duration);

        });
//        System.out.println("Times outide event handler before manipulation: " + duration +" "+ shortBreak +" "+ longBreak);
//        Thread.sleep(5000);
//        System.out.println("These are the times outside the event handler: " + duration +" "+ shortBreak +" "+ longBreak);
//
//

        if (duration != "25") {
            System.out.println("You did it!");
        } else {
            System.out.println("You didn't do it, you suck");
        }

//        System.out.println(duration3);


//        String duration2 = duration;
//        String shortBreak2 = shortBreak;
//        String longBreak2 = longBreak;
//
//        customToggle.setOnAction(e -> {
//            String totalTime = CustomBox.display(duration2, shortBreak2, longBreak2);
//        });





        primaryStage.setTitle("Pomodoro Timer");
        // Creating a dark red background to set to the main stage
        Background darkRedBackground = new Background(new BackgroundFill(lightRedColor, CornerRadii.EMPTY, Insets.EMPTY));
        root.setBackground(darkRedBackground);   // Set the color of the background
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
