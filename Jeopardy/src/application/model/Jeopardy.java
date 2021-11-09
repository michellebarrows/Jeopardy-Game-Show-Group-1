package application.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Jeopardy {
	//calls on readQuestionsFromFile to read a list of questions and returns a list of them
	public ArrayList<Question> readQuestionData(){
		ArrayList<Question> questions = readQuestionsFromFile("questionsTest.csv");
		return questions;
	}

	//
	private ArrayList<Question> readQuestionsFromFile(String filename) {
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
		return questions;
	}

	//creates a question based on attributes
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
