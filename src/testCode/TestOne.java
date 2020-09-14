package testCode;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TestOne extends Application {

    // Constant values for time
    private final Integer START_TIME_MINUTES = 11;
    private final Integer START_TIME_SECONDS = 60;

    // Modifiable copies of constants to manipulate
    private Integer minutes = START_TIME_MINUTES;
    private Integer seconds = START_TIME_SECONDS;

    // Creating format in which integers are to be displayed
    private final NumberFormat formatter = new DecimalFormat("00");

    // Storing string value copies of constants in labels
    private final Label minuteLabel = new Label(minutes.toString());
    private final Label secondLabel = new Label(formatter.format(seconds));

    // Creating a colon label to add to layout
    private final Label colonLabel = new Label(":");

    private Timeline minuteTime = new Timeline();
    private Timeline secondTime = new Timeline();

    private Button pauseButton = new Button("Pause");
    private Button startButton = new Button("Start" );  // Button

    private Duration minuteTimeCurrentTime, secondTimeCurrentTime;



    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Timer Example");  // Title

        // Changing display of seconds when minute mark reached
        if (seconds == 60 || seconds == 50)
            secondLabel.setText("00");

        startButton.setOnAction(actionEvent -> {
            doMinutesTime();
            doSecondsTime();



        });

        pauseButton.setOnAction(actionEvent -> {
            minuteTime.pause();
            secondTime.pause();
            minuteTimeCurrentTime = minuteTime.getCurrentTime();
            secondTimeCurrentTime = secondTime.getCurrentTime();

        });




        HBox layout = new HBox(startButton, pauseButton, minuteLabel, colonLabel, secondLabel);  // Layout

        Scene myScene = new Scene(layout, 200, 100); // Adding layout to scene
        primaryStage.setScene(myScene);  // Setting scene to stage
        primaryStage.show();  // Displaying stage
    }

    private void doMinutesTime() {
        minuteTime.setCycleCount(Timeline.INDEFINITE);
        KeyFrame minuteFrame = new KeyFrame(Duration.seconds(60), actionEvent -> {
            minutes--;
            minuteLabel.setText(minutes.toString());
            if (minutes <= 0)
                minuteTime.stop();
        });
        minuteTime.getKeyFrames().add(minuteFrame);
        if (pauseButton.isPressed()){
            minuteTime.playFrom(minuteTimeCurrentTime);
        } else {
            minuteTime.playFrom(Duration.seconds(59));
        }
    }

    private void doSecondsTime() {
        secondTime.setCycleCount(Timeline.INDEFINITE);
        KeyFrame secondFrame = new KeyFrame(Duration.seconds(1), actionEvent -> {
            seconds--;
            secondLabel.setText(formatter.format(seconds));
            if (seconds <= 0 && minuteTime.getStatus() == Animation.Status.STOPPED)
                secondTime.stop();
            if (seconds <= 0 && minuteTime.getStatus() == Animation.Status.RUNNING)
                seconds = START_TIME_SECONDS;
        });
        secondTime.getKeyFrames().add(secondFrame);
        secondTime.playFromStart();

    }

    public static void main(String[] args) {
        launch(args);
    }
}








