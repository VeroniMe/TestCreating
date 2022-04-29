package project;

import java.util.ArrayList;
import java.util.Arrays;

public class AmericanQuestion extends Question {

	private ArrayList<Answer> answers;
	private final int MAX_NUM_ANSWERS = 10;
	private final int MIN_NUM_ANSWERS = 4;	
	
//********************************************************************************
	public AmericanQuestion (String question) {
		super(question);
		this.answers = new ArrayList<>();
	}
	
	public AmericanQuestion (AmericanQuestion newQ) {
		super(newQ);
		this.answers = new ArrayList<>();
	}
//********************************************************************************
	public String toString() {
		String s = super.toString() + "\n";
		for (int i = 0; i < answers.size(); i++) {
			s = s + "\t" + (i + 1) + ") " + answers.get(i) + "\n";
		}
		return s;
	}
//********************************************************************************
	public String getQuestion() {
		return super.getQuestion();
	}

	public ArrayList<Answer> getAnswer() {
		return answers;
	}

	public int getMaxAnswersNumber() {
		return MAX_NUM_ANSWERS;
	}

	public int getMinAnswersNumber() {
		return MIN_NUM_ANSWERS;
	}
//********************************************************************************
	public void setAnswer(int num, String newA, boolean ifCorrect) {
		answers.get(num).setAnswer(newA);
		answers.get(num).setCorrect(ifCorrect);
	}
    public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
//********************************************************************************
	public boolean addAnswer(Answer newAnswer) {
		if (answers.size() != MAX_NUM_ANSWERS) {
			answers.add(newAnswer);
			return true;
		}
		return false;
	}
//********************************************************************************
	public boolean addAnswer(String a, boolean isC) {////////////////*********change to string and boolean
		if (answers.size() != MAX_NUM_ANSWERS) {
			answers.add(new Answer(a,isC));
			return true;
		}
		return false;
	}
//********************************************************************************
	public void deleteAnswer(int num) {		
		answers.set(num, answers.get(answers.size() - 1));
		answers.remove(answers.size() - 1);
	}
//********************************************************************************
//This function check how many correct answers exist in American question and
// according this update default answers
	
	public void upDateDefultAnswers() {
		int correctCounter = 0; //count how many correct answers for question
		for (int i = 2; i < answers.size(); i++) {
			if(answers.get(i).isCorrect() == true) {
				correctCounter++;
			}
		}
		if(correctCounter == 0) {
			answers.get(0).setCorrect(true);
			answers.get(1).setCorrect(false);
			}
		if (correctCounter > 0) {
			answers.get(0).setCorrect(false);
		} if (correctCounter > 1) {
			answers.get(1).setCorrect(true);
			for (int i = 2; i < answers.size(); i++) {
				answers.get(i).setCorrect(false);
			}
		} 
	}
//********************************************************************************
	public int getAnswerLength() {
		int length = 0;
		for (Answer a : answers) 
		{ 
		    length = length + a.getLength();
		}
		return length;
	}

	
	
}
