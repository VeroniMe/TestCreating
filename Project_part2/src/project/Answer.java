package project;

public class Answer {

	private String answer;
	private boolean isCorrect;
//********************************************************************************
	public Answer(String answer, boolean isCorrect) {
		this.answer = answer;
		this.isCorrect = isCorrect;
	}
//********************************************************************************
	public String toString() {
		return answer + " - " + isCorrect;
	}
//********************************************************************************
	public boolean isCorrect() {
		return isCorrect;
	}
	public String getAnswer() {
		return answer;
	}
//********************************************************************************
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
//********************************************************************************
 
}
