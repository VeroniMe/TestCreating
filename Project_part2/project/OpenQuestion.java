package project;

public class OpenQuestion extends Question {

	private Answer answer;
//********************************************************************************
	public OpenQuestion(String question, String answer) {
		super(question);
		this.answer = new Answer(answer,true);
	}	
	public OpenQuestion(String question) {
		super(question);
		
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
	public int getAnswerLength() {
		return answer.getLength();
	}
	public void upDateDefultAnswers() {
		
	}
	@Override
	public boolean addAnswer(String answer, boolean isC) {
		this.answer = new Answer(answer,isC);
		return true;
	}


}
