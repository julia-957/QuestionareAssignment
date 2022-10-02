package julia.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import julia.Main;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainController {

    private ArrayList<String> participantsList = new ArrayList<String>();
    private ArrayList<Integer> participantsScore = new ArrayList<Integer>();

    @FXML
    private TextField nameInput;
    @FXML
    private ListView participants;

    @FXML
    private void switchToQuestionnaire(ActionEvent actionEvent) throws IOException {

        //Loading the questionnaire and getting an instance of the controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/QuestionnaireWindow.fxml"));
        Parent root = loader.load();

        //Get controller of QuestionnaireWindow
        QuestionnaireController questionnaireController = loader.getController();

        //By using this, we set an instance of this controller as the parameter of the function
        questionnaireController.setParentController(this);

        //Pass whatever data we need to pass
        questionnaireController.passParticipantName(nameInput.getText());
        participantsList.add(nameInput.getText());

        //Closes this window
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();

        //Show QuestionnaireWindow in a new window
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Questionnaire");
        stage.show();
    }

    public void getSatisfaction(int satisfaction){
        participantsScore.add(satisfaction);
    }

    public void updateParticipants(){
    }
}