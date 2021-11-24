package application.model;

/***************************************************
 * CLASS: Team
 * 
 * Attributes:
 *  - A String representing the team name
 *  - An integer representing the current score
 *  
 * Use:
 *  Handles data storage and access for team data
 *
 *************************************************/

public class Team 
{
	String teamName;
	int score;
	
	//Constructor
	public Team(String teamName)
	{
		this.teamName = teamName;
		score = 0;
	}

	//////////////////////////
	/// GETTERS & SETTERS ///
	////////////////////////
	
	public String getTeamName() 
	{
		return teamName;
	}

	public int getScore() 
	{
		return score;
	}

	public void updateScore(int score) 
	{
		this.score += score;
	}
	
	//toString override
	@Override
	public String toString()
	{
		String output = "Team: " + teamName + "\nCurrent score: " + score;
		return output;
	}
}
