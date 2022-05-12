package proj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.Vector;

public class TestManager {
	Scanner input = new Scanner(System.in);

	private Map<Integer, OpenQuestion> openQuestions;
	private Map<Integer, AmericanQuestion> americanQuestions;
	private ArrayList<Exam> allExams;

//********************************************************************************
	public TestManager() {
		this.openQuestions = new HashMap<>();
		this.americanQuestions = new HashMap<>();
		this.allExams = new ArrayList<>();

	}

//********************************************************************************
	public Map<Integer, OpenQuestion> getOpenQuestions() {
		return openQuestions;
	}

	public Map<Integer, AmericanQuestion> getAmericanQuestions() {
		return americanQuestions;
	}

	public ArrayList<Exam> getAllExams() {
		return allExams;
	}

	// ********************************************************************************
	public void reStart() {
		// OPEN QUESTIONS
		String q1 = "Which animal is known to spend 90% of its day, sleeping?";
		String a1 = "Koala";
		OpenQuestion op1 = new OpenQuestion(q1, a1);
		openQuestions.put(op1.getSerial(), op1);

		String q2 = "What color is the tongue of a giraffe??";
		String a2 = "Purple";
		OpenQuestion op2 = new OpenQuestion(q2, a2);
		openQuestions.put(op2.getSerial(), op2);

		String q3 = "What is the name of the fastest land animal?";
		String a3 = "Cheetah";
		OpenQuestion op3 = new OpenQuestion(q3, a3);
		openQuestions.put(op3.getSerial(), op3);

		// AMERICAN QUESTIONS
		AmericanQuestion q4 = new AmericanQuestion("What name is given to a female deer?");
		americanQuestions.put(q4.getSerial(), q4);
		americanQuestions.get(q4.getSerial()).addAnswer(new Answer("Deera", false));
		americanQuestions.get(q4.getSerial()).addAnswer(new Answer("Debra", false));
		americanQuestions.get(q4.getSerial()).addAnswer(new Answer("Der", false));
		americanQuestions.get(q4.getSerial()).addAnswer(new Answer("Deer", false));

		AmericanQuestion q5 = new AmericanQuestion("What animal is said to have 9 lives?");
		americanQuestions.put(q5.getSerial(), q5);
		americanQuestions.get(q5.getSerial()).addAnswer(new Answer("Deer", false));
		americanQuestions.get(q5.getSerial()).addAnswer(new Answer("Dog", false));
		americanQuestions.get(q5.getSerial()).addAnswer(new Answer("Cat", true));
		americanQuestions.get(q5.getSerial()).addAnswer(new Answer("Whale", false));

		AmericanQuestion q6 = new AmericanQuestion("What animal is the largest animal in the world?");
		americanQuestions.put(q6.getSerial(), q6);
		americanQuestions.get(q6.getSerial()).addAnswer(new Answer("African Elephant", false));
		americanQuestions.get(q6.getSerial()).addAnswer(new Answer("White Rhinoceros", false));
		americanQuestions.get(q6.getSerial()).addAnswer(new Answer("Blue Whale", true));
		americanQuestions.get(q6.getSerial()).addAnswer(new Answer("Killer Whale", false));
	}

//********************************************************************************
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("-----Question view:-----\n\n");
		s.append("Open questions in system: \n");
		for (Integer i : openQuestions.keySet()) {
			s.append(openQuestions.get(i).toString());
		}
		s.append("\nAmerican questions in system: \n");
		for (Integer i : americanQuestions.keySet()) {
			s.append(americanQuestions.get(i).toString());

		}
		return s.toString();
	}

//********************************************************************************
	public StringBuffer printOpenQuestionsWithSerial() {
		StringBuffer s = new StringBuffer();
		s.append("There are all the open questions in the system:\n");

		for (Integer i : openQuestions.keySet()) {
			s.append(openQuestions.get(i).toString());
		}
		return s;
	}

	public StringBuffer printAmericanQuestionsWithSerial() {
		StringBuffer s = new StringBuffer();
		s.append("There are all the american questions in the system:\n");

		for (Integer i : americanQuestions.keySet()) {
			s.append(americanQuestions.get(i).toString());
		}

		return s;
	}

//********************************************************************************
	public StringBuffer printAmericanAnswers(int serial) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < americanQuestions.get(serial).getAnswer().size(); i++) {
			s.append(i + 1 + ") " + americanQuestions.get(serial).getAnswer().get(i).toString() + "\n");
		}
		return s;
	}

//********************************************************************************
	public StringBuffer printExams() {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < allExams.size(); i++) {
			s.append("   Exam number " + (i + 1) + "\n");
			s.append(allExams.get(i));
		}
		return s;
	}

//********************************************************************************
	public void copyTest(int numOfExam) {
		allExams.add(allExams.get(numOfExam - 1));
	}
//********************************************************************************
	public int addAmericanQuestion(String question) {
		AmericanQuestion newQ = new AmericanQuestion(question);
		americanQuestions.put(newQ.getSerial(), newQ);
		return newQ.getSerial();
	}

	public int addOpenQuestion(String question, String answer) {
		OpenQuestion newQ = new OpenQuestion(question, answer);
		openQuestions.put(newQ.getSerial(), newQ);
		return newQ.getSerial();
	}
//********************************************************************************
	public void addAmericanAnswer(int serial, String answer, boolean isCorrect) {
		americanQuestions.get(serial).addAnswer(answer, isCorrect);
	}
//********************************************************************************
	public boolean isQuestionExist(char type, String question) {

		if (type == 'a' || type == 'A') { // american
			for (Integer i : americanQuestions.keySet()) {
				if (americanQuestions.get(i).getQuestion().equals(question)) {
					return true;
				}
			}
		}

		if (type == 'o' || type == 'O') { // open
			for (Integer i : openQuestions.keySet()) {
				if (openQuestions.get(i).getQuestion().equals(question)) {
					return true;
				}
			}
		}
		return false;
	}

//********************************************************************************
	public boolean findAmericanQuestion(int id) {
		return americanQuestions.containsKey(id);
	}

	public boolean findOpenQuestion(int id) {
		return openQuestions.containsKey(id);
	}

//********************************************************************************
	public void upDateOpenQuestion(int serial, String newQ) {
		openQuestions.get(serial).setQuestion(newQ);
	}

	public void upDateAmericanQuestion(int serial, String newQ) {
		americanQuestions.get(serial).setQuestion(newQ);
	}

//********************************************************************************
	public void upDateOpenAnswer(int serial, String newA) {
		openQuestions.get(serial).setAnswer(newA);
	}

	public void upDateAmericanAnswer(int serial, int numOfAnswer, String newA, boolean ifCorrect) {
		americanQuestions.get(serial).setAnswer(numOfAnswer, newA, ifCorrect);
	}

//********************************************************************************
	public void deleteAmericanAnswer(int serial, int numOfAnswer) {
		americanQuestions.get(serial).deleteAnswer(numOfAnswer);
	}

//********************************************************************************
	public Exam createExamManualy(int[] serialNumbers) {

		ArrayList<Question> questionsForTest = new ArrayList<Question>();

		for (int i = 0; i < serialNumbers.length; i++) {
			int serial = serialNumbers[i];
			if (americanQuestions.containsKey(serial)) { // question is american
				questionsForTest.add(new AmericanQuestion(americanQuestions.get(serial)));
				questionsForTest.get(i).addAnswer("There are no correct answers", true); // adding defult answers
				questionsForTest.get(i).addAnswer("There are more than one correct answer", false);
			} else {
				questionsForTest.add(new OpenQuestion(openQuestions.get(serial)));
			}
		}
		Exam newExam = new Exam(questionsForTest);
		return newExam;
	}

//********************************************************************************
	public StringBuffer createAutoExam(int numOfQuestions, int sortType) {
		int numA = americanQuestions.size();
		int numO = openQuestions.size();

		ArrayList<Integer> randomQuestions = buildRandomArr(numOfQuestions, numO + numA, 1000);
		ArrayList<Question> questionsForTest = new ArrayList<>();

		for (int i = 0; i < randomQuestions.size(); i++) {
			int serial = randomQuestions.get(i);

			if (americanQuestions.containsKey(serial)) { // question is american
				questionsForTest.add(new AmericanQuestion(americanQuestions.get(serial)));
				ArrayList<Integer> randomNumbers = buildRandomArr(4, americanQuestions.get(serial).getAnswer().size(),0);
				questionsForTest.get(i).addAnswer("There are no correct answers", true); // adding defult answers
				questionsForTest.get(i).addAnswer("There are more than one correct answer", false);

				for (int m = 0; m < randomNumbers.size(); m++) { // adding answers
					String answer = americanQuestions.get(serial).getAnswer().get(randomNumbers.get(m)).getAnswer();
					boolean ifCorrect = americanQuestions.get(serial).getAnswer().get(randomNumbers.get(m)).isCorrect();
					questionsForTest.get(i).addAnswer(answer, ifCorrect);
				}
				((AmericanQuestion) questionsForTest.get(i)).upDateDefultAnswers();
			}

			else { // question is open
				questionsForTest.add(new OpenQuestion(openQuestions.get(serial)));
			}
		}

		Exam newExam = new Exam(questionsForTest);
		sortExam(newExam, sortType);
		allExams.add(newExam);
		StringBuffer s = new StringBuffer();
		s.append(newExam);
		s.append(saveExamToFile(newExam));
		return s;
	}
//********************************************************************************
	// this function randomize lengthArr numbers in range from start to end
	private ArrayList<Integer> buildRandomArr(int lengthArr, int end, int start) {
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

		for (int i = 0; i < lengthArr; i++) {
			int rand = (int) ((Math.random() * (end)) + start);
			while (randomNumbers.contains(rand)) {
				rand = (int) ((Math.random() * (end)) + start);
			}
			randomNumbers.add(rand);
		}
		return randomNumbers;
	}
//********************************************************************************
	public void sortExam(Exam newExam, int sortType) {
		if (sortType == 1) {
			newExam.getQuestions().sort(new CompareQuestionsLexicodraphy());
		} else if (sortType == 2) {
			newExam.getQuestions().sort(new CompareQuestionsByAnswerLength());
		}
	}
//********************************************************************************
	public StringBuffer saveExamToFile(Exam newExam) {
		StringBuffer s = new StringBuffer();
		Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		StringBuffer fileName = new StringBuffer("exam_"); // create exam
		fileName.append(localCalendar.get(Calendar.DATE) + "_");
		fileName.append((localCalendar.get(Calendar.MONTH) + 1) + "_");
		fileName.append(localCalendar.get(Calendar.YEAR));
		fileName.append(".txt");
		File examFile = new File(fileName.toString());
		try {
			examFile.createNewFile();
			s.append("File created: " + examFile.getName() + "\n");
			newExam.save(examFile);

		} catch (IOException e) {
			s.append("An error occurred.\n");
		}

		StringBuffer solutionName = new StringBuffer("solution_"); // create solution
		solutionName.append(localCalendar.get(Calendar.DATE) + "_");
		solutionName.append((localCalendar.get(Calendar.MONTH) + 1) + "_");
		solutionName.append(localCalendar.get(Calendar.YEAR));
		solutionName.append(".txt");
		File solutionFile = new File(solutionName.toString());
		try {
			solutionFile.createNewFile();
			s.append("File created: " + solutionFile.getName() + "\n");
			newExam.saveWithSolution(solutionFile);

		} catch (IOException e) {
			s.append("An error occurred.\n");
		}

		return s;
	}
//********************************************************************************
	public void saveQuestionStock() throws FileNotFoundException, IOException {
		ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("questions_stock"));
		HashMap <Integer, Question> allQuestions=new HashMap<Integer,Question>();
		for (Integer i : openQuestions.keySet()) {
			allQuestions.put(openQuestions.get(i).getSerial(), openQuestions.get(i));
		}
		for (Integer i : americanQuestions.keySet()) {
			allQuestions.put(americanQuestions.get(i).getSerial(), americanQuestions.get(i));
		}
		outFile.writeObject(allQuestions);
		outFile.close();
	}
//********************************************************************************
		public void loadQuestionStock() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("questions_stock"));
		HashMap<Integer, Question> allQuestions =(HashMap<Integer, Question>) inputStream.readObject();
		
	    for (Integer i : allQuestions.keySet()) {
	    	if (allQuestions.get(i) instanceof OpenQuestion) {
	    		openQuestions.put(allQuestions.get(i).getSerial(), (OpenQuestion) allQuestions.get(i));
	    	}
	    	else {
	    		americanQuestions.put(allQuestions.get(i).getSerial(), (AmericanQuestion) allQuestions.get(i));
	    	}
	    }
	    setCounterSerial(allQuestions.size()+1000);     //update serial
		inputStream.close();
	}
//********************************************************************************

private void setCounterSerial(int i) {
	Question.setCounterSerial(i);
	
}

		
}
