package application.model;

import java.util.ArrayList;

/******************************************************************************
 * CLASS: Category
 * 
 * Attributes:
 *  - A String representing the category name
 *  - An ArrayList of Questions to hold the category's respective questions
 *  
 * Use:
 *  Handles data storage and access for Categories and Questions in the game.
 *
 *****************************************************************************/

public class Category {
	
	private String name;
	private ArrayList<Question> questions;
	
	//Constructor
	public Category(String name, ArrayList<Question> questions) 
	{
		this.name = name;
		this.questions = questions;
	}
	
	/////////////////////////
	/// GETTERS & SETTERS ///
	/////////////////////////
	
	public String getName() 
	{
		return name;
	}

	public ArrayList<Question> getQuestions() 
	{
		return questions;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}

	public void setQuestions(ArrayList<Question> questions) 
	{
		this.questions = questions;
	}
	
	//toString override
	public String toString() {
		return "Category: " + getName() + "\n";
	}
}

