package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Exam implements canWorkWithFile {
	
    private	ArrayList<Question> questions;
//********************************************************************************
	public Exam(ArrayList <Question> q) {
		this.questions = q;
	}
	//********************************************************************************
	public String toString() {
		StringBuffer s= new StringBuffer("-------Exam------- \n\n");
		for (int i = 0; i < questions.size(); i++) {
			s.append(questions.get(i).toString());
			s.append("\n");
		}
		return s.toString();
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


public void readFromFile() {

	
}
public void save(File examFile) throws FileNotFoundException {
	PrintWriter pw = new PrintWriter(examFile);
	pw.println(toString());
	pw.close();
}

public void saveToFile(File examFile) {
	
	
}

	
}
