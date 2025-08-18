package com.kaizen.components;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class NavigationMenu extends Pane {

    /**
     * Creates the lines of the navigation menu icon
     * @return
     */
    public void createNavMenu() {

        Line line1 = new Line(30, 30, 60, 30);
        line1.setStrokeWidth(3);
        Line line2 = new Line(30, 40, 60, 40);
        line2.setStrokeWidth(3);
        Line line3 = new Line(30, 50, 60, 50);
        line3.setStrokeWidth(3);

        this.getChildren().addAll(line1, line2, line3);
    }
}
