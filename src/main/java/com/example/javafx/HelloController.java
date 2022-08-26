package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button btn1;

    @FXML
    private Stage stage;
    @FXML
    private TextArea textAreaPole;
    @FXML
    private MenuItem btnNew;

    File file;

    @FXML
    protected void onButtonClickNew() {

        textAreaPole.setText("");

    }

    @FXML
    protected void onClickOpenFile() {

        FileChooser FileChooser = new FileChooser();                            // FileChooser диалоговое окно выбора файла
        FileChooser.setTitle("Открыть файл ресурсов");
        FileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("txt", "*.txt")

        );

        file = FileChooser.showOpenDialog(stage);                      // Помещаем выбраный файл шоб можно было работать с ним

        Scanner obj = null;                                            // самый простой сканер
        try {
            obj = new Scanner(file);                                  // ипаное исключение на всякий,
        } catch (FileNotFoundException e) {                           // испоьзуется showOpenDialog который тока текст файлы открывает
            throw new RuntimeException(e);                           // смысл исключения, но ide показывает лучше поставить хз, пусть будет. Я нуб
        }
        while (obj.hasNextLine())
            textAreaPole.setText(obj.nextLine());                   // записываем считаное в поле
    }

    @FXML
    protected void onAboutClick() {

        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "GitHub:paheterSorokDva");

    }

}


