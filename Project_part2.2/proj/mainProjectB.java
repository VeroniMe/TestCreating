package proj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;

public class mainProjectB {
//********************************************************************************
	public static void printMenu() {
		System.out.println("--------Menu--------");
		System.out.println("Case 1: Questions and answers view");
		System.out.println("Case 2: Add new question with answers to the test");
		System.out.println("Case 3: Edit existing question");
		System.out.println("Case 4: Edit existing answer");
		System.out.println("Case 5: Delete answer of spesific question");
		System.out.println("Case 6: Create test manualy");
		System.out.println("Case 7: Create automatic test");
		System.out.println("Case 8: Creating copy of existing test");
		System.out.println("Case 9: Exit\n");
		System.out.println("Enter your choise:");
	}

//********************************************************************************
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner input = new Scanner(System.in);

		TestManager theTest = new TestManager();

		//theTest.reStart();

		File questionsFile = new File("questions_stock");
		if (questionsFile.exists()) {
			theTest.loadQuestionStock();
		}
		int choice = 0;
		System.out.println("Hello!\nAnd welcome to our tests creation system.\n"
				+ "Here you will be able to create tests for every subject "
				+ "you would like.\nLets get started(:\nFor your convenience, the Menu:\n");
		do {
			try {
				printMenu();
				choice = input.nextInt();
				switch (choice) {
//********************************************************************************
				case 1: {
					System.out.println(theTest);
					break;
				}
//********************************************************************************
				case 2: {
					System.out.println("For american question press 'a', for open question press 'o'");
					char type = input.next().charAt(0);
					while (type != 'a' && type != 'A' && type != 'O' && type != 'o') {
						System.out.println("Please try again");
						type = input.next().charAt(0);
					}
					input.nextLine();

					System.out.println("Type your question:");
					String question = input.nextLine();
					if (theTest.isQuestionExist(type, question)) { // question is exist?
						System.out.println("Question is already exist\nYou can edit it in case 3\n");
						break;
					}
					if (type == 'a' || type == 'A') { // build American question
						int serial = theTest.addAmericanQuestion(question);
						System.out.println("Serial number of your question - " + serial + "\n");
						System.out.println("You can start adding answers --> minimum 4 maximum 10!");
						int cont = 1; //
						int num = 0; // num of answers that already added to the question

						while ((cont == 1) && (num < 10)) {
							System.out.println("Type the " + (num + 1) + " answer:");
							String answer = input.next();
							System.out
									.println("This answer 'True' or 'False'?\nIf true - enter T. If false - enter F:");
							char correct = input.next().charAt(0);
							boolean isCorrect;

							while (correct != 't' && correct != 'f' && correct != 'T' && correct != 'F') { // checking
																											// wrong
																											// input
								System.out.println("Please try again");
								correct = input.next().charAt(0);
							}
							if (correct == 't' || correct == 'T') {
								isCorrect = true;
							} else {
								isCorrect = false;
							}

							theTest.addAmericanAnswer(serial, answer, isCorrect);

							if (num >= 3) {
								System.out.println("In order to add another answer press '1'");
								cont = input.nextInt();
							} else {
								cont = 1;
							}
							num++;
						}
					}

					if (type == 'o' || type == 'O') { // build open question
						System.out.println("Type your answer:");
						String answer = input.nextLine();
						int serial = theTest.addOpenQuestion(question, answer);
						System.out.println("Serial number of your question - " + serial + "\n");
					}

					break;
				}
//********************************************************************************
				case 3: {

					System.out.println("In order to edit american question press 'a', for open question press 'o'");
					char ans = input.next().charAt(0);

					while (ans != 'a' && ans != 'o' && ans != 'A' && ans != 'O') { // checking wrong input
						System.out.println("Please try again");
						ans = input.next().charAt(0);
					}

					if (ans == 'o' || ans == 'O') { // question is open
						System.out.println(theTest.printOpenQuestionsWithSerial());
						System.out.println("Enter serial of the question you would like to update:");
						int serial = input.nextInt();

						while (!theTest.findOpenQuestion(serial)) { // checking wrong input
							System.out.println("Question is not exist. Please try again");
							serial = input.nextInt();
						}

						input.nextLine();
						System.out.println("Type the new question:");
						String newQ = input.nextLine();
						theTest.upDateOpenQuestion(serial, newQ);
					}

					if (ans == 'a' || ans == 'A') { // question is american
						System.out.println(theTest.printAmericanQuestionsWithSerial());
						System.out.println("Enter serial of the question you would like to update:");
						int serial = input.nextInt();

						while (!theTest.findAmericanQuestion(serial)) { // checking wrong input
							System.out.println("Question is not exist. Please try again ");
							serial = input.nextInt();
						}

						System.out.println("Type the new question:");
						input.nextLine();
						String newQ = input.nextLine();
						theTest.upDateAmericanQuestion(serial, newQ);
					}

					break;
				}
//********************************************************************************
				case 4: {

					System.out.println("In order to edit american question press 'a', for open question press 'o'");
					char ans = input.next().charAt(0);

					while (ans != 'a' && ans != 'o' && ans != 'A' && ans != 'O') { // checking wrong input
						System.out.println("Please try again");
						ans = input.next().charAt(0);
					}

					if (ans == 'o' || ans == 'O') { // question is open
						System.out.println(theTest.printOpenQuestionsWithSerial());
						System.out.println("Enter serial of the question you would like to update:");
						int serial = input.nextInt();

						while (!theTest.findOpenQuestion(serial)) { // checking wrong input
							System.out.println("Question is not exist. Please try again");
							serial = input.nextInt();
						}

						input.nextLine();
						System.out.println("Type the new answer:");
						String newA = input.nextLine();
						theTest.upDateOpenAnswer(serial, newA);
					}

					if (ans == 'a' || ans == 'A') { // question is american
						System.out.println(theTest.printAmericanQuestionsWithSerial());
						System.out.println("Enter serial of the question you would like to update:");
						int serial = input.nextInt();

						while (!theTest.findAmericanQuestion(serial)) { // checking wrong input
							System.out.println("Question is not exist. Please try again");
							serial = input.nextInt();
						}

						System.out.println(theTest.printAmericanAnswers(serial));
						System.out.println("Enter number of answer you would like to update:");
						int index = input.nextInt();

						while (index <= 0 || index > theTest.getAmericanQuestions().get(serial).getAnswer().size()) { // checking
																														// wrong
																														// input
							System.out.println("Answer is not exist. Please try again ");
							index = input.nextInt();
						}

						input.nextLine();
						System.out.println("Type the new answer:");
						String newA = input.next();
						System.out.println("If the answer is correct after update - press 't'. else -press 'f':");
						char cor = input.next().charAt(0);
						boolean isCorrect;

						while (cor != 't' && cor != 'f' && cor != 'T' && cor != 'F') { // checking wrong input
							System.out.println("Please try again");
							cor = input.next().charAt(0);
						}

						if (cor == 't' || cor == 'T') {
							isCorrect = true;
						} else {
							isCorrect = false;
						}

						theTest.upDateAmericanAnswer(serial, index - 1, newA, isCorrect);
					}

					break;
				}
//********************************************************************************
				case 5: {
					System.out.println("You can delete answers from american question only!");
					System.out.println(theTest.printAmericanQuestionsWithSerial());
					System.out.println("Enter serial of the question you would like to update:");
					int serial = input.nextInt();

					while (!theTest.findAmericanQuestion(serial)) { // checking wrong input
						System.out.println("Question is not exist. Please try again");
						serial = input.nextInt();
					}

					if (theTest.getAmericanQuestions().get(serial).getAnswer().isEmpty()) { // num of answers=0
						System.out.println("Question don't have any answers. You return to menu.\n");
						break;
					}

					System.out.println(theTest.printAmericanAnswers(serial));
					System.out.println("Enter number of answer you would like to delete:");
					int num = input.nextInt();

					// checking wrong input
					while (num <= 0 || num > theTest.getAmericanQuestions().get(serial).getAnswer().size()) {
						System.out.println("Answer is not exist. Please try again ");
						num = input.nextInt();
					}

					theTest.deleteAmericanAnswer(serial, num - 1);

					break;
				}
//********************************************************************************
				case 6: {
					System.out.println("How many questions do you want in the test?");
					int num = input.nextInt();
					int m = 1;
					int help = theTest.getOpenQuestions().size() + theTest.getAmericanQuestions().size();
					while (num < 0 || num > help) { // checking wrong input
						if (m == 1) {
							System.out.println("There are " + help + " questions in the system");
							m++;
						}
						System.out.println("Please try again");
						num = input.nextInt();
					}

					int[] serialNumbers = new int[num];
					System.out.println(theTest.printOpenQuestionsWithSerial());
					System.out.println(theTest.printAmericanQuestionsWithSerial());

					for (int i = 0; i < num; i++) {
						System.out.println("Choose question by its serial num:");
						int serial = input.nextInt();
						// checking wrong input
						while ((!theTest.findOpenQuestion(serial)) && (!theTest.findAmericanQuestion(serial))) {
							System.out.println("Question is not exist. Please try again");
							serial = input.nextInt();
						}
						serialNumbers[i] = serial;
					}

					Exam newExam = theTest.createExamManualy(serialNumbers);
					for (int n = 0; n < serialNumbers.length; n++) { // adding answers

						int serial = serialNumbers[n];
						if (theTest.getAmericanQuestions().get(serial) instanceof AmericanQuestion) {
							System.out.println(theTest.getAmericanQuestions().get(serial).toString());
							System.out.println("\nChoose answers by its num. In order to stop press 0:");
							System.out.println("Your choise:");
							int answer = input.nextInt();

							while (answer != 0) {
								if (answer < 0
										|| answer > (theTest.getAmericanQuestions().get(serial).getAnswer().size())) {
									System.out.println("Answer is not exist. Please try again");
									answer = input.nextInt();
								} else {
									newExam.getQuestions().get(n).addAnswer(
											theTest.getAmericanQuestions().get(serial).getAnswer().get(answer - 1));
									System.out.println("Your choise:");
									answer = input.nextInt();
								}
							}
							((AmericanQuestion) newExam.getQuestions().get(n)).upDateDefultAnswers();

						}
					}

					System.out.println("Choose sorting option:\n1 - by lexicography order\n2 - by answer length");
					int sortType = input.nextInt();
					theTest.sortExam(newExam, sortType);
					System.out.println(newExam);
					System.out.println(theTest.saveExamToFile(newExam));
					theTest.getAllExams().add(newExam);

					break;
				}
//********************************************************************************
				case 7: {
					System.out.println("How many questions do you want in the test?");
					int num = input.nextInt();
					int allQuestions = theTest.getOpenQuestions().size() + theTest.getAmericanQuestions().size();
					
					while (num < 0 || num > allQuestions) { // checking wrong input

						System.out.println("There are " + allQuestions + " questions in the system");

						System.out.println("Please try again");
						num = input.nextInt();
					}

					System.out.println("Choose sorting option:\n1 - by lexicography order\n2 - by answer length");
					int sortType = input.nextInt();
					System.out.println(theTest.createAutoExam(num, sortType));
					break;
				}
//********************************************************************************
				case 8: {
					if (theTest.getAllExams().size() == 0) {
						System.out.println("There are no tests in the system. You return to menu.\n");
						break;
					}

					System.out.println(theTest.printExams());
					System.out.println("Which test you would like to copy?");
					int numOfTest = input.nextInt();

					while (numOfTest <= 0 || numOfTest > theTest.getAllExams().size()) { // checking wrong input
						System.out.println("please try again");
						numOfTest = input.nextInt();
					}

					theTest.copyTest(numOfTest);
					System.out.println("Test copied successfully\n");

					break;
				}
//********************************************************************************
				case 9: {
					theTest.saveQuestionStock();
					System.out.println("Question stock has saved succefully!");
					System.out.println("Goodbye!");
					input.close();
					break;
				}
//********************************************************************************
				default:
					System.out.println("Case " + choice + " doesn't exist. Please enter another choice\n");
					break;
				}
//********************************************************************************
			} // try
			catch (InputMismatchException e) {
				System.out.println("You entered invalid option, you return to menu.\n");
				input.nextLine();
			} catch (IndexOutOfBoundsException e) {
				System.out.println("You entered invalid number, you return to menu.\n");
			} catch (NullPointerException e) {
				System.out.println("General Error, you return to menu.\n");
			} catch (NegativeArraySizeException e) {
				System.out.println("You need to enter a positive number, you return to menu.\n");
			}
		} while (choice != 9);
	}
}
