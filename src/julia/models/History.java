package julia.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class History {
    private ObservableList<String> participants;
    private ObservableList<Integer> score;

    public History(){
        participants = FXCollections.observableArrayList();
    }

    public void addToParticipants(String participant){
        this.participants.add(participant);
        System.out.println(participants);
    }

    public ObservableList<String> getParticipants(){
        return participants;
    }
}
