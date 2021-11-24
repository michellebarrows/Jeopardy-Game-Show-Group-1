package application.controller;

import application.model.Team;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class EndGameController
{
	@FXML
    private TextArea textWinningTeam;

    public void updateWinningText(Team team1, Team team2)
    {
    	if (team1.getScore() > team2.getScore())
    		textWinningTeam.setText("Team " + team1.getTeamName() + " wins with a prize of $" + team1.getScore() + "!");
    	else if (team1.getScore() < team2.getScore())
    		textWinningTeam.setText("Team " + team2.getTeamName() + " wins with a prize of $" + team2.getScore() + "!");
    	else
    		textWinningTeam.setText("It's a tie!");
    }

}
