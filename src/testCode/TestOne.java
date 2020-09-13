package testCode;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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



    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Timer Example");  // Title

        startButton.setOnAction(actionEvent -> { doTime(); });

        pauseButton.setOnAction(actionEvent -> { pauseTime(); });


        // Changing display of seconds when minute mark reached
        if (seconds == 60 || seconds == 50)
            secondLabel.setText("00");

        HBox layout = new HBox(startButton, pauseButton, minuteLabel, colonLabel, secondLabel);  // Layout

        Scene myScene = new Scene(layout, 200, 100); // Adding layout to scene
        primaryStage.setScene(myScene);  // Setting scene to stage
        primaryStage.show();  // Displaying stage
    }

    // Where all the magic happens
    private void doTime() {



        // Setting indefinite cycle time for both minutes and seconds
        minuteTime.setCycleCount(Timeline.INDEFINITE);
        secondTime.setCycleCount(Timeline.INDEFINITE);

        // KeyFrame to decrement minuteTime every minute
        KeyFrame minuteFrame = new KeyFrame(Duration.seconds(60), actionEvent -> {

            minutes--;
            minuteLabel.setText(minutes.toString()); // Modifying minute label

            if (minutes <= 0)
                minuteTime.stop();
        });


        // KeyFrame to decrement secondTime every second
        KeyFrame secondFrame = new KeyFrame(Duration.seconds(1), actionEvent -> {

            seconds--;  // decrement seconds


            secondLabel.setText(formatter.format(seconds)); // modify seconds label

            // stops secondTime if seconds reaches 0 and minuteTime stopped
            if (seconds <= 0 && minuteTime.getStatus() == Animation.Status.STOPPED)
                secondTime.stop();

            // if secondTime reaches 0, but minuteTime is still running, reset seconds
            if (seconds <= 0 && minuteTime.getStatus() == Animation.Status.RUNNING)
                seconds = START_TIME_SECONDS;
        });

        minuteTime.getKeyFrames().add(minuteFrame); // Adding frame to timeline
        secondTime.getKeyFrames().add(secondFrame);

//        minuteTime.play();
//        secondTime.play();

        minuteTime.playFrom(Duration.seconds(59));
        secondTime.playFromStart();

        if (pauseButton.isPressed()){
            minuteTime.playFrom(minuteFrame.getTime());
            secondTime.playFrom(secondFrame.getTime());
        }

    }

    private void pauseTime(){
        minuteTime.pause();
        secondTime.pause();
    }

    public static void main(String[] args) {
        launch(args);
    }
}








