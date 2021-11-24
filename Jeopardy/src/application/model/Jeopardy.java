package application.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/***********************************************************
 * CLASS: Jeopardy
 * 
 * Attributes: None
 *  
 * Use:
 *  Provides helper functions for reading in question data 
 *
 **********************************************************/

public class Jeopardy {
	
	//METHOD: readQuestionData
	//Input: None
	//Output: an ArrayList of Category objects
	//Use: calls on readQuestionsFromFile to read a list of questions and returns a list of them
	public ArrayList<Category> readQuestionData(){
		ArrayList<Category> categories = new ArrayList<>();
		
		categories.add(readQuestionsFromFile("animals.csv"));
		categories.add(readQuestionsFromFile("history.csv"));
		categories.add(readQuestionsFromFile("math.csv"));
		categories.add(readQuestionsFromFile("tv.csv"));
		categories.add(readQuestionsFromFile("games.csv"));
		
		return categories;
	}

	//METHOD: readQuestionsFromFile
	//Input: A String representing a file to be read from
	//Output: A new Category object containing its respective questions
	//Use: reads from the given file to create a new Category containing Questions
	private Category readQuestionsFromFile(String filename) {
		ArrayList<Question> questions = new ArrayList<>();
		Path pathToFile = Paths.get("src/application/data/"+filename);
		try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                 Question question = createQuestion(attributes);
                // adding the question into the ArrayList
                questions.add(question);
                // read next line before looping
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
		return new Category(filename.substring(0,filename.length()-4),questions);
	}

	//METHOD: createQuestion
	//Input: a String of formatted question data
	//Output: a new Question from parsed data
	//Use: creates a question based on attributes
	private Question createQuestion(String[] attributes) {
		String question = attributes[0];
		String optionA = attributes[1];
		String optionB = attributes[2];
		String optionC = attributes[3];
		String optionD = attributes[4];
		String answer = attributes[5];
		int dollarAmount = Integer.parseInt(attributes[6]);
		
		return new Question(question, optionA, optionB, optionC, optionD, answer, dollarAmount);
	}

}
