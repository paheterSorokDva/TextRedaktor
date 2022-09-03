package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import static javax.swing.JFileChooser.*;

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
                new FileChooser.ExtensionFilter(".txt", "*.txt")

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

    @FXML
    protected void onBtnSaveFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранение файла или фила");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(".txt", "*.txt")

        );
        String textInPole = textAreaPole.getText();
        //file = fileChooser.showSaveDialog(stage);


        try(FileWriter writer = new FileWriter(fileChooser.showSaveDialog(stage), true))
        {
            writer.write(textInPole);
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);

        }


    }

}


