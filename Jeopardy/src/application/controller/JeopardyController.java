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

public class JeopardyController {

    ArrayList<Category> categoryList;
    ArrayList<String> hiddenBtns;
    Team team1;
    Team team2;
    Team winner;
	
    public static final int NUM_BUTTONS = 25;
    
	///////////////////////
	/// FXML Variables ///
	/////////////////////
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
    
    
	//////////////////////
	/// FXML Handlers ///
	/////////////////////
    
    @FXML
    void toQuestionScreenHandler(ActionEvent event) throws IOException
    {
    	URL url = new File("src/application/view/QuestionView.fxml").toURI().toURL();
    	FXMLLoader loader = new FXMLLoader(url);
    	AnchorPane qView = loader.load();
    	QuestionController control = loader.getController();
    	Button butt = (Button)event.getSource();
    	String buttonFxId = butt.getId();
    	int dollarAmount = Integer.parseInt(butt.getText().substring(1));
    	control.setGameInfo(team1, team2, dollarAmount);
    	control.loadQuestion(getQuestion(buttonFxId), hiddenBtns, buttonFxId);
    	Scene scene = new Scene(qView,1035,700);
    	scene.getStylesheets().add(getClass().getResource("questions.css").toExternalForm());
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setResizable(false);
    	window.setScene(scene);
    	window.show();
    }
    
	/////////////////////////
	/// Loader Functions ///
	///////////////////////
    
    public void initialize() 
    {   	
    	TextField[] categoryTextFields = {category0, category1, category2, category3, category4};	
    	Jeopardy test = new Jeopardy();
    	categoryList = test.readQuestionData();
    	
    	for(int i = 0; i < categoryTextFields.length; i++) {
    		categoryTextFields[i].setText((categoryList.get(i).getName()).toUpperCase());
    	}
    }
    
    public void updateGame(Team teamOne, Team teamTwo, ArrayList<String> btnList)
    {
    	team1 = teamOne;
    	team2 = teamTwo;
    	hiddenBtns = btnList;
    	
    	team1Name.setText(team1.getTeamName());
    	team2Name.setText(team2.getTeamName());
    	team1Score.setText("$" + team1.getScore());
    	team2Score.setText("$" + team2.getScore());
    	
    	if(hiddenBtns != null)
    	{		
    		for (String id : hiddenBtns)
    		{
    			Button btn = (Button)mainPane.lookup("#" + id);
    			btn.setDisable(true);
    			btn.setVisible(false);
    		}
    		
    		if (hiddenBtns.size() == NUM_BUTTONS)
    		{
    			winner = (team1.getScore() > team2.getScore()) ? team1 : team2;

        		//todo: send to end screen with winning team
        	}
    	}
    }
    
	/////////////////////////
	/// Helper Functions ///
	///////////////////////
    
    public Question getQuestion(String buttonID)
    {
    	int categoryIndex = Character.getNumericValue(buttonID.charAt(3));
    	int questionIndex = Character.getNumericValue(buttonID.charAt(4));
    	
    	return categoryList.get(categoryIndex).getQuestions().get(questionIndex);
    }
}
