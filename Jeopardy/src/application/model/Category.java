package application.model;

import java.util.ArrayList;

public class Category {
	
	private String name;
	private ArrayList<Question> questions;
	
	public Category(String name, ArrayList<Question> questions) {
		super();
		this.name = name;
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	public String toString() {
		return "Category: " + getName() + "\n";
	}
	
	
	
	

}

