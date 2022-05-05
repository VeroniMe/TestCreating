package project;

import java.util.Objects;

public abstract class Question {

	private int serial;
	private static int counterSerial=1000;
	private String question;
//********************************************************************************
	public Question(String question) {
		this.serial = counterSerial++;
		this.question = question;
	}
//********************************************************************************
	public Question(OpenQuestion OQ) {
		this.question = OQ.getQuestion();
		this.serial = OQ.getSerial();
	}
//********************************************************************************	
	public Question(AmericanQuestion AQ) {
		this.question = AQ.getQuestion();
		this.serial = AQ.getSerial();
	}
//********************************************************************************		
	public String toString() {
		return "Question " + serial + ":" + "\n" + question;
	}
//********************************************************************************
	public int getSerial() {
		return serial;
	}
	public String getQuestion() {
		return question;
	}
//********************************************************************************
	public void setQuestion(String question) {
		this.question = question;
	}
    public void setSerial(int serial) {
		this.serial = serial;
	}
	//********************************************************************************
	public boolean addAnswer(Answer newAnswer) {
		return true;
	}
	public <t> Object getAnswer() {
		return null;
	}
	
	public abstract int getAnswerLength();
	
	public abstract boolean addAnswer(String string, boolean b);
		
	
	
	public int hashCode() {
		return Objects.hash(question);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(question, other.question);
	}
	
	
}
