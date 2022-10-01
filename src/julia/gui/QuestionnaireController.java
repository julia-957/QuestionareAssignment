package julia.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionnaireController {

    private MainController mainController;
    private int disagreeCount = 0;
    private int neutralCount = 0;
    private int agreeCount = 0;

    @FXML
    public void setParentController(MainController mainController){
        this.mainController = mainController;
    }

    @FXML
    private Label participantName;

    //instantiate all disagree buttons
    @FXML
    private RadioButton disagree1;
    @FXML
    private RadioButton disagree2;
    @FXML
    private RadioButton disagree3;
    @FXML
    private RadioButton disagree4;
    @FXML
    private RadioButton disagree5;
    @FXML
    private RadioButton disagree6;
    @FXML
    private RadioButton disagree7;
    @FXML
    private RadioButton disagree8;
    @FXML
    private RadioButton disagree9;


    //instantiate all neutral buttons
    @FXML
    private RadioButton neutral1;
    @FXML
    private RadioButton neutral2;
    @FXML
    private RadioButton neutral3;
    @FXML
    private RadioButton neutral4;
    @FXML
    private RadioButton neutral5;
    @FXML
    private RadioButton neutral6;
    @FXML
    private RadioButton neutral7;
    @FXML
    private RadioButton neutral8;
    @FXML
    private RadioButton neutral9;

    //instantiate all agree buttons
    @FXML
    private RadioButton agree1;
    @FXML
    private RadioButton agree2;
    @FXML
    private RadioButton agree3;
    @FXML
    private RadioButton agree4;
    @FXML
    private RadioButton agree5;
    @FXML
    private RadioButton agree6;
    @FXML
    private RadioButton agree7;
    @FXML
    private RadioButton agree8;
    @FXML
    private RadioButton agree9;


    @FXML
    public void passParticipantName(String participant){
        participantName.setText("Name of participant: " + participant);
    }

    @FXML
    public void disagreeCount(){
        disagreeCount++;
    }

    @FXML
    public void neutralCount(){
        neutralCount++;
    }

    @FXML
    public void agreeCount(){
        agreeCount++;
    }

    public void calculateScore(ActionEvent actionEvent) {
        System.out.println("D " + disagreeCount);
        System.out.println("N " + neutralCount);
        System.out.println("A " + agreeCount);
    }

    //Save score and send it to the MainWindow
    public void saveScore(ActionEvent actionEvent) {

    }

}
