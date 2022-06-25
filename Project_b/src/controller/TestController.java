package controller;

import java.util.Map;

import listenners.TestModelListener;

import listenners.TestViewListener;
import model.TestManager;
import view.TestCreatorView;

public class TestController implements TestModelListener, TestViewListener {

	private TestCreatorView theView;
	private TestManager testManager;
	
    public TestController(TestManager testManager, TestCreatorView theView) {
    	this.testManager = testManager;
    	this.theView = theView;
        
        testManager.registerListener(this);
        theView.registerListener(this);
    }

	@Override
	public void questionViewClicked() {
		String allQuestions = testManager.toString();
		theView.viewAllQuestions(allQuestions);
		
	}

	public void editQuestion(int serial, String newQ) {
		testManager.upDateQuestion(serial, newQ);
	}
	@Override
	public void addOpenQuestion(String question, String answer) {
		testManager.addOpenQuestion(question, answer);
		
	}

	@Override
	public void addedQuestionToModelEvent(int serial) {
		theView.addedQuestionToView(serial);
		
	}

	@Override
	public void addAmericanQuestion(String text) {
		testManager.addAmericanQuestion(text);
		
	}

	@Override
	public void addAnswerToLastAmericanQuestion(String text, String correct) {
		System.out.println(text);
		System.out.println(correct);
		testManager.addAnswerToLastQuestion(text, correct);
		
	}

	@Override
	public void emptyFieldMessage() {
		theView.emptyFieldMessage();
		
	}

	@Override
	public void editAnswer(int questionID, String newAnswer, int numOfAnswers, String ifCorrect) {
		if (testManager.findAmericanQuestion(questionID) == true) {
			boolean correct = false;
			if (ifCorrect.toLowerCase().equals("true")) {
				correct = true;
			}
			testManager.upDateAmericanAnswer(questionID, numOfAnswers, newAnswer, correct);
		} else {
			testManager.upDateOpenAnswer(questionID, newAnswer);
		}
		
	}
	public String getAllQuestions() {
		return testManager.toString();
	}

	@Override
	public void updateAnswer(int questionID) {
		if (testManager.findAmericanQuestion(questionID) == true) {
			int numOfAnswers = testManager.getAmericanQuestions().get(questionID).getAnswer().size();
			theView.updateNumOfAnswersCombo(numOfAnswers);
		} else {
			theView.updateNumOfAnswersCombo(0);
		}
		
	}
	
	public boolean deleteAnswer(int questionID, int answerNum) {
		if (testManager.findAmericanQuestion(questionID) == true) {
			testManager.deleteAmericanAnswer(questionID, answerNum-1);
			updateAnswer(questionID);
			return true;
		} 
		theView.deleteAnswerFromOpenQuestionMessage();
		return false;
		
	}

	public String createAutoExam(int numOfQuestions, int sortType) {		
		StringBuffer newExam = testManager.createAutoExam(numOfQuestions, sortType);
		return newExam.toString();
	}
	
	public void copyExamButtonClicked() {
		int numOfExams = testManager.getAllExams().size();
		StringBuffer allExams = testManager.printExams();
		theView.copyExam(numOfExams, allExams.toString());
		
	}

	@Override
	public void copyExam(int numOfExam) {
		testManager.copyTest(numOfExam);
		theView.examCopyCreatedMessage();
	}

	@Override
	public void exitButtonClicked() {
		try {
			testManager.saveQuestionStock();
		} catch (Exception e) {
			
		}
		theView.exitMessage();
		
	}

	@Override
	public void createManualTestClicked() {
		String allQuestions = testManager.toString();
		theView.createManualyTest(allQuestions);
		
	}

	public int getNumberOfAnswers(int questionID) {
		if (testManager.findAmericanQuestion(questionID) == true) {
			return testManager.getAmericanQuestions().get(questionID).getAnswer().size();
		}
		return 0;
	}

	

	
	



	
    
    
	
	
	
}