package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ImageInput;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.stage.Stage;

// Classes I imported that didn't come with the sample
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.beans.binding.Bindings;




import java.io.FileNotFoundException;
import java.lang.Thread;
import javafx.scene.paint.Color;
import static javafx.scene.text.FontWeight.*;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.animation.KeyValue;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;

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

        Button bindingExample = new Button("Binding Example");



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

        // Picture
        // Passing FileInputStream object as a parameter
        FileInputStream iStream1 = new FileInputStream("C:\\Users\\Danny\\Desktop\\RealPomApp\\studyImage1.png");
        Image studyImage1 = new Image(iStream1);

        FileInputStream iStream2 = new FileInputStream("C:\\Users\\Danny\\Desktop\\RealPomApp\\mainColor.png");
        Image mainColorImage = new Image(iStream2);

        FileInputStream iStream3 = new FileInputStream("C:\\Users\\Danny\\Desktop\\RealPomApp\\shortBreakImage1.png");
        Image shortBreakImage1 = new Image(iStream3);

        FileInputStream iStream4 = new FileInputStream("C:\\Users\\Danny\\Desktop\\RealPomApp\\longBreakImage.png");
        Image longBreakImage = new Image(iStream4);

        FileInputStream iStream5 = new FileInputStream("C:\\Users\\Danny\\Desktop\\RealPomApp\\shortBreakImage2.png");
        Image shortBreakImage2 = new Image(iStream5);

        FileInputStream iStream6 = new FileInputStream("C:\\Users\\Danny\\Desktop\\RealPomApp\\studyImage2.png");
        Image studyImage2 = new Image(iStream6);

        //
        FileInputStream iStream7 = new FileInputStream("C:\\Users\\Danny\\Desktop\\RealPomApp\\longBreakImage2.png");
        Image longBreakImage2 = new Image(iStream7);

        FileInputStream iStream8 = new FileInputStream("C:\\Users\\Danny\\Desktop\\RealPomApp\\titleImage.png");
        Image titleImage = new Image(iStream8);
        ImageView titleView = new ImageView(titleImage);


        // Creating a custom toggle button for the loop button-----------------------------------------

        // Bringing in the photos for the toggling effect into the code
        FileInputStream iStream9 = new FileInputStream("C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedLoop.png");
        Image selectedLoop = new Image(iStream9);
        FileInputStream iStream10 = new FileInputStream("C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedLoop.png");
        Image unselectedLoop = new Image(iStream10);

        ToggleButton loopToggle = new ToggleButton(); // Creating a new toggle button
        ImageView loopToggleIV = new ImageView();     // Creating an ImageView to add to the Grid Pane
        loopToggle.setGraphic(loopToggleIV);          // Setting graphic of toggle to the Image View

        loopToggleIV.imageProperty().bind(Bindings
                .when(loopToggle.selectedProperty())
                .then(selectedLoop)
                .otherwise(unselectedLoop)
        );

        // Creating inset length for button borders
        Insets inset1 = new Insets(0.0);

        // Now alls thats left to do is add the toggle button to the grid pane

        // Last line of module------------------------------------------------------------------------

        // Creating a custom toggle button for the long break button----------------------------------

        // Brining in the photos fro the toggling effect into the code
        FileInputStream iStream11 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedLongBreak.png");
        Image selectedLongBreak = new Image(iStream11); // Setting iStream to photo

        FileInputStream iStream12 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedLongBreak.png");
        Image unselectedLongBreak = new Image(iStream12); // Setting iStream to photo

        ToggleButton longBreakToggle = new ToggleButton();    // Creating a new toggle button
        ImageView longBreakToggleImageView = new ImageView(); // Creating an ImageView to add to the Grid Pane
        longBreakToggle.setGraphic(longBreakToggleImageView);

        longBreakToggleImageView.imageProperty().bind(Bindings
                .when(longBreakToggle.selectedProperty())
                .then(selectedLongBreak)
                .otherwise(unselectedLongBreak)
        );

        // Now add the long break toggle button to the grid pane

        // Last line of module------------------------------------------------------------------------

        // Creating a custom toggle button for the short break button --------------------------------

        // Bringing in the photos for the toggling effect into the code
        FileInputStream iStream13 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedShortBreak.png");
        Image selectedShortBreak = new Image(iStream13);

        FileInputStream iStream14 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedShortBreak.png");
        Image unselectedShortBreak = new Image(iStream14);

        ToggleButton shortBreakToggle = new ToggleButton();   // Creating a new toggle button for short break
        ImageView shortBreakImageView = new ImageView();      // Creating a new Image View for the short break
        shortBreakToggle.setGraphic(shortBreakImageView);     // Setting button graphic to toggle Image View

        shortBreakImageView.imageProperty().bind(Bindings
            .when(shortBreakToggle.selectedProperty())
                .then(selectedShortBreak)
                .otherwise(unselectedShortBreak)
        );
        // Last line of module------------------------------------------------------------------------


        // Creating a custom toggle button for the main Pomodoro button-------------------------------
        // Bringing in the photos for the toggling effect into the code
        FileInputStream iStream15 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedMainPom.png");
        Image selectedMainPom = new Image(iStream15);

        FileInputStream iStream16 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedMainPom.png");
        Image unselectedMainPom = new Image(iStream16);

        ToggleButton mainToggle = new ToggleButton();   // Creating a new toggle button for main Pomodoro button
        ImageView mainImageView = new ImageView();      // Creating a new Image View for main Pomodoro button
        mainToggle.setGraphic(mainImageView);           // Setting button graphic to toggle Image View
        mainToggle.setPadding(inset1);

        mainImageView.imageProperty().bind(Bindings
            .when(mainToggle.selectedProperty())
                .then(selectedMainPom)
                .otherwise(unselectedMainPom)
        );




        // Last line of module------------------------------------------------------------------------

        // Creating a custom toggle button for the what is button-------------------------------------
        // Bringing in the photos for the toggling effect into the code
        FileInputStream iStream17 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedWhatIs.png");
        Image selectedWhatIs = new Image(iStream17);

        FileInputStream iStream18 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedWhatIs.png");
        Image unselectedWhatIs = new Image(iStream18);

        ToggleButton whatIsToggle = new ToggleButton();  // Creating a new toggle button for the what is button
        ImageView whatIsImageView= new ImageView();      // Creating a new Image View for what is button
        whatIsToggle.setGraphic(whatIsImageView);
        whatIsToggle.setPadding(inset1);

        whatIsImageView.imageProperty().bind(Bindings
            .when(whatIsToggle.selectedProperty())
                .then(selectedWhatIs)
                .otherwise(unselectedWhatIs)
        );
        // End of module------------------------------------------------------------------------------

        // Creating a custom toggle button for the custom timer button--------------------------------
        // Bringing in the photos for the toggling effect into the code
        FileInputStream iStream19 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\unselectedCustom.png");
        Image unselectedCustom = new Image(iStream19);

        FileInputStream iStream20 = new FileInputStream(
                "C:\\Users\\Danny\\Desktop\\RealPomApp\\selectedCustom.png");
        Image selectedCustom = new Image(iStream20);

        ToggleButton customTimerToggleButton = new ToggleButton();
        ImageView customTimerImageView = new ImageView();
        customTimerToggleButton.setGraphic(customTimerImageView);
        customTimerToggleButton.setPadding(inset1);

        customTimerImageView.imageProperty().bind(Bindings
            .when(customTimerToggleButton.selectedProperty())
                .then(selectedCustom)
                .otherwise(unselectedCustom)
        );



        // End of module------------------------------------------------------------------------------

        // Creating a new toggle group
        ToggleGroup toggleGroup = new ToggleGroup();
        // Adding toggle buttons to the toggleGroup
        customTimerToggleButton.setToggleGroup(toggleGroup);
        whatIsToggle.setToggleGroup(toggleGroup);
        mainToggle.setToggleGroup(toggleGroup);
        shortBreakToggle.setToggleGroup(toggleGroup);
        longBreakToggle.setToggleGroup(toggleGroup);
        loopToggle.setToggleGroup(toggleGroup);

        // Passing the image to a constructor
        ImageView iView = new ImageView(studyImage1);
        // setting the fit height and width of the image view
        iView.setFitHeight(250);
        iView.setFitWidth(250);

        // Creating a group node
        Group tomato;

        // Place short break images into ImageView Nodes
        ImageView tomato1 = new ImageView(studyImage1);
        ImageView tomato2 = new ImageView(studyImage2);

        // Set the size of the images
        tomato1.setFitHeight(250);
        tomato1.setFitWidth(250);

        tomato2.setFitHeight(250);
        tomato2.setFitWidth(250);

        // instantiate an object called shortBreak
        tomato = new Group(tomato1);

        // Place tomato in specific coordinates
        tomato.setTranslateX(50);
        tomato.setTranslateY(2);


        // Animate shortbreak images in a loop
        Timeline t = new Timeline();
        t.setCycleCount(Timeline.INDEFINITE);

        // Add images into the timeline
        t.getKeyFrames().add(new KeyFrame(
                Duration.seconds(1.0),
                (ActionEvent event) -> {
                    tomato.getChildren().setAll(tomato2);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.seconds(2.0),
                (ActionEvent event) -> {
                    tomato.getChildren().setAll(tomato1);
                }
        ));

        t.play();


        /**Setting images on button clicks for display image area*/

        // Event handler for main pomodoro button click
        EventHandler<MouseEvent> changeMainToggle = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Change current image to main Pomodoro image
                tomato1.setImage(studyImage1);
                tomato2.setImage(studyImage2);
            }
        };
        // Adding event filter for long break button click
        mainToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, changeMainToggle);



        // Event handler for short break toggle button
        EventHandler<MouseEvent> changeShortBreakImageToggle = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Change current image to long break image
                tomato1.setImage(shortBreakImage1);
                tomato2.setImage(shortBreakImage2);

                mainToggle.setGraphic(mainImageView);
            }
        };
        // Adding event filter for long break button click
        shortBreakToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, changeShortBreakImageToggle);



        // Event handler for long break toggle button
        EventHandler<MouseEvent> changeLongBreakImageToggle = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Change current image to long break image
                tomato1.setImage(longBreakImage);
                tomato2.setImage(longBreakImage2);
            }
        };
        // Adding event filter for long break button click
        longBreakToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, changeLongBreakImageToggle);



        // Event handler for toggled loop button
        EventHandler<MouseEvent> changeToggleLoopImage = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Change current image to main pomodoro image / looping image
                tomato1.setImage(studyImage1);
                tomato2.setImage(studyImage2);
            }
        };
        // Adding event filter for loop button click
        loopToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, changeToggleLoopImage);



        // Adding nodes to pane          column    row
        gridPane.add(titleView,        0, 0);
        gridPane.add(customTimerToggleButton,1, 0);
        gridPane.add(whatIsToggle,     2, 0);

        gridPane.add(mainToggle,   0, 1);
        //gridPane.add(shortBreakButton, 1, 1);
        //gridPane.add(longBreakButton,  2, 1);
        //gridPane.add(loopButton,      3, 1);
        //gridPane.add(iView, 0, 2);
        gridPane.add(tomato,            0,2);
        gridPane.add(loopToggle,        3,1);
        gridPane.add(longBreakToggle,   2,1);
        gridPane.add(shortBreakToggle, 1,1);
        //gridPane.add(shortBreakToggle, 0, 3);
        //gridPane.add(mainToggle, 0, 3);
        //gridPane.add(customTimerToggleButton, 0, 3);


        gridPane.add(bindingExample, 3, 0);

        // Setting spacing between nodes on gridpane
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        // Event handler for binding example button
        EventHandler<MouseEvent> bindingHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                try {

                    // Window body

                    // Creating the toggles
                    ToggleButton toggle1 = new ToggleButton();
                    ToggleButton toggle2 = new ToggleButton();
                    ToggleButton toggle3 = new ToggleButton();
                    ToggleButton toggle4 = new ToggleButton();

                    // Creating a new toggle group
                    ToggleGroup toggleGroup = new ToggleGroup();

                    // Setting toggles to the group
                    toggle1.setToggleGroup(toggleGroup);
                    toggle2.setToggleGroup(toggleGroup);
                    toggle3.setToggleGroup(toggleGroup);
                    toggle4.setToggleGroup(toggleGroup);

                    // Creating the ImageViews to hold the images
                    ImageView iView1 = new ImageView();
                    ImageView iView2 = new ImageView();
                    ImageView iView3 = new ImageView();
                    ImageView iView4 = new ImageView();

                    // Setting graphics to respective toggles
                    toggle1.setGraphic(iView1);
                    toggle2.setGraphic(iView2);
                    toggle3.setGraphic(iView3);
                    toggle4.setGraphic(iView4);


                    // Creating the bindings
                    iView1.imageProperty().bind(Bindings
                        .when(toggle1.selectedProperty())
                            .then(selectedCustom)
                            .otherwise(unselectedCustom)
                    );
                    iView2.imageProperty().bind(Bindings
                        .when(toggle2.selectedProperty())
                            .then(selectedWhatIs)
                            .otherwise(unselectedWhatIs)
                    );
                    iView3.imageProperty().bind(Bindings
                        .when(toggle3.selectedProperty())
                            .then(selectedLoop)
                            .otherwise(unselectedLoop)
                    );
                    iView4.imageProperty().bind(Bindings
                        .when(toggle4.selectedProperty())
                            .then(selectedLongBreak)
                            .otherwise(unselectedLongBreak)
                    );


                    // Creating the character pane
                    HBox characterPane = new HBox(20, toggle2, toggle4);
                    characterPane.setPadding(new Insets(10));

                    // Creating the actor pane
                    HBox actorPane = new HBox(20, toggle1, toggle3);
                    actorPane.setPadding(new Insets(10));

                    // Adding character and actor panes to vBox
                    VBox pane = new VBox(10, actorPane, characterPane);
                    Stage bindingStage = new Stage();
                    Scene bindingScene = new Scene(pane);
                    bindingStage.setScene(bindingScene);
                    bindingStage.show();

                } finally {

                }
            }
        };
        bindingExample.addEventFilter(MouseEvent.MOUSE_CLICKED, bindingHandler);


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
        whatIsToggle.addEventFilter(MouseEvent.MOUSE_CLICKED, whatIsHandler);

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
        customTimerToggleButton.addEventFilter(MouseEvent.MOUSE_CLICKED, customTimerHandler);

        primaryStage.setScene(new Scene(gridPane, 1500, 700));

        primaryStage.show();
        //sfsdf
    }

    public class Tuna implements Runnable {

        ImageView a;
        Image b, c;

        public Tuna (ImageView x, Image y, Image z) {
            a = x;
            b = y;
            c = z;
        };

        public void run(){
            int x = 1;
            try {
                while (x!=3) {
                    a.setImage(c);
                    Thread.sleep(1000);
                    a.setImage(b);
                    x++;
                }
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
