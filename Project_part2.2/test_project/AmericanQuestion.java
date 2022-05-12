package test_project;




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

	@Override
	public String printAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printQuestionWithSerial() {
		// TODO Auto-generated method stub
		return null;
	}

//********************************************************************************
	public String getQuestion() {
		return super.getQuestion();
	}

	public MySet<Answer> getAnswer() {
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

	public void setAnswers(MySet<Answer> answers) {
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
	public boolean addAnswer(String a, boolean isC) {//////////////// *********change to string and boolean
		if (answers.size() != MAX_NUM_ANSWERS) {
			answers.add(new Answer(a, isC));
			return true;
		}
		return false;
	}

//********************************************************************************
	public void deleteAnswer(int num) {

		answers.remove(answers.size() - 1);
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

	public Answer getCorrectAnswer() {
		Answer correctAns = null;
		for (int i = 0; i < answers.size(); i++) { // ?????????????????????
			if (answers.get(i).isCorrect() == true) {
				correctAns = answers.get(i);
			}
		}
		return correctAns;
	}
	
	public AmericanQuestion clone() throws CloneNotSupportedException {
		return (AmericanQuestion)super.clone();
	}

}
