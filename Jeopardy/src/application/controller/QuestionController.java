package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import application.model.Question;
import application.model.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**************************************************************************************************
 * CLASS: QuestionController
 * 
 * Attributes:
 *  - A Team object representing the first competing team
 *  - A Team object representing the second competing team
 *  - An ArrayList of Strings containing the FX IDs of buttons whose questions have been completed
 *  - An integer representing the dollar amount that the current question is worth 
 *  - FXML attributes
 *  
 * Use:
 *  Supplies the main logic and data storage for the question game view (QuestionView.fxml)
 *
 *************************************************************************************************/

public class QuestionController 
{
	Team team1;
	Team team2;
	ArrayList<String> completedBtns;
	int dollarAmount;
	
	///////////////////////
	/// FXML Variables ///
	/////////////////////
	
    @FXML
    private TextArea questionArea;
    @FXML
    private Button backButton;
    @FXML
    private TextField optionA, optionB, optionC, optionD;
    @FXML
    private Button team1Id;
    @FXML
    private Button team2Id;
    
	//////////////////////
	/// FXML Handlers ///
	/////////////////////
	
    //METHOD: teamAwardHandler
    //Input: An ActionEvent
    //Output: None
    //Use: Adds the current question's dollar amount to the Team whose
    //     award button was pressed.
	@FXML
	void teamAwardHandler(ActionEvent event) throws IOException
	{
		Button btn = (Button)event.getSource();
		
		// check which button is selected...
		if (btn.getId() == team1Id.getId())
			team1.updateScore(dollarAmount);
		else
			team2.updateScore(dollarAmount);
		
		// go back to the game screen whenever a team is rewarded
		backToGame(event);
	}
    
	/////////////////////////
	/// Loader Functions ///
	///////////////////////
    
	//METHOD: setGameInfo
	//Input: Two Team objects and an integer dollar amount
	//Output: None
	//Use: Stores the given Teams and dollar amount value for this current question
    public void setGameInfo(Team team1, Team team2, int dollarAmount)
	{
		this.team1 = team1;
		this.team2 = team2;
		this.dollarAmount = dollarAmount;
	}
	
    //METHOD: loadQuestion
    //Input: A Question object, an ArrayList of Button FX IDs, and the FX ID of the current button
    //Output: None
    //Use: Takes in pre-loading data to populate text fields and mark the current question as complete.
	public void loadQuestion(Question q, ArrayList<String> hiddenButtons, String buttonFxId)
	{
		//Fill in question and answer choice fields and team name fields
		questionArea.setText(q.getQuestion());
		optionA.setText(q.getOptionA());
		optionB.setText(q.getOptionB());
		optionC.setText(q.getOptionC());
		optionD.setText(q.getOptionD());
		team1Id.setText(this.team1.getTeamName());
    	team2Id.setText(this.team2.getTeamName());
		
		//Initialize the completed buttons Array if it is empty
		if(hiddenButtons == null)
		{
			hiddenButtons = new ArrayList<String>();
		}
		
		//Add the current button to completed buttons
		completedBtns = hiddenButtons;
		completedBtns.add(buttonFxId);
	}
	
	//METHOD: backToGame
	//Input: An ActionEvent
	//Output: None
	//Use: Changes the view back to the main game screen, passing the necessary game data.
	public void backToGame(ActionEvent event) throws IOException
	{
		//Load FXML file
		URL url = new File("src/application/view/JeopardyGame.fxml").toURI().toURL();
    	FXMLLoader loader = new FXMLLoader(url);
    	AnchorPane gView = loader.load();
    	
    	//Get controller to pass game data
    	JeopardyController control = loader.getController();
    	control.updateGame(team1, team2, completedBtns);
    	
    	//Set scene and change display
    	Scene scene = new Scene(gView,1035,700);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setResizable(false);
    	window.setScene(scene);
    	window.show();
	}
}
