package project;

import java.util.Objects;

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
	
	@Override
	public int hashCode() {
		return Objects.hash(answer, isCorrect);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		return Objects.equals(answer, other.answer) && isCorrect == other.isCorrect;
	}
	public String toStringWithoutAnswer() {
		return answer;
	}
	
//********************************************************************************
	public boolean isCorrect() {
		return isCorrect;
	}
	public String getAnswer() {
		return answer;
	}
	public int getLength() {
		return answer.length();
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
