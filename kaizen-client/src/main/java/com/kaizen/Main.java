package com.kaizen;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.xml.xpath.XPath;
import java.security.PrivilegedAction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {

    /**
     *
     * @return
     */
    public Parent createCircles() {
        Circle exteriorCircle = new Circle(600, 400, 125); // Creates the exterior circle in the xy position
        exteriorCircle.setFill(null); // Set the inside color null
        exteriorCircle.setStroke(Color.VIOLET); // Colors the border of the circle
        exteriorCircle.setStrokeWidth(20); // Gives the border width

        Circle timeCircle = new Circle(600, 277, 15, Color.PURPLE);

        Arc circleTrail = new Arc();
        circleTrail.setCenterX(600);
        circleTrail.setCenterY(400);
        circleTrail.setRadiusX(125);
        circleTrail.setRadiusY(125);
        circleTrail.setStartAngle(90);   // Stats above (90 degrees)
        circleTrail.setLength(0);        // Starts with no trail
        circleTrail.setType(ArcType.OPEN);
        circleTrail.setStroke(Color.PURPLE);
        circleTrail.setStrokeWidth(20);
        circleTrail.setFill(null);

        moveContent(exteriorCircle, timeCircle, circleTrail);

        return new Pane(exteriorCircle, timeCircle, circleTrail);
    }

    /**
     *
     * @param exteriorCircle
     * @param timeCircle
     */
    private void moveContent(Circle exteriorCircle, Circle timeCircle, Arc circleTrail) {

        exteriorCircle.setRotate(-90); // Rotates the border circle so it starts above

        // Updates the trail until it is complete
        KeyValue fullTrail = new KeyValue(circleTrail.lengthProperty(), -360); // full hour cycle
        KeyFrame frame = new KeyFrame(Duration.seconds(30), fullTrail);
        Timeline timeline = new Timeline(frame);
        timeline.play();

        // Moves the
        PathTransition transition = new PathTransition();
        transition.setDuration(Duration.seconds(30));
        transition.setPath(exteriorCircle);
        transition.setNode(timeCircle);
        transition.setCycleCount(1);
        transition.setInterpolator(Interpolator.LINEAR);

        transition.play();
    }

    /**
     * Creates the stage, adds and show the scene with a title
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createCircles(), 1200, 800, Color.WHITESMOKE));
        stage.setTitle("Kaizen - Keep Evolving");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}