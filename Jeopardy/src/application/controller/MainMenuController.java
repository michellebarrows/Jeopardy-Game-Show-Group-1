package application.controller;

import java.io.IOException;

import application.model.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

/************************************************************************************
 * CLASS: MainMenuController
 * 
 * Attributes:
 *  - FXML attributes
 *  
 * Use:
 *  Supplies the main logic and data storage for the main menu view (MainMenu.fxml)
 *
 ***********************************************************************************/

public class MainMenuController 
{

	///////////////////////
	/// FXML Variables ///
	/////////////////////
	
    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField team1NameField;
    @FXML
    private TextField team2NameField;
    @FXML
    private TextField errorMessage;
    
	//////////////////////
	/// FXML Handlers ///
	/////////////////////
    
    //METHOD: handlePlay
    //Input: An ActionEvent
    //Output: None
    //Use: Switches the view to the main game screen upon play button pressed
    @FXML
    void handlePlay(ActionEvent event) 
    {
    	Team team1 = null;
    	Team team2 = null;
    	
    	//check if team names are valid
    	if((team1NameField.getText().length() > 0) && (team2NameField.getText().length() > 0))
    	{
    		team1 = new Team(team1NameField.getText());
    		team2 = new Team(team2NameField.getText());
    	}
    	
    	else
    	{
    		errorMessage.setText("Enter a valid team name for both teams!");
    		return;
    	}
    	
    	//switch to game view
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("./application/view/JeopardyGame.fxml"));
			mainPane = loader.load();
			
			//passing in new game data
			JeopardyController control = loader.getController();
			control.updateGame(team1, team2, null);
			
	        Scene scene = new Scene(mainPane);
	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window.setResizable(false);
	        window.setScene(scene);
	        window.show();
		} catch (IOException e) 
		{
			System.out.println("Error loading FXML file:\n");
			e.printStackTrace();
			System.exit(1);
		}
    }

    //METHOD: handleQuit
    //Input: An ActionEvent
    //Output: None
    //Use: closes the program with no error message upon Quit button pressed
    @FXML
    void handleQuit(ActionEvent event) 
    {
    	System.exit(0);
    }

}
