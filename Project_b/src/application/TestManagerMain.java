package application;

import java.io.File;

import controller.TestController;

import javafx.application.Application;
import javafx.stage.Stage;
import model.TestManager;
import view.TestCreatorView;
import view.TestJavaFX;

public class TestManagerMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		TestCreatorView theView = new TestJavaFX(stage);
		TestManager theTest = new TestManager();

		File questionsFile = new File("questions_stock");
		if (questionsFile.exists()) {
			theTest.loadQuestionStock();
		} else {
			theTest.reStart();
		}
		TestController controller = new TestController(theTest, theView);

	}

}
