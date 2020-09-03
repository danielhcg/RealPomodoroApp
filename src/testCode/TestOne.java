package testCode;
//
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Label;
//import javafx.scene.layout.HBox;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class TestOne extends Application {
//
//    // globals
//    private final Integer STARTTIME = 10;  // value can't be change
//    private Integer seconds = STARTTIME;   // copy of value can
//    private Label countDownLabel;
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
////        label = new Label();
////        myLabel.setTextFill(Color.BLACK);
////        myLabel.setFont(Font.font(20));
////        HBox layout = new HBox(5, myLabel);
////        doTime();  // Calling function to perform timer functionality
//
//
////        Scene myScene = new Scene(layout);
////        primaryStage.setScene(myScene);
////        primaryStage.setTitle("Timer Example");
////        primaryStage.show();

////        HBox layout = new HBox(5, countDownLabel);
//        primaryStage.setTitle("Timer Example");
//        doTime(countDownLabel);
//
////        countDownLabel = new Label();
//
////        TestOne.myLabel = new Label();
//
////        countDownLabel.setTextFill(Color.BLACK);
////        myLabel.setFont(Font.font(20));
//
////        doTime();  // Calling function to perform timer functionality
//
////        HBox layout = new HBox(myLabel);
//
////        Scene myScene = new Scene(layout, 200, 100);
////        primaryStage.setScene(myScene);
//        primaryStage.show();

//
//    }
//
//    private void doTime(Label aLabel) {
//
//        Timeline time = new Timeline();   // creating a new timeline animation
//        time.setCycleCount(Timeline.INDEFINITE);  // setting animation to run forever
//
//        // Setting end point of timer, stop timer, wherever it may by, to make it begin at the beginning later on
//        if (time != null)
//            time.stop();
//
//        // Defining target state of a node at 1 second
//        // attaching event handler to keyframe, every 1 second the key frame does something
//        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                //System.out.println("h");
//
//                seconds--;
//                aLabel.setText("Countdown: " + seconds.toString());
//
//                // stopping condition
//                if (seconds <= 0){
//                    time.stop();
//                }
//
//            }
//        });
//        time.getKeyFrames().add(frame);
//        time.playFromStart(); // execute the timeline
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//}


import javafx.application.Application;
import javafx.stage.Stage;

public class TestOne extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}