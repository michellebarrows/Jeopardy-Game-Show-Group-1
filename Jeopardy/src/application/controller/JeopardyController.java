package application.controller;

import java.util.ArrayList;

import application.model.Jeopardy;
import application.model.Question;
import application.model.Team;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class JeopardyController {

    @FXML
    private AnchorPane mainPane;
    
    Team team1;
    Team team2;
    
    public void initialize() {
    	System.out.println("Testing game");
    	Jeopardy test = new Jeopardy();
    	ArrayList<Question> Qtest = test.readQuestionData();
    	for(Question question: Qtest) {
    		System.out.println(question);
    	}
    }
    
    public void setData(Team team1, Team team2)
    {
    	this.team1 = team1;
    	this.team2 = team2;
    }

}
