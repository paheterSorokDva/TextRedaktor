package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    static String a;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), stage.getMaxWidth(), stage.getMaxHeight());

       // Image image = new Image("C:\\Users\\Илья\\IdeaProjects\\javafx\\src\\main\\resources\\icons\\iconMain.png"); /// C:\Users\***\IdeaProjects\javafx\src\main\resources\icons\iconMain.png
      //  stage.getIcons().add(image);

        stage.setTitle("Текстовой редактор");
        stage.setScene(scene);
        stage.show();


    }



    public static void main(String[] args) {
        launch();
    }

    public static void  setTitleStage(String s){

    }





}