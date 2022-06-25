package listenners;

public interface TestViewListener {

	void questionViewClicked();

	void addOpenQuestion(String question, String answer);

	void addedQuestionToModelEvent(int serial);

	void addAmericanQuestion(String text);

	void addAnswerToLastAmericanQuestion(String text, String string);
	void editQuestion(int serial, String newQ);

	void editAnswer(int serial, String newAnswer, int numOfAnswer, String ifCorrect);

	void updateAnswer(int questionID);
	
	boolean deleteAnswer(int questionID, int answerNum);

	void copyExamButtonClicked();

	void copyExam(int value);

	void exitButtonClicked();

	void createManualTestClicked();

	//void questionToExamChoosen(int questionID);
}
