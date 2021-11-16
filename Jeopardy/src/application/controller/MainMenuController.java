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

public class MainMenuController {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField team1NameField;
    @FXML
    private TextField team2NameField;
    @FXML
    private TextField errorMessage;
    
    @FXML
    void handlePlay(ActionEvent event) 
    {
    	Team team1 = null;
    	Team team2 = null;
    	
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
    	
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("./application/view/JeopardyGame.fxml"));
			mainPane = loader.load();
			
			JeopardyController control = loader.getController();
			control.setData(team1, team2);
			
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

    @FXML
    void handleQuit(ActionEvent event) 
    {
    	System.exit(0);
    }

    @FXML
    void handleScores(ActionEvent event) 
    {

    }

}
