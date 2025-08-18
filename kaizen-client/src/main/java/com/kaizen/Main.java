package com.kaizen;

import com.kaizen.views.MainView;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    /**
     * Creates the stage, adds and show the scene with a title
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        MainView mainView = new MainView();

        // Creates the scene with 1200 width an 800 height in whitesmoke color using the objects of "root"
        Scene scene = new Scene(mainView.getRoot(), 1200, 800, Color.WHITESMOKE);
        stage.setScene(scene);
        stage.setTitle("Kaizen - Keep Evolving");
        stage.show();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}