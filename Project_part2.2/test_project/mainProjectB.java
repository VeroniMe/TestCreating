package test_project;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;

public class mainProjectB {
//********************************************************************************
	public static void printMenu() {
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
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		// Changes that need to be made in order to Support many subjects - go to ReadMe
		// file
		TestManager theTest = new TestManager();
		theTest.reStart();

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
					theTest.printAllQuestions();
					break;
				}
//********************************************************************************
				case 2: {
					System.out.println("For american question press 'a', for open question press 'o'");
					char ans = input.next().charAt(0);
					while (ans != 'a' && ans != 'A' && ans != 'O' && ans != 'o') {
						System.out.println("Please try again");
						ans = input.next().charAt(0);

					}
					input.nextLine();
					System.out.println("Type your question:");
					String question = input.nextLine();

					int check = -1; // to check if question is already exists
					if (ans == 'a' || ans == 'A') { // build American question
						// input.nextLine();

						check = theTest.addAmericanQuestion(question);
						if (check != -1) {

							System.out.println("You can start adding answers --> minimum 4 maximum 10!");
							int cont = 1; //
							int num = 0; // num of answers that already added to the question
							while ((cont == 1) && (num < 10)) {

								System.out.println("Type the " + (num + 1) + " answer:");
								String newAnswer = input.next();
								System.out.println(
										"This answer 'True' or 'False'?\nIf true - enter T. If false - enter F:");
								char cor = input.next().charAt(0);
								boolean isCorrect;
								while (cor != 't' && cor != 'f' && cor != 'T' && cor != 'F') {
									System.out.println("Please try again");
									cor = input.next().charAt(0);
								}
								if (cor == 't' || cor == 'T') {
									isCorrect = true;
								} else {
									isCorrect = false;
								}
								theTest.addAnswerToAmericanQuestion(check, newAnswer, isCorrect);

								if (num >= 3) {
									System.out.println("In order to add another answer press '1'");
									cont = input.nextInt();
								} else {
									cont = 1;
								}

								num++;

							}
						}
					}
					if (ans == 'o' || ans == 'O') { // build open question					
						//input.nextLine();
						System.out.println("Type your answer:");
						String answer = input.nextLine();
						check = theTest.addOpenQuestion(question, answer);
					}

					if (check != -1) {
						System.out.println("Question is succesfully added!\n");
					} else {
						System.out.println("Question is already exist\nYou can edit it in case 3\n");
					}
					break;
				}
//********************************************************************************
				case 3: {

					System.out.println("In order to edit american question press 'a', for open question press 'o'");
					char ans = input.next().charAt(0);
					while (ans != 'a' && ans != 'o' && ans != 'A' && ans != 'O') {
						System.out.println("Please try again");
						ans = input.next().charAt(0);
					}
					if (ans == 'o' || ans == 'O') {
						System.out.println(theTest.printOpenQuestionsWithSerial());
						System.out.println("Enter serial of the question you would like to update:");
						int serial = input.nextInt();
						
						while (!theTest.findOpenQuestion(serial)) {
							System.out.println("Question is not exist. Please try again");
							serial = input.nextInt();
						}
						System.out.println("Type the new question:");
						input.nextLine();
						String newQ = input.nextLine();
						theTest.upDateOpenQuestion(serial, newQ);
					}
					if (ans == 'a' || ans == 'A') {
						System.out.println(theTest.printAmericanQuestionsWithSerial());
						System.out.println("Enter serial of the question you would like to update:");
						int serial = input.nextInt();
						while (!theTest.findAmericanQuestion(serial)) {
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
					char ans1 = input.next().charAt(0);
					while (ans1 != 'a' && ans1 != 'o' && ans1 != 'A' && ans1 != 'O') {
						System.out.println("Please try again");
						ans1 = input.next().charAt(0);
					}
					if (ans1 == 'o' || ans1 == 'O') {
						System.out.println(theTest.printOpenQuestionsWithSerial());
						System.out.println("Enter serial of the question you would like to update:");
						int serial = input.nextInt();
						while (!theTest.findOpenQuestion(serial)) {
							System.out.println("Question is not exist. Please try again");
							serial = input.nextInt();
						}
						input.nextLine();
						System.out.println("Type the new answer:");
						String newA = input.nextLine();
						theTest.upDateOpenAnswer(serial, newA);
					}
					if (ans1 == 'a' || ans1 == 'A') {
						System.out.println(theTest.printAmericanQuestionsWithSerial());
						System.out.println("Enter serial of the question you would like to update:");
						int serial = input.nextInt();
						while (!theTest.findAmericanQuestion(serial)) {
							System.out.println("Question is not exist. Please try again");
							serial = input.nextInt();
						}
						System.out.println(theTest.printAmericanAnswers(serial));
						System.out.println("Enter number of answer you would like to update:");
						int index = input.nextInt();
						while (index <= 0 || index > theTest.getAmericanQuestions()
								.get(theTest.findAmericanQuestion(serial)).getAnswer().size()) {
							System.out.println("Answer is not exist. Please try again ");
							index = input.nextInt();
						}
						input.nextLine();
						System.out.println("Type the new answer:");
						String newA = input.next();
						System.out.println("If the answer is correct after update - press 't'. else -press 'f':");
						char cor = input.next().charAt(0);
						boolean isCorrect;
						while (cor != 't' && cor != 'f' && cor != 'T' && cor != 'F') {
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
					System.out.println("You can delete answers only from american question!");
					System.out.println(theTest.printAmericanQuestionsWithSerial());
					System.out.println("Enter serial of the question you would like to update:");
					int serial = input.nextInt();

					while (!theTest.findAmericanQuestion(serial)) {
						System.out.println("Question is not exist. Please try again");
						serial = input.nextInt();
					}

					if (theTest.getAmericanQuestions().isEmpty()) {
						System.out.println("Question don't have any answers. You return to menu.\n");
						break;
					}

					System.out.println(theTest.printAmericanQuestionsWithSerial());
					System.out.println("Enter number of answer you would like to delete:");
					int num2 = input.nextInt();

					while (num2 <= 0 || num2 > theTest.getAmericanQuestions().get(theTest.findAmericanQuestion(serial))
							.getAnswer().size()) {
						System.out.println("Answer is not exist. Please try again ");
						num2 = input.nextInt();
					}

					theTest.deleteAmericanAnswer(serial, num2 - 1);

					break;
				}
//********************************************************************************
				case 6: {
					System.out.println("How many questions do you want in the test?");
					int num = input.nextInt();
					int m = 1;
					int allQuestNum = theTest.getOpenQuestions().size() + theTest.getAmericanQuestions().size();
					while (num < 0 || num > allQuestNum) { // for checking if input is not greater than num of questions
															// in
						// system
						if (m == 1) {
							System.out.println("There are " + allQuestNum + " questions in the system");
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
						while ((!theTest.findOpenQuestion(serial))
								&& (!theTest.findAmericanQuestion(serial))) {
							System.out.println("Question is not exist. Please try again");
							serial = input.nextInt();
						}
						serialNumbers[i] = serial;
					}

					Exam newExam = theTest.createExamManualy(serialNumbers);

					for (int n = 0; n < serialNumbers.length; n++) {
						int index = serialNumbers[n];
						
						if( theTest.getAmericanQuestions().get(index) instanceof AmericanQuestion) {
							newExam.getQuestions().get(n).addAnswer("There are no correct answers", true);
							newExam.getQuestions().get(n).addAnswer("There are more than one correct answer", false);
							//System.out.println(theTest.getAmericanQuestions().get(index).getQuestion());
							//System.out.println(theTest.printAmericanAnswers(index));
							System.out.println(theTest.getAmericanQuestions().get(index).toString());
							System.out.println("\nChoose answers by its num. In order to stop press 0:");
							System.out.println("Your choise:");
							int answer = input.nextInt();
							while (answer != 0) {
								if (answer < 0 || answer > (theTest.getAmericanQuestions().get(index).getAnswer().size())) {
									System.out.println("Answer is not exist. Please try again");
									answer = input.nextInt();
								} else {
									newExam.getQuestions().get(n).addAnswer(
											theTest.getAmericanQuestions().get(index).getAnswer().get(answer - 1));
									System.out.println("Your choise:");
									answer = input.nextInt();
								}

							}
							((AmericanQuestion) newExam.getQuestions().get(n)).upDateDefultAnswers();
							
						} 

//						boolean  = theTest.findAmericanQuestion(serialNumbers[n]);
//						if (allQuestNum != -1) { // question is american
//							// adding default answers
//							newExam.getQuestions().get(n).addAnswer("There are no correct answers", true);
//							newExam.getQuestions().get(n).addAnswer("There are more than one correct answer", false);
//							System.out.println(theTest.getAmericanQuestions().get(allQuestNum).getQuestion());
//							System.out.println(theTest.printAmericanAnswers(serialNumbers[n]));
//							System.out.println("\nChoose answers by its num. In order to stop press 0:");
//							System.out.println("Your choise:");
//							int answer = input.nextInt();
//							while (answer != 0) {
//								if (answer < 0 || answer > (theTest.getAmericanQuestions().get(allQuestNum).getAnswer()
//										.size())) {
//									System.out.println("Answer is not exist. Please try again");
//									answer = input.nextInt();
//								} else {
//									newExam.getQuestions().get(n).addAnswer(theTest.getAmericanQuestions()
//											.get(allQuestNum).getAnswer().get(answer - 1));
//									System.out.println("Your choise:");
//									answer = input.nextInt();
//								}
//
//							}
//							((AmericanQuestion) newExam.getQuestions().get(n)).upDateDefultAnswers();
//						}
					}

					System.out.println("Choose sorting option:\n1 - for sort in lexicography order\n"
							+ "2 - for sort by answer length");
					int sortType = input.nextInt();
					theTest.sortExam(newExam, sortType);
					theTest.saveExamToFile(newExam);
					System.out.println(newExam.toString());
					theTest.getAllExams().add(newExam);
					System.out.println(newExam);

					break;
				}
//********************************************************************************
				case 7: {
					System.out.println("How many questions do you want in the test?");
					int num = input.nextInt();
					int m = 1;
					int help = theTest.getOpenQuestions().size() + theTest.getAmericanQuestions().size();
					while (num < 0 || num > help) {
						if (m == 1) {
							System.out.println("There are " + help + " questions in the system");
							m++;
						}
						System.out.println("Please try again");
						num = input.nextInt();
					}
					Exam newExam = theTest.createAutoExam(num);
					System.out.println("Choose sorting option:\n1 - for sort in lexicography order\n"
							+ "2 - for sort by answer length");
					int sortType = input.nextInt();
					theTest.sortExam(newExam, sortType);
					System.out.println(newExam);
					theTest.saveExamToFile(newExam);
					break;
				}
//********************************************************************************
				case 8: {
					for (int i = 0; i < theTest.getAllExams().size(); i++) {
						System.out.println("   Exam number " + (i + 1) + "\n");
						System.out.println(theTest.getAllExams().get(i));
					}
					System.out.println("Which test you would like to copy?");
					int j = input.nextInt();
					while (j <= 0 || j > theTest.getAllExams().size()) {
						System.out.println("please try again");
						j = input.nextInt();
					}
					theTest.copyTest(j);
					System.out.println("Test copied successfully\n");

					break;
				}
//********************************************************************************
				case 9: {
					System.out.println("Goodbye!");
					input.close();
					break;
				}
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
			} catch (CloneNotSupportedException e) {
					System.out.println("Problem in Exam Copping. Try again\n");
			} catch (NegativeArraySizeException e) {
				System.out.println("You need to enter a positive number, you return to menu.\n");
			}
		} while (choice != 9);
	}
}
