package com.kaizen.animations;

import javafx.animation.*;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TimerAnimation {
    /**
     *
     * @param exteriorCircle
     * @param timeCircle
     * @param circleTrail
     */
    public static void moveContent(Circle exteriorCircle, Circle timeCircle, Arc circleTrail) {

        exteriorCircle.setRotate(-90); // Makes the timer ball start above

        // Updates the trail until it is complete
        KeyValue fullTrail = new KeyValue(circleTrail.lengthProperty(), -360); // full hour cycle
        KeyFrame frame = new KeyFrame(Duration.seconds(30), fullTrail);
        Timeline timeline = new Timeline(frame);
        timeline.play();

        // Makes the timer ball move following the exterior circle
        PathTransition transition = new PathTransition();
        transition.setDuration(Duration.seconds(30));
        transition.setPath(exteriorCircle);
        transition.setNode(timeCircle);
        transition.setCycleCount(1);
        transition.setInterpolator(Interpolator.LINEAR);

        transition.play();
    }
}
