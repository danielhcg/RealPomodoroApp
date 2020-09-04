package testCode;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TestOne extends Application {

    // globals
    private final Integer STARTTIME = 10;  // value can't be change
    private Integer seconds = STARTTIME;   // copy of value can
    private Label countDownLabel;

    private final Integer MINUTESTART = 25;
    private Integer minutes = MINUTESTART;

    private final Integer SECONDSTART = 60;
    private Integer seconds2 = SECONDSTART;

    private Label myLabel = new Label();


    NumberFormat formatter = new DecimalFormat("00");

    String minuteString = new String();
    String secondString = new String();

    private Label mainLabel = new Label();
    private Text minuteText = new Text();
    private Text secondText = new Text();




    @Override
    public void start(Stage primaryStage) throws Exception {

        minuteText.setText("25");
        secondText.setText("00");


        Button startButton = new Button("Start" );

        mainLabel.setText("Countdown-> " + minuteText + ":" + secondText);

        HBox layout = new HBox(5);
        //countDownLabel.setTextFill(Color.BLACK);
        //layout.getChildren().add(countDownLabel);
        layout.getChildren().addAll(mainLabel, startButton);
        Scene myScene = new Scene(layout, 200, 100);
        primaryStage.setScene(myScene);
        primaryStage.setTitle("Timer Example");

        startButton.setOnAction(actionEvent -> {
            //doTime();
        });








        primaryStage.show();


    }

    private void doTime() {

        Timeline time = new Timeline();   // creating a new timeline animation
        time.setCycleCount(Timeline.INDEFINITE);  // setting animation to run forever

        // Setting end point of timer, stop timer, wherever it may by, to make it begin at the beginning later on
        if (time != null)
            time.stop();


        mainLabel.setText("Countdown-> " + minuteText + ":" + secondText);


        KeyFrame minuteFrame = new KeyFrame(Duration.seconds(60), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                minutes--;
            }


        });

        // Defining target state of a node at 1 second
        // attaching event handler to keyframe, every 1 second the key frame does something
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("h");


                minuteString =  formatter.format(minutes);
                secondString = formatter.format(seconds2);

//                minutes--;
                seconds2--;
                secondText.setText(secondString);

                // stopping condition
                if (seconds2 <= -1){


                    minutes--;

                    time.stop();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION );
                    alert.setHeaderText("Done!");
                    alert.show();
                }

            }
        });




        time.getKeyFrames().addAll(frame, minuteFrame);
        time.playFromStart(); // execute the timeline
    }

    public static void main(String[] args) {
        launch(args);
    }

}


