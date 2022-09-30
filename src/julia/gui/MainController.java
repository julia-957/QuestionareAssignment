package julia.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import julia.Main;

import javax.swing.*;
import java.io.IOException;


public class MainController {

    @FXML
    private Button fillQuestionnaire;
    @FXML
    private TextField nameInput;

    @FXML
    private void switchToQuestionnaire(ActionEvent actionEvent) throws IOException {

        //Loading the questionnaire and getting an instance of the controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/QuestionnaireWindow.fxml"));
        Parent root = loader.load();

        //Get controller of QuestionnaireWindow
        QuestionnaireController questionnaireController = loader.getController();

        //Pass whatever data we need to pass
        questionnaireController.passParticipantName(nameInput.getText());

        //Show QuestionnaireWindow in a new stage
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Questionnaire");
        stage.show();
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