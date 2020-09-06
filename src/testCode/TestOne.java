package testCode;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TestOne extends Application {

    // globals
    private final Integer STARTTIME = 60;  // value can't be change
    private Integer seconds = STARTTIME;   // copy of value can
    private Label countDownLabel = new Label();

    private final Integer STARTTIMEMINUTES = 2;
    private Integer minutes = STARTTIMEMINUTES;

    private NumberFormat formatter = new DecimalFormat("00");
//    String secondsString = formatter.format(seconds);



    private String minuteTxt = new String();
    private String secondTxt = new String();


    @Override
    public void start(Stage primaryStage) throws Exception {

        minuteTxt = formatter.format(minutes);
        secondTxt = formatter.format(seconds);

        System.out.println(minuteTxt);

        Button startButton = new Button("Start" );
        countDownLabel.setText("Countdown-> " + minuteTxt + ":" + secondTxt);
        HBox layout = new HBox(5);
        layout.getChildren().addAll(countDownLabel, startButton);
        Scene myScene = new Scene(layout, 200, 100);
        primaryStage.setScene(myScene);
        primaryStage.setTitle("Timer Example");

        startButton.setOnAction(actionEvent -> {
            doTime();
        });

        primaryStage.show();

    }

    private void doTime() {

        Timeline time = new Timeline();   // creating a new timeline animation
        time.setCycleCount(Timeline.INDEFINITE);  // setting animation to run forever

        // Setting end point of timer, stop timer, wherever it may by, to make it begin at the beginning later on
        if (time != null)
            time.stop();

        // Defining target state of a node at 1 second
        // attaching event handler to keyframe, every 1 second the key frame does something
        KeyFrame frame = new KeyFrame(Duration.seconds(60), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                minutes--;
                minuteTxt = formatter.format(minutes);
//                countDownLabel.setText("Countdown-> " + minuteTxt + ":" + secondTxt);
                if (minutes <= 0) {
                    time.stop();
                }

            }
        });

        KeyFrame frame2 = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                seconds--;
                secondTxt = formatter.format(seconds);
                countDownLabel.setText("Countdown-> " + minuteTxt + ":" + secondTxt);


            }
        });

        if (seconds <= 0 && minutes <= 0){
            time.stop();
        }


        time.getKeyFrames().addAll(frame2, frame);
        time.playFromStart(); // execute the timeline
    }

    public static void main(String[] args) {
        launch(args);
    }

}


