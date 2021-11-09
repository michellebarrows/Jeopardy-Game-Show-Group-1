package application.controller;

import java.util.ArrayList;

import application.model.Jeopardy;
import application.model.Question;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class JeopardyController {

    @FXML
    private AnchorPane mainPane;
    
    public void initialize() {
    	System.out.println("Testing game");
    	Jeopardy test = new Jeopardy();
    	ArrayList<Question> Qtest = test.readQuestionData();
    	for(Question question: Qtest) {
    		System.out.println(question);
    	}
    }

}
