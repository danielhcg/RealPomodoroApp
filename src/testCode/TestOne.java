package testCode;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


public class TestOne extends Application {

    // globals
    private final Integer startTime = 10;  // value can't be change
    private Integer seconds = startTime;   // copy of value can
    private Label label;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        label = new Label();
        label.setTextFill(Color.BLACK);
        label.setFont(Font.font(20));
        HBox layout = new HBox(5);
        layout.getChildren().add(label); // Adding node to layout
        doTime();  // Calling function to perform timer functionality

        primaryStage.setTitle("Timer Example");
        primaryStage.show();
    }

    private void doTime() {

        Timeline time = new Timeline();   // creating a new timeline animation
        time.setCycleCount(Timeline.INDEFINITE);  // setting animation to run forever

        // Defining target state of a node at 1 second
        // attaching event handler to keyframe, every 1 second the key frame does something
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("h");
            }
        });
    }
}
