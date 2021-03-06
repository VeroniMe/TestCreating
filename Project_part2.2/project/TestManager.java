package project;

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

	private ArrayList<OpenQuestion> openQuestions;
	private ArrayList<AmericanQuestion> americanQuestions;
	private ArrayList<Exam> allExams;
	private Map<Integer, Question> allQuestions;

//********************************************************************************
	public TestManager() {
		this.openQuestions = new ArrayList<>();
		this.americanQuestions = new ArrayList<>();
		this.allExams = new ArrayList<>();
		this.allQuestions = new HashMap<>();
	}

//********************************************************************************
	public ArrayList<OpenQuestion> getOpenQuestions() {
		return openQuestions;
	}

	public ArrayList<AmericanQuestion> getAmericanQuestions() {
		return americanQuestions;
	}

	public ArrayList<Exam> getAllExams() {
		return allExams;
	}

	public Map<Integer, Question> getAllQuestions() {
		return allQuestions;
	}

	// ********************************************************************************
	public void reStart() {
		// OPEN QUESTIONS
		String q1 = "Which animal is known to spend 90% of its day, sleeping?";
		String a1 = "Koala";
		OpenQuestion op1 = new OpenQuestion(q1, a1);
		openQuestions.add(op1);
		allQuestions.put(op1.getSerial(), op1);

		String q2 = "What color is the tongue of a giraffe??";
		String a2 = "Purple";
		OpenQuestion op2 = new OpenQuestion(q2, a2);
		openQuestions.add(op2);
		allQuestions.put(op2.getSerial(), op2);

		String q3 = "What is the name of the fastest land animal?";
		String a3 = "Cheetah";
		OpenQuestion op3 = new OpenQuestion(q3, a3);
		openQuestions.add(op3);
		allQuestions.put(op3.getSerial(), op3);

		// AMERICAN QUESTIONS
		AmericanQuestion q4 = new AmericanQuestion("What name is given to a female deer?");
		americanQuestions.add(new AmericanQuestion(q4));
		americanQuestions.get(0).addAnswer(new Answer("Deera", false));
		americanQuestions.get(0).addAnswer(new Answer("Debra", false));
		americanQuestions.get(0).addAnswer(new Answer("Der", false));
		americanQuestions.get(0).addAnswer(new Answer("Deer", false));
		allQuestions.put(q4.getSerial(), q4);

		AmericanQuestion q5 = new AmericanQuestion("What animal is said to have 9 lives?");
		americanQuestions.add(new AmericanQuestion(q5));
		americanQuestions.get(1).addAnswer(new Answer("Deer", false));
		americanQuestions.get(1).addAnswer(new Answer("Dog", false));
		americanQuestions.get(1).addAnswer(new Answer("Cat", true));
		americanQuestions.get(1).addAnswer(new Answer("Whale", false));
		allQuestions.put(q5.getSerial(), q5);

		AmericanQuestion q6 = new AmericanQuestion("What animal is the largest animal in the world?");
		americanQuestions.add(new AmericanQuestion(q6));
		americanQuestions.get(2).addAnswer(new Answer("African Elephant", false));
		americanQuestions.get(2).addAnswer(new Answer("White Rhinoceros", false));
		americanQuestions.get(2).addAnswer(new Answer("Blue Whale", true));
		americanQuestions.get(2).addAnswer(new Answer("Killer Whale", false));
		allQuestions.put(q6.getSerial(), q6);
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
		for (int i = 0; i < openQuestions.size(); i++)
			if (openQuestions.get(i).getQuestion().equals(question.getQuestion())) {
				return true;
			}
		return false;
	}

	public boolean isAmericanQuestionExist(Question question) {
		for (int i = 0; i < americanQuestions.size(); i++)
			if (americanQuestions.get(i).getQuestion().equals(question.getQuestion())) {
				return true;
			}
		return false;
	}

//********************************************************************************
	public int findAmericanQuestion(int id) {
		for (int i = 0; i < americanQuestions.size(); i++) {
			if (americanQuestions.get(i).getSerial() == id) {
				return i;
			}
		}
		return -1;
	}

	public int findOpenQuestion(int id) {
		for (int i = 0; i < openQuestions.size(); i++) {
			if (openQuestions.get(i).getSerial() == id) {
				return i;
			}
		}
		return -1;
	}

//********************************************************************************
	public boolean addAmericanQuestion(String question) {
		AmericanQuestion newQ = new AmericanQuestion(question);
		if (isAmericanQuestionExist(newQ) == true) {
			return false;
		}
		americanQuestions.add(newQ);
		return true;
	}

	public boolean addOpenQuestion(String question, String answer) {
		OpenQuestion newQ = new OpenQuestion(question, answer);
		if (isOpenQuestionExist(newQ) == true) {
			return false;
		}
		openQuestions.add(newQ);
		return true;
	}

	public int addQuestion(char type, String question) {
		Question q;
		if (type == 'o' || type == 'O') { // build open question
			q = new OpenQuestion(question);
			for (Map.Entry<Integer, Question> set : allQuestions.entrySet()) {
				if (set.getValue().equals(q)) {
					return -1;
				}

			}
			allQuestions.put(q.getSerial(), q);
		}

		else { // build american question
			q = new AmericanQuestion(question);
			for (Map.Entry<Integer, Question> set : allQuestions.entrySet()) {
				if (set.getValue().equals(q)) {
					return -1;
				}
			}
			allQuestions.put(q.getSerial(), q);

		}
		return q.getSerial();
	}

//********************************************************************************
	public StringBuffer printOpenQuestionsWithSerial() {
		StringBuffer s = new StringBuffer();
		s.append("There are all open questions in the system:\n");
		for (int i = 0; i < openQuestions.size(); i++) {
			s.append("Question " + openQuestions.get(i).getSerial() + ":");
			s.append(openQuestions.get(i).getQuestion());
			s.append("\n");
		}
		return s;
	}

	public StringBuffer printAmericanQuestionsWithSerial() {
		StringBuffer s = new StringBuffer();
		s.append("There are all american questions in the system:\n");
		for (int i = 0; i < americanQuestions.size(); i++) {
			s.append("Question " + americanQuestions.get(i).getSerial() + ":");
			s.append(americanQuestions.get(i).getQuestion());
			s.append("\n");
		}
		return s;
	}

//********************************************************************************
	public StringBuffer printAmericanAnswers(int serial) {
		int i = findAmericanQuestion(serial);
		StringBuffer s = new StringBuffer();
		for (int j = 0; j < americanQuestions.get(i).getAnswer().size(); j++) {
			s.append((j + 1) + ") " + americanQuestions.get(i).getAnswer().get(j).toString() + "\n");
		}
		return s;
	}

//********************************************************************************
	public void upDateOpenQuestion(int serial, String newQ) {
		int index = findOpenQuestion(serial);
		if (index != -1) {
			openQuestions.get(index).setQuestion(newQ);
		}
	}

	public void upDateAmericanQuestion(int serial, String newQ) {
		int index = findAmericanQuestion(serial);
		if (index != -1) {
			americanQuestions.get(index).setQuestion(newQ);
		}
	}

//********************************************************************************
	public void upDateOpenAnswer(int serial, String newA) {
		int index = findOpenQuestion(serial);
		if (index != -1) {
			openQuestions.get(index).setAnswer(newA);
		}
	}

	public void upDateAmericanAnswer(int serial, int num2, String newA, boolean ifCorrect) {
		int index = findAmericanQuestion(serial);
		if (index != -1) {
			americanQuestions.get(index).setAnswer(num2, newA, ifCorrect);
		}
	}

//********************************************************************************
	public void deleteAmericanAnswer(int serial, int answer) {
		int index = findAmericanQuestion(serial);
		if (index != -1) {
			americanQuestions.get(index).deleteAnswer(answer);
		}
	}

//********************************************************************************
	public Exam createExamManualy(int[] serialNumbers) {

		ArrayList<Question> questionsForTest = new ArrayList<Question>();

		int help;
		for (int i = 0; i < serialNumbers.length; i++) {

			help = findOpenQuestion(serialNumbers[i]);

			if (help != -1) // question is open
				questionsForTest.add(openQuestions.get(help));

			else { // question is american
				help = findAmericanQuestion(serialNumbers[i]);
				questionsForTest.add(new AmericanQuestion(americanQuestions.get(help))); // ???
			}
		}
		Exam newExam = new Exam(questionsForTest);
		return newExam;
	}

//********************************************************************************
	public Exam createAutoExam(int num) {
		int numA = americanQuestions.size();
		int numO = openQuestions.size();
		int[] randomQuestions = buildRandomArr(num, numO + numA, 1000);

		ArrayList<Question> questionsForTest = new ArrayList<>();

		for (int i = 0; i < randomQuestions.length; i++) {
			int help = findAmericanQuestion(randomQuestions[i]);

			if (help != -1) { // question is american
				questionsForTest.add(new AmericanQuestion(americanQuestions.get(help)));
				int[] randomNumbers = buildRandomArr(4, americanQuestions.get(help).getAnswer().size(), 0);

				questionsForTest.get(i).addAnswer(new Answer("There are no correct answers", true)); // adding defult
																										// answers
				questionsForTest.get(i).addAnswer(new Answer("There are more than one correct answer", false));

				for (int m = 0; m < randomNumbers.length; m++) {
					String a = americanQuestions.get(help).getAnswer().get(randomNumbers[m]).getAnswer();
					;
					boolean b = americanQuestions.get(help).getAnswer().get(randomNumbers[m]).isCorrect();
					questionsForTest.get(i).addAnswer(new Answer(a, b));
				}
				// ((AmericanQuestion) newExam.get(i).getAnswer()).upDateDefultAnswers();
			}

			else { // question is open
				help = findOpenQuestion(randomQuestions[i]);
				questionsForTest.add(new OpenQuestion(openQuestions.get(help)));
			}
		}

		Exam newExam = new Exam(insertionQuestionsTest(questionsForTest));
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
	public Question[] insertionQuestionsTestByLength(Question[] questions) {
		////////////////////////////////////
		return questions;
	}

//********************************************************************************
//this function randomize lengthArr numbers in range from start to end 
	private int[] buildRandomArr(int lengthArr, int end, int start) {
		int[] randomNumbers = new int[lengthArr];

		for (int i = 0; i < randomNumbers.length; i++) {
			int rand = (int) ((Math.random() * (end)) + start);
			boolean c = randomExist(randomNumbers, i, rand);
			while (c == true) {
				rand = (int) ((Math.random() * (end)) + start);
				c = randomExist(randomNumbers, i, rand);
			}
			randomNumbers[i] = rand;
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

	public void sortExam(Exam newExam, int sortType) {
		if (sortType == 1) {
			newExam.getQuestions().sort(new CompareQuestionsLexicodraphy());
		} else if (sortType == 2) {
			newExam.getQuestions().sort(new CompareQuestionsByAnswerLength());
		}
	}

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

}
