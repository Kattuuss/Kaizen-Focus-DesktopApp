package com.kaizen.views;

import com.kaizen.components.Timer;
import com.kaizen.components.NavigationMenu;
import javafx.scene.layout.BorderPane;

public class MainView {

    private BorderPane root;

    public MainView() {
        Timer timer = new Timer();
        timer.createMainCircle();
        NavigationMenu navigationMenu = new NavigationMenu();
        navigationMenu.createNavMenu();

        root = new BorderPane();
        root.setCenter(timer);
        root.setLeft(navigationMenu);
    }

    public BorderPane getRoot() {
        return root;
    }
}
