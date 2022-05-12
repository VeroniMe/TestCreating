package test_project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;

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
		// openQuestions.add(op1);
		openQuestions.put(op1.getSerial(), op1);

		String q2 = "What color is the tongue of a giraffe??";
		String a2 = "Purple";
		OpenQuestion op2 = new OpenQuestion(q2, a2);
		// openQuestions.add(op2);
		openQuestions.put(op2.getSerial(), op2);

		String q3 = "What is the name of the fastest land animal?";
		String a3 = "Cheetah";
		OpenQuestion op3 = new OpenQuestion(q3, a3);
		// openQuestions.add(op3);
		openQuestions.put(op3.getSerial(), op3);

		// AMERICAN QUESTIONS
		AmericanQuestion q4 = new AmericanQuestion("What name is given to a female deer?");
//		americanQuestions.add(new AmericanQuestion(q4));
//		americanQuestions.get(0).addAnswer(new Answer("Deera", false));
//		americanQuestions.get(0).addAnswer(new Answer("Debra", false));
//		americanQuestions.get(0).addAnswer(new Answer("Der", false));
//		americanQuestions.get(0).addAnswer(new Answer("Deer", false));

		// americanQuestions.add(new AmericanQuestion(q4));
		americanQuestions.put(q4.getSerial(), q4);
		americanQuestions.get(q4.getSerial()).addAnswer(new Answer("Deera", false));
		americanQuestions.get(q4.getSerial()).addAnswer(new Answer("Debra", false));
		americanQuestions.get(q4.getSerial()).addAnswer(new Answer("Der", false));
		americanQuestions.get(q4.getSerial()).addAnswer(new Answer("Deer", false));

		AmericanQuestion q5 = new AmericanQuestion("What animal is said to have 9 lives?");
//		americanQuestions.add(new AmericanQuestion(q5));
//		americanQuestions.get(1).addAnswer(new Answer("Deer", false));
//		americanQuestions.get(1).addAnswer(new Answer("Dog", false));
//		americanQuestions.get(1).addAnswer(new Answer("Cat", true));
//		americanQuestions.get(1).addAnswer(new Answer("Whale", false));
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

//		americanQuestions.get(2).addAnswer(new Answer("African Elephant", false));
//		americanQuestions.get(2).addAnswer(new Answer("White Rhinoceros", false));
//		americanQuestions.get(2).addAnswer(new Answer("Blue Whale", true));
//		americanQuestions.get(2).addAnswer(new Answer("Killer Whale", false));

	}

//********************************************************************************
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("Question view:\n");
		s.append("Open questions in system: \n");
		for (int i = 0; i < openQuestions.size(); i++) {
			s.append((i + 1) + ") " + openQuestions.get(i).toString() + "\n");
		}
		s.append("American questions in system: \n");
		for (int i = 0; i < americanQuestions.size(); i++) {
			s.append((i + 1) + ") " + americanQuestions.get(i).toString() + "\n");
		}
		return s.toString();
	}

//********************************************************************************
	public boolean isOpenQuestionExist(Question question) {
		for (Integer i : openQuestions.keySet()) {
			if (openQuestions.get(i).equals(question)) {
				return true;
			}
		}
		return false;
	}

	public boolean isAmericanQuestionExist(Question question) {

		for (Integer i : americanQuestions.keySet()) {
			if (americanQuestions.get(i).equals(question)) {
				return true;
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
	public int addAmericanQuestion(String question) {

		AmericanQuestion newQ = new AmericanQuestion(question);
		if (isAmericanQuestionExist(newQ) == true) {
			return -1;
		}
		americanQuestions.put(newQ.getSerial(), newQ);
		return newQ.getSerial();
	}

	public int addOpenQuestion(String question, String answer) {
		OpenQuestion newQ = new OpenQuestion(question, answer);
		if (isOpenQuestionExist(newQ) == true) {
			return -1;
		}
		openQuestions.put(newQ.getSerial(), newQ);
		return newQ.getSerial();
	}

//********************************************************************************
	public StringBuffer printOpenQuestionsWithSerial() {
		StringBuffer s = new StringBuffer();
		s.append("There are all open questions in the system:\n");
//		for (int i = 0; i < openQuestions.size(); i++) {
//			s.append("Question " + openQuestions.get(i).getSerial() + ":");
//			s.append(openQuestions.get(i).getQuestion());
//			s.append("\n");
//		}
		for (Integer i : openQuestions.keySet()) {
			s.append(openQuestions.get(i).toString());
		}
		return s;
	}

	public StringBuffer printAmericanQuestionsWithSerial() {
		StringBuffer s = new StringBuffer();
		s.append("There are all american questions in the system:\n");

//		for (int i = 0; i < americanQuestions.size(); i++) {
//			s.append("Question " + americanQuestions.get(i).getSerial() + ":");
//			s.append(americanQuestions.get(i).getQuestion());
//			s.append("\n");
//		}
		for (Integer i : americanQuestions.keySet()) {
			s.append(americanQuestions.get(i).toString());
		}

		return s;
	}

//********************************************************************************
	public StringBuffer printAmericanAnswers(int serial) {
		// int i = findAmericanQuestion(serial);
		StringBuffer s = new StringBuffer();
		int listNum = 1;
//		for (int j = 0; j < americanQuestions.get(i).getAnswer().size(); j++) {
//			s.append((j + 1) + ") " + americanQuestions.get(i).getAnswer().get(j).toString() + "\n");
//		}
		for (Integer i : americanQuestions.keySet()) {
			s.append(listNum + ") " + americanQuestions.get(i).getAnswer().get(listNum - 1).toString() + "\n");
		}
		return s;
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
	public void deleteAmericanAnswer(int serial, int answer) {
		americanQuestions.get(serial).deleteAnswer(answer);
	}

//********************************************************************************
	public Exam createExamManualy(int[] serialNumbers) throws CloneNotSupportedException {
		
		ArrayList<Question> questionsForTest = new ArrayList<Question>();
		for (int i = 0; i < serialNumbers.length; i++) {
			int index = serialNumbers[i];
			if (americanQuestions.containsKey(index)) {
				questionsForTest.add(new AmericanQuestion(americanQuestions.get(index)));
			 	
			} else {
				//questionsForTest.add(openQuestions.get(index).clone());
				questionsForTest.add(new OpenQuestion(openQuestions.get(index)));
			}
		}
		Exam newExam = new Exam(questionsForTest);
		return newExam;
	}

//		int help;
//		for (int i = 0; i < serialNumbers.length; i++) {
//
//			help = findOpenQuestion(serialNumbers[i]);
//
//			if (help != -1) // question is open
//				questionsForTest.add(openQuestions.get(help));
//
//			else { // question is american
//				help = findAmericanQuestion(serialNumbers[i]);
//				questionsForTest.add(new AmericanQuestion(americanQuestions.get(help))); // ???
//			}
//		}
//		Exam newExam = new Exam(questionsForTest);
//		return newExam;

//********************************************************************************
	public Exam createAutoExam(int num) throws CloneNotSupportedException {
		int numA = americanQuestions.size();
		int numO = openQuestions.size();

		ArrayList<Integer> randomQuestions = buildRandomArr(num, numO + numA, 1000);
		ArrayList<Question> questionsForTest = new ArrayList<>();

		for (int i = 0; i < randomQuestions.size(); i++) {

			// int help = findAmericanQuestion(randomQuestions[i]);
			int serial = randomQuestions.get(i);

			if (americanQuestions.containsKey(serial)) { // question is american
				questionsForTest.add(new AmericanQuestion(americanQuestions.get(serial)));
				//questionsForTest.add(americanQuestions.get(serial).clone());
				ArrayList<Integer> randomNumbers = buildRandomArr(4, americanQuestions.get(serial).getAnswer().size(),
						0);

				questionsForTest.get(i).addAnswer(new Answer("There are no correct answers", true)); // adding defult
																										// answers
				questionsForTest.get(i).addAnswer(new Answer("There are more than one correct answer", false));

				for (int m = 0; m < randomNumbers.size(); m++) {
					String answer = americanQuestions.get(serial).getAnswer().get(randomNumbers.get(m)).getAnswer();
					boolean ifCorrect = americanQuestions.get(serial).getAnswer().get(randomNumbers.get(m)).isCorrect();
					questionsForTest.get(i).addAnswer(new Answer(answer, ifCorrect));
				}
				// ((AmericanQuestion) newExam.get(i).getAnswer()).upDateDefultAnswers();
			}

			else { // question is open
				//help = findOpenQuestion(randomQuestions[i]);
				//questionsForTest.add(openQuestions.get(serial).clone());
				questionsForTest.add(new OpenQuestion(openQuestions.get(serial)));
			}
		}

		Exam newExam = new Exam(questionsForTest);
		allExams.add(newExam);
		return newExam;
	}

//********************************************************************************
	public ArrayList<Question> insertionQuestionsTest(ArrayList<Question> questions) {
		for (int i = 1; i < questions.size(); i++) { // insertion sort
			Question q = questions.get(i);
			int j = i - 1;
			while (j >= 0 && q.getQuestion().compareToIgnoreCase(questions.get(j).getQuestion()) < 0) {
				Question temp = questions.get(j);
				questions.set(j, questions.get(j + 1));
				questions.set(j + 1, temp);
				j--;
			}
		}
		return questions;
	}

//********************************************************************************
//this function randomize lengthArr numbers in range from start to end 
	private ArrayList<Integer> buildRandomArr(int lengthArr, int end, int start) {
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

		for (int i = 0; i < lengthArr; i++) {

			int rand = (int) ((Math.random() * (end)) + start);

			// boolean check = randomExist(randomNumbers, i, rand);
			while (randomNumbers.contains(rand)) {
				rand = (int) ((Math.random() * (end)) + start);
				// check = randomExist(randomNumbers, i, rand);
			}
			randomNumbers.add(rand);
		}
		return randomNumbers;
	}

//********************************************************************************
	private boolean randomExist(int[] serialNumbers, int i, int rand) {
		for (int j = 0; j < i; j++) {
			if (serialNumbers[j] == rand) {
				return true;
			}
		}
		return false;
	}

	public void copyTest(int j) {
		allExams.add(allExams.get(j - 1));

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
	public void saveExamToFile(Exam newExam) {

		Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		StringBuffer fileName = new StringBuffer("exam_");
		fileName.append(localCalendar.get(Calendar.DATE) + "_");
		fileName.append((localCalendar.get(Calendar.MONTH) + 1) + "_");
		fileName.append(localCalendar.get(Calendar.YEAR));
		fileName.append(".txt");
		File examFile = new File(fileName.toString());
		try {
			examFile.createNewFile();
			System.out.println("File created: " + examFile.getName() + "\n");
			newExam.save(examFile);

		} catch (IOException e) {
			System.out.println("An error occurred.\n");
		}

		StringBuffer solutionName = new StringBuffer("solution_");
		solutionName.append(localCalendar.get(Calendar.DATE) + "_");
		solutionName.append((localCalendar.get(Calendar.MONTH) + 1) + "_");
		solutionName.append(localCalendar.get(Calendar.YEAR));
		solutionName.append(".txt");
		File solutionFile = new File(solutionName.toString());
		try {
			solutionFile.createNewFile();
			System.out.println("File created: " + solutionFile.getName() + "\n");
			newExam.saveWithSolution(solutionFile);

		} catch (IOException e) {
			System.out.println("An error occurred.\n");
		}

	}
//********************************************************************************

	public void addAnswerToAmericanQuestion(int check, String newAnswer, boolean isCorrect) {
		AmericanQuestion question = americanQuestions.get(check);
		question.addAnswer(newAnswer, isCorrect);

	}

	public void printAllQuestions() {
		for (Integer i : americanQuestions.keySet()) {
			System.out.println(americanQuestions.get(i).toString());
		}
		for (Integer i : openQuestions.keySet()) {
			System.out.println(openQuestions.get(i).toString());
		}
	}
}
