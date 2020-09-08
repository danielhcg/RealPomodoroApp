package testCode;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TestOne extends Application {


    // Constant values for time
    private final Integer START_TIME_MINUTES = 4;
    private final Integer START_TIME_SECONDS = 5;

    // Modifiable copies of constants to manipulate
    private Integer minutes = START_TIME_MINUTES;
    private Integer seconds = START_TIME_SECONDS;

    private Integer secondsCopy = START_TIME_SECONDS;

    // Creating format in which integers are to be displayed
    //private final NumberFormat formatter = new DecimalFormat("00");

    // Storing string value copies of constants in labels
    private final Label minuteLabel = new Label(minutes.toString());
    private final Label secondLabel = new Label(seconds.toString());

    // Creating a colon label to add to layout
    private final Label colonLabel = new Label(":");

    // Creating a label made up of copies of constants
    private final Label countDownLabel = new Label("Countdown-> " + minuteLabel.getText() + ":" + secondLabel.getText());

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Timer Example");  // Title

        System.out.println(countDownLabel);

        Button startButton = new Button("Start" );  // Button
        startButton.setOnAction(actionEvent -> {  // Event Handler
            doTime();  // Calling doTime() function
        });

        HBox layout = new HBox(startButton, minuteLabel, colonLabel, secondLabel);  // Layout

        Scene myScene = new Scene(layout, 200, 100); // Adding layout to scene
        primaryStage.setScene(myScene);  // Setting scene to stage
        primaryStage.show();  // Displaying stage
    }

    // Where all the magic happens
    private void doTime() {

        Timeline minuteTime = new Timeline();
        minuteTime.setCycleCount(Timeline.INDEFINITE);

        Timeline secondTime = new Timeline();
        secondTime.setCycleCount(Timeline.INDEFINITE);

        if (minuteTime != null && secondTime != null) {}
            minuteTime.stop();


        KeyFrame minuteFrame = new KeyFrame(Duration.seconds(5), actionEvent -> {
            minutes--;
            minuteLabel.setText(minutes.toString());
            if (minutes <= 0) {
                minuteTime.stop();
                Alert minutesAlert = new Alert(Alert.AlertType.INFORMATION);
                minutesAlert.setHeaderText("Minutes KeyFrame Ended");
                minutesAlert.show();
            }
        });


        KeyFrame secondFrame = new KeyFrame(Duration.seconds(1), actionEvent -> {
            seconds--;
            secondLabel.setText(seconds.toString());

                // continues seconds timer until minute timer is up
                if (seconds <= 0 && minuteTime.getStatus() == Animation.Status.STOPPED) {

                    secondTime.stop();
                    Alert secondsAlert = new Alert(Alert.AlertType.INFORMATION);
                    secondsAlert.setHeaderText("Seconds KeyFrame Ended");
                    secondsAlert.show();


                } //else {
//                    seconds = secondsCopy;
//                    seconds--;
//                    secondLabel.setText(seconds.toString());
//                }

                if (seconds <= 0 && minuteTime.getStatus() == Animation.Status.RUNNING){
                    seconds = START_TIME_SECONDS;
                }
        });
        
        minuteTime.getKeyFrames().add(minuteFrame);
        minuteTime.playFromStart(); // execute the timeline

//         Not needed
//        secondTime.setOnFinished(actionEvent -> {
//            minuteTime.statusProperty(Animation.Status.STOPPED);
//            if (minuteTime.getStatus() == Animation.Status.STOPPED) {
//                secondTime.playFromStart();
//            }
//        });

        secondTime.getKeyFrames().add(secondFrame);
        secondTime.playFromStart();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


























