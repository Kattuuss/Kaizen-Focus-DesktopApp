package com.kaizen.components;

import com.kaizen.animations.TimerAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public class Timer extends Pane {

    /**
     *
     * @return
     */
    public void createMainCircle() {

        Image image = new Image(getClass().getResource("/assets/images/EiffelTowerNoBackground.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(250);

        Circle exteriorCircle = new Circle(600, 400, 125); // Creates the base circle: centerX, centerY, radius
        exteriorCircle.setFill(Color.TRANSPARENT); // Set the inside color null
        exteriorCircle.setStroke(Color.VIOLET); // Colors the border of the circle
        exteriorCircle.setStrokeWidth(20); // Gives the border width

        // Creates the circle that indicates the progress of the time: centerX, centerY, radius, color
        Circle timeCircle = new Circle(600, 277, 15, Color.PURPLE);

        // Creates an arc that acts as the trail of the "timerCircle": centerX, centerY, radiusX, radiusY, startAngle, Length
        Arc circleTrail = new Arc(600, 400, 125, 125, 90, 0);
        circleTrail.setType(ArcType.OPEN);
        circleTrail.setStroke(Color.PURPLE);
        circleTrail.setStrokeWidth(20);
        circleTrail.setFill(null);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(exteriorCircle, imageView);

        this.getChildren().addAll(stackPane, timeCircle, circleTrail);
        TimerAnimation.moveContent(exteriorCircle, timeCircle, circleTrail);
    }
}