package test_project;

public class OpenQuestion extends Question {

	private Answer answer;

//********************************************************************************
	public OpenQuestion(String question, String answer) {
		super(question);
		this.answer = new Answer(answer, true);
	}

	public OpenQuestion(String question) {
		super(question);

	}

	public OpenQuestion(OpenQuestion newQ) {
		super(newQ);
		this.answer = newQ.getAnswer();
	}

//********************************************************************************
	public String toString() {
		return super.toString() + "\n\tAnswer: " + answer + "\n";
	}
	
	public String printQuestionWithAnswer() {
		return toString();
	}
	
	public String printQuestion() {
		return super.toString();
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
		this.answer = new Answer(answer, isC);
		return true;
	}

	public Answer getCorrectAnswer() {
		return answer;

	}
	
	public OpenQuestion clone() throws CloneNotSupportedException {
		return (OpenQuestion)super.clone();
	}

}
