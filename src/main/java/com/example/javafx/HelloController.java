package com.example.javafx;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;


import static javafx.scene.control.Alert.AlertType.ERROR;
import static javafx.scene.control.Alert.AlertType.INFORMATION;

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
    @FXML
    private Menu nameFile;

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

        //tab1.setText(file.getName());
        nameFile.setText(file.getName());
    }

    @FXML
    protected void onAboutClick() {

        //JFrame jFrame = new JFrame();
        //JOptionPane.showMessageDialog(jFrame, "GitHub:paheterSorokDva");
        Alert alert = new Alert(INFORMATION);
        alert.setTitle("About me");
        alert.setHeaderText("Text Redaktor 0.1");



        Hyperlink hyperlink = new Hyperlink("Text Redaktor (GitHub)");
        hyperlink.setOnAction(e -> {
            try {
                URL home = new URL("https://github.com/paheterSorokDva/TextRedaktor");
                Desktop.getDesktop().browse(home.toURI());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }


        });


        alert.getDialogPane().setContent(hyperlink);
        alert.showAndWait();




    }

    @FXML
    protected void onBtnSaveFileAs(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранение файла или фила");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(".txt", "*.txt")

        );
        String textInPole = textAreaPole.getText();
        //file = fileChooser.showSaveDialog(stage);


        try(FileWriter writer = new FileWriter((file = fileChooser.showSaveDialog(stage)), false))
        {
            writer.write(textInPole);
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        nameFile.setText(file.getName());

    }


    @FXML
    protected void onBtnSaveFile() {

        String textInPole = textAreaPole.getText();
        if(file == null) {

            Alert alert = new Alert(ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Не открыт или не выбран файл");
            alert.showAndWait();

            onBtnSaveFileAs();



        }

        try(FileWriter writer = new FileWriter(file, false))
        {
            writer.write(textInPole);
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        nameFile.setText(file.getName());

    }
}


