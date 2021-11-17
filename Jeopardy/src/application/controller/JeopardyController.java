package application.controller;

import java.util.ArrayList;

import application.model.Category;
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
    	ArrayList<Category> categoryList = test.readQuestionData();
    	
    	for(Category category: categoryList) {
    		System.out.println(category);
    		ArrayList<Question> questionList = category.getQuestions();
    		for(Question question: questionList) {
    			System.out.println(question);
    		}
    	}
    }
    
    public void setData(Team team1, Team team2)
    {
    	this.team1 = team1;
    	this.team2 = team2;
    }

}
