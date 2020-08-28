package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.rgb;

public class InfoBox {

    public static void display() {

        // Creating colors to use in app
        Color darkRedColor = rgb(165, 43, 52);
        Color lightRedColor = rgb(197, 94, 94);
        Color offWhiteColor = rgb(255, 237, 229);

        Stage whatIsStage = new Stage();
        whatIsStage.setTitle("What is a Pomodoro Timer?");
        whatIsStage.initModality(Modality.APPLICATION_MODAL);  // Blocks user interaction until info window is closed

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
        whatIsStage.showAndWait();  // Blocks user interaction until info window is closed

    }

}
