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

public class QuestionController 
{
	Team team1;
	Team team2;
	ArrayList<String> hiddenBtns;
	
    @FXML
    private TextArea questionArea;
    @FXML
    private Button backButton;
    @FXML
    private TextField optionA, optionB, optionC, optionD;

	public void setTeams(Team team1, Team team2)
	{
		this.team1 = team1;
		this.team2 = team2;
	}
	
	public void loadQuestion(Question q, ArrayList<String> hiddenButtons, String id)
	{
		questionArea.setText(q.getQuestion());
		optionA.setText(q.getOptionA());
		optionB.setText(q.getOptionB());
		optionC.setText(q.getOptionC());
		optionD.setText(q.getOptionD());
		
		if(hiddenButtons == null)
		{
			hiddenButtons = new ArrayList<String>();
		}
		
		hiddenBtns = hiddenButtons;
		hiddenBtns.add(id);
	}
	

    @FXML
    void backToGame(ActionEvent event) throws IOException
    {
    	URL url = new File("src/application/view/JeopardyGame.fxml").toURI().toURL();
    	FXMLLoader loader = new FXMLLoader(url);
    	AnchorPane gView = loader.load();
    	JeopardyController control = loader.getController();
    	control.setTeams(team1, team2, hiddenBtns);
    	Scene scene = new Scene(gView,1035,700);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setResizable(false);
    	window.setScene(scene);
    	window.show();
    }
}
