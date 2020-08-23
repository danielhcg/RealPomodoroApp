package sample;

import com.sun.glass.ui.CommonDialogs;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.lang.Thread;
import javafx.animation.Timeline;
import javafx.animation.KeyValue;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import static javafx.scene.paint.Color.rgb;

// Classes I imported that didn't come with the sample
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

//import javax.swing.filechooser.FileNameExtensionFilter;


public class Main extends Application {

    // Variables for timer
    private static final Integer STARTTIME = 1500;
    private Timeline timeline;
    private Label timerLabel = new Label();
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);

    @Override
    public void start(Stage primaryStage) throws Exception{

        /**-------------------------------------Variable Declarations-------------------------------------------*/

        // Creating colors to use in app
        Color darkRedColor = rgb(165, 43, 52);
        Color lightRedColor = rgb(197, 94, 94);
        Color offWhiteColor = rgb(255, 237, 229);

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
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\saveButton.png");
        Image saveButton = new Image(iStream20);
        FileInputStream iStream21 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\loadButton.png");
        Image loadButton = new Image(iStream21);


        GridPane root = new GridPane();          // Creating a grid pane


        /**----------------------------------------------Nodes-----------------------------------------------------*/
        ImageView titleView = new ImageView(titleImage); // To hold title image

        ToggleButton pomodoroToggle = new ToggleButton();
        ToggleButton shortToggle    = new ToggleButton();
        ToggleButton longToggle     = new ToggleButton();
        ToggleButton loopToggle     = new ToggleButton();
        ToggleButton whatIsToggle   = new ToggleButton();
        ToggleButton customToggle   = new ToggleButton();

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


        // Setting toggle effect image views to respective toggle button nodes
        pomodoroToggle. setGraphic(mainToggleIV);
        shortToggle.    setGraphic(shortToggleIV);
        longToggle.     setGraphic(longToggleIV);
        loopToggle.     setGraphic(loopToggleIV);
        whatIsToggle.   setGraphic(whatIsToggleIV);
        customToggle.   setGraphic(customToggleIV);


        // Setting the padding for each toggle button bc there's a border that forms when I display the images
        pomodoroToggle.setPadding(inset1);
        shortToggle.setPadding(inset1);
        longToggle.setPadding(inset1);
        loopToggle.setPadding(inset1);
        whatIsToggle.setPadding(inset1);
        customToggle.setPadding(inset1);


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
                mouseEvent -> { pomodoroToggle.setGraphic(selectedMainPomHover); }
        );
        shortToggle.addEventHandler(MouseEvent.MOUSE_MOVED,             // Selected short break button
                mouseEvent -> { shortToggle.setGraphic(selectedShortBreakHover); }
        );
        longToggle.addEventHandler(MouseEvent.MOUSE_MOVED,              // Selected long break button
                mouseEvent -> { longToggle.setGraphic(selectedLongBreakHover); }
        );
        loopToggle.addEventHandler(MouseEvent.MOUSE_MOVED,              // Selected loop button
                mouseEvent -> { loopToggle.setGraphic(selectedLoopHover); }
        );
        whatIsToggle.addEventHandler(MouseEvent.MOUSE_MOVED,            // Selected what is button
                mouseEvent -> { whatIsToggle.setGraphic(selectedWhatIsHover); }
        );
        customToggle.addEventHandler(MouseEvent.MOUSE_MOVED,            // Selected custom button
                mouseEvent -> { customToggle.setGraphic(selectedCustomHover); }
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

        // Setting spacing between nodes on root pane
        root.setHgap(10);
        root.setVgap(10);


        // Creating the display for the timer
        timerLabel.textProperty().bind(timeSeconds.asString()); // Bind timerLabel text property to timeSeconds property
        timerLabel.setTextFill(Color.WHITE);
        timerLabel.setStyle("-fx-font-size: 4em;");

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


        // Creating the event handler to open a new information window when what is button is clicked
        EventHandler<MouseEvent> whatIsHandler = mouseEvent -> {
            Stage whatIsStage = new Stage();
            whatIsStage.setTitle("What is a Pomodoro Timer?");

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
            title1.setFill(darkRedColor);
            title2.setFill(darkRedColor);
            title3.setFill(darkRedColor);

            // Setting font styling for paragraphs objects
            para1.setFont(Font.font("veranda", FontWeight.BOLD, FontPosture.REGULAR, 12));
            para2.setFont(Font.font("veranda", FontWeight.BOLD, FontPosture.REGULAR, 12));
            para3.setFont(Font.font("veranda", FontWeight.BOLD, FontPosture.REGULAR, 12));

            // Setting color of paragraph text
            para1.setFill(lightRedColor);
            para2.setFill(lightRedColor);
            para3.setFill(lightRedColor);

            // Creating a new pane and adding description text to it
            Pane whatIsPane = new Pane(title1, title2, title3, para1, para2, para3);

            // Creating a new background fill
            BackgroundFill whatIsBackGroundFill = new BackgroundFill(offWhiteColor, CornerRadii.EMPTY, Insets.EMPTY);
            Background whatIsBackGround = new Background(whatIsBackGroundFill); // Creating a new background
            whatIsPane.setBackground(whatIsBackGround);    // Adding background color to pane
            whatIsStage.setScene(new Scene(whatIsPane, 615, 330));
            whatIsStage.show();

        };
        whatIsToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, whatIsHandler);


        // Creating event handler to open a new window when the custom timer button is clicked
        EventHandler<MouseEvent> customTimerHandler = mouseEvent -> {

            Stage customTimerStage = new Stage();             // Creating a stage
            customTimerStage.setTitle("Enter Custom Timer");  // Setting title of custom timer window
            Text lengthLabel = new Text("Pomodoro");       // Label to hold length of pomodoro
            Text shrtBreakLabel = new Text("Short Break"); // Label to hold length of short break
            Text lngBreakLabel = new Text("Long Break");   // Label to hold length of long break
            TextField pomTxtFld = new TextField();            // TextField for pomodoro length ui
            TextField shtBKTF = new TextField();              // TextField for short break ui
            TextField lngBkTF = new TextField();              // TextField for long break ui
            GridPane customTimerPane = new GridPane();        // Creating a new GridPane

            Button saveButton2 = new Button();
            ImageView saveButtonImageView = new ImageView(saveButton);
            saveButton2.setGraphic(saveButtonImageView);
            saveButton2.setPadding(inset1);

            Button loadButton2 = new Button();
            ImageView loadButtonImageView = new ImageView(loadButton);
            loadButton2.setGraphic(loadButtonImageView);
            loadButton2.setPadding(inset1);



            // Event handler to bring up save dialog box and save the inputs
            EventHandler<MouseEvent> save2Event = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

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
                }
            };
            saveButton2.addEventFilter(MouseEvent.MOUSE_CLICKED, save2Event);

            // Event handler to populate text fields by loading a text file
            EventHandler<MouseEvent> load2Event = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    FileInputStream in = null;
                    FileChooser inputFile = new FileChooser();

                    File selectedFile = inputFile.showOpenDialog(customTimerStage);






                    // Body of event handler
                    pomTxtFld.clear();
                    shtBKTF.clear();
                    lngBkTF.clear();
                }
            };
            loadButton2.addEventFilter(MouseEvent.MOUSE_CLICKED, load2Event);

            // Setting text fields with initial values
            pomTxtFld.setText("25");
            shtBKTF.setText("15");
            lngBkTF.setText("5");


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
            customTimerPane.add(saveButton2,    1, 6);
            customTimerPane.add(loadButton2,    1, 7);

            // Adding pane to a new scene and setting scene to the stage
            customTimerStage.setScene(new Scene(customTimerPane, 615, 330));
            customTimerStage.show();  // Displaying stage

        };
        customToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, customTimerHandler);


        primaryStage.setTitle("Pomodoro Timer");
        // Creating a dark red background to set to the main stage
        Background darkRedBackground = new Background(new BackgroundFill(lightRedColor, CornerRadii.EMPTY, Insets.EMPTY));
        root.setBackground(darkRedBackground);   // Set the color of the background
        primaryStage.setScene(new Scene(root, 1500, 700));
        primaryStage.show();
    }

    void saveTextToFile(String field1, String field2, String field3, File file) {
        try{
            PrintWriter myWriter;
            myWriter = new PrintWriter(file);
            myWriter.println(field1 + field2 + field3);
            myWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
