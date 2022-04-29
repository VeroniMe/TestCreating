package project;

import java.util.ArrayList;

public class Exam {
	
    private	ArrayList<Question> questions;
//********************************************************************************
	public Exam(ArrayList <Question> q) {
		this.questions = q;
	}
	//********************************************************************************
	public String toString() {
		String s = "-------Exam------- \n\n";
		for (int i = 0; i < questions.size(); i++) {
			s = s + questions.get(i).toString();
			s = s + "\n";
		}
		return s;
	}
//********************************************************************************
	public boolean ifQuestionExist(int id) {
		for (int i = 0; i < questions.size(); i++) {
			if(questions.get(i).getSerial() == id) {
				return true;
			}
		}
		return false;
	}
//********************************************************************************
	public ArrayList<Question> getQuestions() {
		// TODO Auto-generated method stub
		return questions;
	}
	
}
