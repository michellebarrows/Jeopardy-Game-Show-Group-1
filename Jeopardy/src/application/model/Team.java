package application.model;

public class Team 
{
	String teamName;
	int score;
	
	public Team(String teamName)
	{
		this.teamName = teamName;
		score = 0;
	}

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
	
	@Override
	public String toString()
	{
		String output = "Team: " + teamName + "\nCurrent score: " + score;
		return output;
	}
}
