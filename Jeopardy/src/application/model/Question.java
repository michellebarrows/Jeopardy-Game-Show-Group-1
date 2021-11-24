package application.model;

/********************************************************************
 * CLASS: Question
 * 
 * Attributes:
 *  - A String representing the question body
 *  - A String representing the first answer choice
 *  - A String representing the second answer choice
 *  - A String representing the third answer choice
 *  - A String representing the fourth answer choice
 *  - A String representing the correct answer choice (a, b, c, or d)
 *  - An integer representing the dollar value of the question
 *  
 * Use:
 *  Handles data storage and access for question data
 *
 ********************************************************************/

public class Question {

	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private int dollarAmount;
	
	//Constructor
	public Question(String question, String optionA, String optionB, String optionC, String optionD, String answer,
			int dollarAmount) {
		super();
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.dollarAmount = dollarAmount;
	}
	
	//////////////////////////
	/// GETTERS & SETTERS ///
	////////////////////////
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getDollarAmount() {
		return dollarAmount;
	}

	public void setDollarAmount(int dollarAmount) {
		this.dollarAmount = dollarAmount;
	}
	
	//toString override
	public String toString() {
		String q = "Question: " + getQuestion() + "\n"
				+ "A) " + getOptionA() + "\n"
				+ "B) " + getOptionB() + "\n"
				+ "C) " + getOptionC() + "\n"
				+ "D) " + getOptionD() + "\n"
				+ "Correct Answer is: " + getAnswer() + " for $" + getDollarAmount() + "!\n";
		
		return q;
	}
}
