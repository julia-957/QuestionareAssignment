package julia.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class QuestionnaireController {

    private int disagreeCount;
    private int neutralCount;
    private int agreeCount;

    @FXML
    private Label participantName;

    @FXML
    public void passParticipantName(String participant){
        participantName.setText("Name of participant: " + participant);
    }

}
