package julia.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class History {
    private ObservableList<String> participants;

    public History(){
        participants = FXCollections.observableArrayList();
    }

    public void addToParticipants(String participant){
        this.participants.add(participant);
    }

    public void addScoreToParticipant(String participant, Integer score){
        int i = 0;
        while (i < participants.size()-1){
            String oneOfTheParticipants = participants.get(i);
            if (oneOfTheParticipants.contains(participant)){
                this.participants.remove(oneOfTheParticipants);
            }
            i++;
        }
        int location = this.participants.indexOf(participant);
        this.participants.remove(participant);
        this.participants.add(location, participant + ": " + score);
    }

    public ObservableList<String> getParticipants(){
        return participants;
    }

    public Integer getParticipantsLength(){
        return participants.size();
    }
}
