package application.model;

import java.util.ArrayList;

public class Category {
	
	private String name;
	private ArrayList<Question> questions;
	
	public Category(String name, ArrayList<Question> questions) {
		this.name = name;
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public String toString() {
		return "Category: " + getName() + "\n";
	}
}

