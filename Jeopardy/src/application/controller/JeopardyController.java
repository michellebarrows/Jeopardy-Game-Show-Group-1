package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import application.model.Category;
import application.model.Jeopardy;
import application.model.Question;
import application.model.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/********************************************************************************************
 * CLASS: JeopardyController
 * 
 * Attributes:
 *  - An ArrayList of Categories to hold the game categories and their questions
 *  - An ArrayList of Strings to hold the FX IDs of buttons representing completed questions
 *  - A Team object representing the first competing team
 *  - A Team object representing the second competing team
 *  - A Team object representing the winning team
 *  - A constant integer representing the total number of question buttons
 *  - FXML attributes
 *  
 * Use:
 *  Supplies the main logic and data storage for the main game view (JeopardyGame.fxml)
 *
 *******************************************************************************************/
public class JeopardyController {

    ArrayList<Category> categoryList;
    ArrayList<String> completedBtns;
    Team team1;
    Team team2;
    Team winner;
	
    public static final int NUM_BUTTONS = 25;
    
	///////////////////////
	/// FXML Variables ///
	/////////////////////
    @FXML
    private AnchorPane mainPane;
    
    // 1st number represents category number
    // 2nd number represents question number
                 /*Cat.0, Cat.1, Cat.2, Cat.3, Cat.4 */
    @FXML
    private Button btn00, btn01, btn02, btn03, btn04, // Question 1
    			   btn10, btn11, btn12, btn13, btn14, // Question 2
    			   btn20, btn21, btn22, btn23, btn24, // Question 3
    			   btn30, btn31, btn32, btn33, btn34, // Question 4
    			   btn40, btn41, btn42, btn43, btn44; // Question 5
    @FXML
    private TextField category0, category1, 
    		category2, category3, category4;
    @FXML
    private TextField team1Name, team2Name;
    @FXML
    private TextField team1Score, team2Score;
    
    
	//////////////////////
	/// FXML Handlers ///
	/////////////////////
    
    //METHOD: toQuestionScreenHandler
    //Input: An ActionEvent
    //Output: None
    //Use: Checks which question button was clicked using getQuestion method 
    //	   and switches to the question screen using question data.
    @FXML
    void toQuestionScreenHandler(ActionEvent event) throws IOException
    {
    	//load FXML file
    	URL url = new File("src/application/view/QuestionView.fxml").toURI().toURL();
    	FXMLLoader loader = new FXMLLoader(url);
    	AnchorPane qView = loader.load();
    	
    	//get Controller class to pass in Question data
    	QuestionController control = loader.getController();
    	Button butt = (Button)event.getSource();
    	String buttonFxId = butt.getId();
    	int dollarAmount = getQuestion(buttonFxId).getDollarAmount();
    	control.setGameInfo(team1, team2, dollarAmount);
    	control.loadQuestion(getQuestion(buttonFxId), completedBtns, buttonFxId);
    	
    	//load in new scene and set display
    	Scene scene = new Scene(qView,1035,700);
    	scene.getStylesheets().add(getClass().getResource("questions.css").toExternalForm());
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setResizable(false);
    	window.setScene(scene);
    	window.show();
    }
    
    @FXML
    void endGameHandler(ActionEvent event) throws IOException
    {
			//load FXML file
	    	URL url = new File("src/application/view/EndGameScreen.fxml").toURI().toURL();
	    	FXMLLoader loader = new FXMLLoader(url);
	    	AnchorPane endScreen = loader.load();
	    	EndGameController controller = loader.getController();
	    	controller.updateWinningText(team1, team2);
	    	
	    	//load in new scene and set display
	    	Scene scene = new Scene(endScreen,1035,578);
	    	scene.getStylesheets().add(getClass().getResource("questions.css").toExternalForm());
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    	window.setResizable(false);
	    	window.setScene(scene);
	    	window.show();
    }
    
	/////////////////////////
	/// Loader Functions ///
	///////////////////////
    
    //METHOD: initialize
    //Input: None
    //Output: None
    //Use: Automatically called when FXML is loaded. Populates the category name fields and
    //     reads in all question data using the Jeopardy class.
    public void initialize() 
    {   	
    	TextField[] categoryTextFields = {category0, category1, category2, category3, category4};	
    	Jeopardy test = new Jeopardy();
    	categoryList = test.readQuestionData();
    	
    	for(int i = 0; i < categoryTextFields.length; i++) {
    		categoryTextFields[i].setText((categoryList.get(i).getName()).toUpperCase());
    	}
    }
    
    //METHOD: updateGame
    //Input: Two Team classes representing each competing team, and
    //       an ArrayList of question buttons that have already been completed
    //Output: None
    //Use: Populates the Team and score displays, hides all buttons contained in
    //     the list of completed questions, and checks if all questions have been completed.
    //     The game ends if all buttons have been clicked.
    public void updateGame(Team teamOne, Team teamTwo, ArrayList<String> btnList)
    {
    	//Storing team data and current completed questions
    	team1 = teamOne;
    	team2 = teamTwo;
    	completedBtns = btnList;
    	
    	//Populate team name and current score fields
    	team1Name.setText(team1.getTeamName());
    	team2Name.setText(team2.getTeamName());
    	team1Score.setText("$" + team1.getScore());
    	team2Score.setText("$" + team2.getScore());
    	
    	//Hide all buttons contained in the completed questions list
    	if(completedBtns != null)
    	{		
    		for (String id : completedBtns)
    		{
    			Button btn = (Button)mainPane.lookup("#" + id);
    			btn.setDisable(true);
    			btn.setVisible(false);
    		}
    	}
    }
    
	/////////////////////////
	/// Helper Functions ///
	///////////////////////
    
    //METHOD: getQuestion
    //Input: A String representing the FXML ID of the button the user has clicked
    //Output: A Question representing the clicked button's respective question
    public Question getQuestion(String buttonID)
    {
    	//Find category from button's FX ID (first number)
    	int categoryIndex = Character.getNumericValue(buttonID.charAt(3));
    	//Find question from button's FX ID (second number)
    	int questionIndex = Character.getNumericValue(buttonID.charAt(4));
    	
    	return categoryList.get(categoryIndex).getQuestions().get(questionIndex);
    }
}
