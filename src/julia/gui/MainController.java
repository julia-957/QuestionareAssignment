package julia.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import julia.Main;

import javax.swing.*;


public class MainController {

    private int disagreeCount;
    private int neutralCount;
    private int agreeCount;
    private String participant;

    @FXML
    private Button fillQuestionnaire;
    @FXML
    private TextField nameInput;
    @FXML
    private Label participantName;

    @FXML
    private void switchToQuestionnaire(ActionEvent actionEvent){
        participant = nameInput.getText();
        Stage stage = (Stage) fillQuestionnaire.getScene().getWindow();
        stage.setScene(julia.Main.questionnaire);
    }

    @FXML
    private void disagreeSelected(){

    }

    @FXML
    private void neutralSelected(){

    }

    @FXML
    private void agreeSelected(){

    }
}