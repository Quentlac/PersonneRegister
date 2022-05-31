package com.devistorm.personneregister;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("main-view.fxml"));
        Scene mainScene = new Scene(fxmlLoader.load(), 600, 500);

        stage.setTitle("salut");
        stage.setScene(mainScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
