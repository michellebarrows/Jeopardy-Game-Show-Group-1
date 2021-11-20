package application.controller;

import java.util.ArrayList;

import application.model.Category;
import application.model.Jeopardy;
import application.model.Question;
import application.model.Team;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class JeopardyController {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button btn00, btn01, btn02, btn03, btn04,
    			   btn10, btn11, btn12, btn13, btn14,
    			   btn20, btn21, btn22, btn23, btn24,
    			   btn30, btn31, btn32, btn33, btn34,
    			   btn40, btn41, btn42, btn43, btn44;
    @FXML
    private TextField category0, category1, 
    		category2, category3, category4;
    @FXML
    private TextField team1Name, team2Name;
    @FXML
    private TextField team1Score, team2Score;
    
    Team team1;
    Team team2;
    
    public void initialize() {
    	
    	TextField[] categoryTextFields = {category0, category1, category2, category3, category4};
    	
    	System.out.println("Testing game");
    	Jeopardy test = new Jeopardy();
    	ArrayList<Category> categoryList = test.readQuestionData();
    	
    	for(int i = 0; i < categoryTextFields.length; i++) {
    		categoryTextFields[i].setText(categoryList.get(i).getName());
    	}
    	
    	initializeButtons();
    }
    
    public void setData(Team team1, Team team2)
    {
    	this.team1 = team1;
    	this.team2 = team2;
    	
    	team1Name.setText(team1.getTeamName());
    	team2Name.setText(team2.getTeamName());
    }
    
    public void initializeButtons()
    {
    	
    }
}
