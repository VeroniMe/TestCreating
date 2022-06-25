package view;

import listenners.TestViewListener;

public interface TestCreatorView {
	
	void dataBaseView();
	void addQuestionsToDataBase();
	void editQuestion();
	void editAnswer();
	void deleteAnswer();
	void CreateAutomaticTest();
	void CreateCopyOfTest();
	void exit();
	void registerListener(TestViewListener listener);
	void viewAllQuestions(String allQuestions);
	
	void addQuestionMessage(int serial);
	void emptyFieldMessage();
	void updateNumOfAnswersCombo(int numOfAnswers);
	void addedQuestionToView(int serial);
	void deleteAnswerFromOpenQuestionMessage();
	void copyExam(int numOfExams, String string);
	void examCopyCreatedMessage();
	void exitMessage();
	void createManualyTest(String allQuestions);
	 
}
