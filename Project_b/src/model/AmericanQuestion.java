package model;

import java.util.Iterator;


public class AmericanQuestion extends Question {

	private MySet<Answer> answers;
	private final int MAX_NUM_ANSWERS = 10;
	private final int MIN_NUM_ANSWERS = 4;

//********************************************************************************
	public AmericanQuestion(String question) {
		super(question);
		this.answers = new MySet<>();
	}

	public AmericanQuestion(AmericanQuestion newQ) {
		super(newQ);
		this.answers = new MySet<>();
	}
//********************************************************************************
	public String toString() {
		StringBuffer s = new StringBuffer(super.toString());
		s.append("\n");
		for (int i = 0; i < answers.size(); i++) {
			s.append("\t" + (i + 1) + ") " + answers.get(i));
			s.append("\n");
		}
		return s.toString();
	}

	public String printQuestionWithAnswer() {
		return toString();
	}

	public String printQuestion() {
		StringBuffer s = new StringBuffer(super.toString());
		s.append("\n");
		for (int i = 0; i < answers.size(); i++) {
			s.append("\t" + (i + 1) + ") " + answers.get(i).toStringWithoutAnswer());
			s.append("\n");
		}
		return s.toString();
	}

	public String printAnswer() {
		return null;
	}

	public String printQuestionWithSerial() {
		return super.toString();
	}
//********************************************************************************
	public String getQuestion() {
		return super.getQuestion();
	}

	public MySet<Answer> getAnswer() {
		return answers;
	}
//********************************************************************************
	public void setAnswer(int serial, String newA, boolean isCorrect) {
		answers.get(serial).setAnswer(newA);
		answers.get(serial).setCorrect(isCorrect);
	}
//********************************************************************************
	public boolean addAnswer(Answer newAnswer) {
 		if (answers.size() != MAX_NUM_ANSWERS) {
			answers.add(newAnswer);
			System.out.println("addAnswer" + newAnswer.toString());
			return true;
		}
		return false;
	}
//********************************************************************************
	public boolean addAnswer(String a, boolean isC) {
		if (answers.size() != MAX_NUM_ANSWERS) {
			answers.add(new Answer(a, isC));
			return true;
		}
		return false;
	}

//********************************************************************************
	public void deleteAnswer(int num) {
		answers.remove(num);
	}
//********************************************************************************
//This function check how many correct answers exist in American question and
// according this update default answers

	public void upDateDefultAnswers() {
		int correctCounter = 0; // count how many correct answers for question
		for (int i = 2; i < answers.size(); i++) {
			if (answers.get(i).isCorrect() == true) {
				correctCounter++;
			}
		}
		if (correctCounter == 0) {
			answers.get(0).setCorrect(true);
			answers.get(1).setCorrect(false);
		}
		if (correctCounter > 0) {
			answers.get(0).setCorrect(false);
		}
		if (correctCounter > 1) {
			answers.get(1).setCorrect(true);
			for (int i = 2; i < answers.size(); i++) {
				answers.get(i).setCorrect(false);
			}
		}
	}
//********************************************************************************
	public int getAnswerLength() {
		int length = 0;
		Iterator<Answer> itr = answers.iterator();
		while (itr.hasNext()) {
			length = length + itr.next().getLength();
		}
		return length;

	}
//********************************************************************************
}
