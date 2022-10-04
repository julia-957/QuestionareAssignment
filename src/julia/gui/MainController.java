package julia.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import julia.Main;
import julia.models.History;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainController {
    @FXML
    private TextField nameInput;
    @FXML
    private ListView participants;
    History participantHistory;

    public void initialize(){
        //get model
        participantHistory = new History();
    }

    @FXML
    private void switchToQuestionnaire(ActionEvent actionEvent) throws IOException {
        participantHistory.addToParticipants(nameInput.getText());

        //Loading the questionnaire and getting an instance of the controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/QuestionnaireWindow.fxml"));
        Parent root = loader.load();

        //Get controller of QuestionnaireWindow
        QuestionnaireController questionnaireController = loader.getController();

        //By using this, we set an instance of this controller as the parameter of the function
        questionnaireController.setParentController(this);

        //Pass whatever data we need to pass
        questionnaireController.setModel(participantHistory);
        questionnaireController.setParticipantName();

        //Closes this window
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();

        //Show QuestionnaireWindow in a new window
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Questionnaire");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    public void getSatisfaction(int satisfaction){
        //participantsList.put(participant,satisfaction);
    }

    @FXML
    public void updateParticipants(){
        participants.setItems(this.participantHistory.getParticipants());
    }

    public void setModel(History participantHistory){
        this.participantHistory = participantHistory;
    }
}