package project;

public class OpenQuestion extends Question {

	private Answer answer;
//********************************************************************************
	public OpenQuestion(String question, String answer) {
		super(question);
		this.answer = new Answer(answer,true);
	}	
	
	public OpenQuestion (OpenQuestion newQ) {
		super(newQ);
		this.answer = newQ.getAnswer();
	}
//********************************************************************************
	public String toString() {
		return super.toString() + "\n\tAnswer: " + answer + "\n";
	}
//********************************************************************************
	public void setAnswer(String answer) {
		this.answer.setAnswer(answer);
	}
//********************************************************************************
	public String getQuestion() {
		return super.getQuestion();
	}
//********************************************************************************
	public Answer getAnswer() {
		return answer;
	}
	public void upDateDefultAnswers() {
		
			}
	
}
