package julia.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import julia.models.History;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class QuestionnaireController {
    private MainController mainController;
    History participantHistory;
    private String participant;
    private int satisfaction = 0;
    private RadioButton[] disagree = new RadioButton[9];
    private RadioButton[] neutral = new RadioButton[9];
    private RadioButton[] agree = new RadioButton[9];

    @FXML
    private Label participantName;
    @FXML
    private Label scoreLabel;

    @FXML
    public void setParentController(MainController mainController){
        this.mainController = mainController;
    }

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

    public void initialize(){
        participantHistory = new History();
    }

    public void addToArrays(){
        disagree[0] = disagree1;
        disagree[1] = disagree2;
        disagree[2] = disagree3;
        disagree[3] = disagree4;
        disagree[4] = disagree5;
        disagree[5] = disagree6;
        disagree[6] = disagree7;
        disagree[7] = disagree8;
        disagree[8] = disagree9;

        neutral[0] = neutral1;
        neutral[1] = neutral2;
        neutral[2] = neutral3;
        neutral[3] = neutral4;
        neutral[4] = neutral5;
        neutral[5] = neutral6;
        neutral[6] = neutral7;
        neutral[7] = neutral8;
        neutral[8] = neutral9;

        agree[0] = agree1;
        agree[1] = agree2;
        agree[2] = agree3;
        agree[3] = agree4;
        agree[4] = agree5;
        agree[5] = agree6;
        agree[6] = agree7;
        agree[7] = agree8;
        agree[8] = agree9;
    }

    public void setParticipantName(){
        this.participant = participantHistory.getParticipants().get(0);
        participantName.setText("Name of participant: " + participant);
    }

    public void calculateScore(ActionEvent actionEvent) {
        addToArrays();
        for (int i = 0; i<9; i++){
            if (disagree[i].isSelected()){
                satisfaction--;
            }
            else if (agree[i].isSelected()) {
                satisfaction++;
            }
        }
        scoreLabel.setText("Score: " + satisfaction);
    }

    //Save score and send it to the MainWindow
    public void saveScore(ActionEvent actionEvent) throws IOException {
        //Loading the main window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.setModel(participantHistory);


        //Pass data
        //mainController.getSatisfaction(satisfaction);
        mainController.updateParticipants();

        //Close this window and open the main one
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Questionnaire");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    public void setModel(History participantHistory) {
        this.participantHistory = participantHistory;
    }
}
