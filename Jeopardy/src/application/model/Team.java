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

	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}

	public int getScore() 
	{
		return score;
	}

	public void setScore(int score) 
	{
		this.score = score;
	}
	
	@Override
	public String toString()
	{
		String output = "Team: " + teamName + "\nCurrent score: " + score;
		return output;
	}
	
}
