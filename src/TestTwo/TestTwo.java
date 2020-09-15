package TestTwo;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestTwo extends Application {

    private final Integer SECONDS = 100;
    private Integer seconds = SECONDS;
    private Label timeLabel = new Label(seconds.toString());
    private Timeline secondsTime = new Timeline();
    private Button startButton = new Button("start");
    private Button pauseButton = new Button("pause");

    @Override
    public void start(Stage primaryStage) {

        startButton.setOnAction(actionEvent -> {

            beginTimer();
            System.out.println(secondsTime.getCurrentTime());

        });
        pauseButton.setOnAction(actionEvent -> {
            secondsTime.pause();
        });

        HBox myHBox = new HBox(startButton, pauseButton, timeLabel);
        myHBox.setSpacing(25);

        Scene myScene = new Scene(myHBox, 500, 500);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    private void beginTimer() {
        secondsTime.setCycleCount(Timeline.INDEFINITE);
        KeyFrame secondFrame = new KeyFrame(Duration.seconds(1), actionEvent -> {

           seconds--;
           timeLabel.setText(seconds.toString());
        });
        secondsTime.getKeyFrames().add(secondFrame);
        secondsTime.play();

    }
}
