package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import controller.TestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import listenners.TestViewListener;

public class TestJavaFX implements TestCreatorView {

	private Vector<TestViewListener> listeners = new Vector<TestViewListener>();
	private ComboBox<Integer> cmbAllQuestions = new ComboBox<Integer>();
	ComboBox<Integer> cmbNumOfAnswers = new ComboBox<Integer>();
	// private Label lblNumfPassengers = new Label("The bus has 0 passengers");
	private BorderPane pane = new BorderPane();
	private Alert systemAlert = new Alert(AlertType.NONE);

	public TestJavaFX(Stage stage) {
		try {
			cmbAllQuestions.getItems().addAll(1000, 1001, 1002, 1003, 1004, 1005);
			stage.setTitle("Tests Creator");
			Button viewBtn = new Button("Questions View");
			viewBtn.setPrefWidth(200);
			viewBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					for (TestViewListener l : listeners) {
						l.questionViewClicked();
					}
				}
			});

			Button addBtn = new Button("Add Question");
			addBtn.setPrefWidth(200);
			addBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {

					VBox questionFields = new VBox();
					HBox questionsButtons = new HBox();
					Button americanBtn = new Button("American Question");
					americanBtn.setPrefWidth(200);
					americanBtn.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							VBox americanFields = new VBox();
							pane.setCenter(americanFields);

							Label questionLabel = new Label("Enter question:");
							TextField questionText = new TextField();

							Label answerLabel = new Label("Choose number of answers:");
							answerLabel.setVisible(false);

							VBox answers = new VBox();
							answers.setVisible(false);
							answers.setSpacing(10);

							HBox answer1 = new HBox();
							answer1.setAlignment(Pos.TOP_LEFT);
							answer1.setSpacing(20);
							Label ansLbl1 = new Label("Add answer: ");
							TextField ans1 = new TextField();
							ToggleGroup correct1 = new ToggleGroup();
							RadioButton right1 = new RadioButton("True");
							RadioButton wrong1 = new RadioButton("False");
							right1.setToggleGroup(correct1);
							wrong1.setToggleGroup(correct1);
							answer1.getChildren().addAll(ansLbl1, ans1, right1, wrong1);
							// answer1.setVisible(false);

							HBox answer2 = new HBox();
							answer2.setAlignment(Pos.CENTER_LEFT);
							answer2.setSpacing(20);
							Label ansLbl2 = new Label("Add answer: ");
							TextField ans2 = new TextField();
							ToggleGroup correct2 = new ToggleGroup();
							RadioButton right2 = new RadioButton("True");
							RadioButton wrong2 = new RadioButton("False");
							right2.setToggleGroup(correct2);
							wrong2.setToggleGroup(correct2);
							answer2.getChildren().addAll(ansLbl2, ans2, right2, wrong2);
							// answer2.setVisible(false);

							HBox answer3 = new HBox();
							answer3.setAlignment(Pos.CENTER_LEFT);
							answer3.setSpacing(20);
							Label ansLbl3 = new Label("Add answer: ");
							TextField ans3 = new TextField();
							ToggleGroup correct3 = new ToggleGroup();
							RadioButton right3 = new RadioButton("True");
							RadioButton wrong3 = new RadioButton("False");
							right3.setToggleGroup(correct3);
							wrong3.setToggleGroup(correct3);
							answer3.getChildren().addAll(ansLbl3, ans3, right3, wrong3);
							// answer3.setVisible(false);

							HBox answer4 = new HBox();
							answer4.setAlignment(Pos.CENTER_LEFT);
							answer4.setSpacing(20);
							Label ansLbl4 = new Label("Add answer: ");
							TextField ans4 = new TextField();
							ToggleGroup correct4 = new ToggleGroup();
							RadioButton right4 = new RadioButton("True");
							RadioButton wrong4 = new RadioButton("False");
							right4.setToggleGroup(correct4);
							wrong4.setToggleGroup(correct4);
							answer4.getChildren().addAll(ansLbl4, ans4, right4, wrong4);
							// answer4.setVisible(false);

							HBox answer5 = new HBox();
							answer5.setAlignment(Pos.CENTER_LEFT);
							answer5.setSpacing(20);
							Label ansLbl5 = new Label("Add answer: ");
							TextField ans5 = new TextField();
							ToggleGroup correct5 = new ToggleGroup();
							RadioButton right5 = new RadioButton("True");
							RadioButton wrong5 = new RadioButton("False");
							right5.setToggleGroup(correct5);
							wrong5.setToggleGroup(correct5);
							answer5.getChildren().addAll(ansLbl5, ans5, right5, wrong5);
							answer5.setVisible(false);

							HBox answer6 = new HBox();
							answer6.setAlignment(Pos.CENTER_LEFT);
							answer6.setSpacing(20);
							Label ansLbl6 = new Label("Add answer: ");
							TextField ans6 = new TextField();
							ToggleGroup correct6 = new ToggleGroup();
							RadioButton right6 = new RadioButton("True");
							RadioButton wrong6 = new RadioButton("False");
							right6.setToggleGroup(correct6);
							wrong6.setToggleGroup(correct6);
							answer6.getChildren().addAll(ansLbl6, ans6, right6, wrong6);
							answer6.setVisible(false);

							HBox answer7 = new HBox();
							answer7.setAlignment(Pos.TOP_LEFT);
							answer7.setSpacing(20);
							Label ansLbl7 = new Label("Add answer: ");
							TextField ans7 = new TextField();
							ToggleGroup correct7 = new ToggleGroup();
							RadioButton right7 = new RadioButton("True");
							RadioButton wrong7 = new RadioButton("False");
							right7.setToggleGroup(correct7);
							wrong7.setToggleGroup(correct7);
							answer7.getChildren().addAll(ansLbl7, ans7, right7, wrong7);
							answer7.setVisible(false);

							HBox answer8 = new HBox();
							answer8.setAlignment(Pos.TOP_LEFT);
							answer8.setSpacing(20);
							Label ansLbl8 = new Label("Add answer: ");
							TextField ans8 = new TextField();
							ToggleGroup correct8 = new ToggleGroup();
							RadioButton right8 = new RadioButton("True");
							RadioButton wrong8 = new RadioButton("False");
							right8.setToggleGroup(correct8);
							wrong8.setToggleGroup(correct8);
							answer8.getChildren().addAll(ansLbl8, ans8, right8, wrong8);
							answer8.setVisible(false);
							answers.getChildren().addAll(answer1, answer2, answer3, answer4, answer5, answer6, answer7,
									answer8);

							HBox radioButtons = new HBox();
							radioButtons.setVisible(false);
							ToggleGroup answerNumbers = new ToggleGroup();
							RadioButton fourAnswers = new RadioButton("4");
							fourAnswers.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent arg0) {
									answer5.setVisible(false);
									answer6.setVisible(false);
									answer7.setVisible(false);
									answer8.setVisible(false);

								}
							});

							RadioButton fiveAnswers = new RadioButton("5");
							fiveAnswers.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent arg0) {
									answer5.setVisible(true);
									answer6.setVisible(false);
									answer7.setVisible(false);
									answer8.setVisible(false);
								}
							});

							RadioButton sixAnswers = new RadioButton("6");
							sixAnswers.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent arg0) {
									answer5.setVisible(true);
									answer6.setVisible(true);
									answer7.setVisible(false);
									answer8.setVisible(false);
								}
							});

							RadioButton sevenAnswers = new RadioButton("7");
							sevenAnswers.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent arg0) {
									answer5.setVisible(true);
									answer6.setVisible(true);
									answer7.setVisible(true);
									answer8.setVisible(false);
								}
							});

							RadioButton eightAnswers = new RadioButton("8");
							eightAnswers.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent arg0) {
									answer5.setVisible(true);
									answer6.setVisible(true);
									answer7.setVisible(true);
									answer8.setVisible(true);
								}
							});

							fourAnswers.setToggleGroup(answerNumbers);
							fiveAnswers.setToggleGroup(answerNumbers);
							sixAnswers.setToggleGroup(answerNumbers);
							sevenAnswers.setToggleGroup(answerNumbers);
							eightAnswers.setToggleGroup(answerNumbers);
							radioButtons.getChildren().addAll(fourAnswers, fiveAnswers, sixAnswers, sevenAnswers,
									eightAnswers);
							radioButtons.setSpacing(20);

							Button saveAmericanQuestion = new Button("Save");
							saveAmericanQuestion.setVisible(false);
							saveAmericanQuestion.setPrefSize(90, 30);
							saveAmericanQuestion.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent event) {

									for (TestViewListener l : listeners) {
										try {
											String answersNum = ((RadioButton) answerNumbers.getSelectedToggle())
													.getText();
											System.out.println(answersNum);
											Integer num = Integer.parseInt(answersNum);
											System.out.println(num);
											// System.out.println(ans1.getText() + ((RadioButton)
											// correct1.getSelectedToggle()).getText());

											l.addAnswerToLastAmericanQuestion(ans1.getText(),
													((RadioButton) correct1.getSelectedToggle()).getText());
											l.addAnswerToLastAmericanQuestion(ans2.getText(),
													((RadioButton) correct2.getSelectedToggle()).getText());
											l.addAnswerToLastAmericanQuestion(ans3.getText(),
													((RadioButton) correct3.getSelectedToggle()).getText());
											l.addAnswerToLastAmericanQuestion(ans4.getText(),
													((RadioButton) correct4.getSelectedToggle()).getText());

											switch (num) {
											case 8:
												l.addAnswerToLastAmericanQuestion(ans5.getText(),
														((RadioButton) correct5.getSelectedToggle()).getText());
												l.addAnswerToLastAmericanQuestion(ans6.getText(),
														((RadioButton) correct6.getSelectedToggle()).getText());
												l.addAnswerToLastAmericanQuestion(ans7.getText(),
														((RadioButton) correct7.getSelectedToggle()).getText());
												l.addAnswerToLastAmericanQuestion(ans8.getText(),
														((RadioButton) correct8.getSelectedToggle()).getText());
												break;

											case 7:
												l.addAnswerToLastAmericanQuestion(ans5.getText(),
														((RadioButton) correct5.getSelectedToggle()).getText());
												l.addAnswerToLastAmericanQuestion(ans6.getText(),
														((RadioButton) correct6.getSelectedToggle()).getText());
												l.addAnswerToLastAmericanQuestion(ans7.getText(),
														((RadioButton) correct7.getSelectedToggle()).getText());
												break;

											case 6:
												l.addAnswerToLastAmericanQuestion(ans5.getText(),
														((RadioButton) correct5.getSelectedToggle()).getText());
												l.addAnswerToLastAmericanQuestion(ans6.getText(),
														((RadioButton) correct6.getSelectedToggle()).getText());
												break;

											case 5:
												l.addAnswerToLastAmericanQuestion(ans5.getText(),
														((RadioButton) correct5.getSelectedToggle()).getText());
												break;
											default:
											}
										} catch (NullPointerException e) {
											emptyFieldMessage();
										}

									}

								}

							});

							Button sendAmericanQuestion = new Button("Send");
							sendAmericanQuestion.setPrefSize(90, 30);
							sendAmericanQuestion.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent event) {

									for (TestViewListener l : listeners) {
										l.addAmericanQuestion(questionText.getText());
										// questionText.setText("");
									}
									if (!systemAlert.isShowing()) {
										answerLabel.setVisible(true);
										radioButtons.setVisible(true);
										answers.setVisible(true);
										questionText.setMouseTransparent(true);
										saveAmericanQuestion.setVisible(true);
										sendAmericanQuestion.setVisible(false);

									}
								}
							});

							// answers.setAlignment(Pos.CENTER);

							// answers.setPadding(new Insets(5));

							VBox americanQuestionFields = new VBox();
							americanQuestionFields.setAlignment(Pos.TOP_LEFT);
							americanQuestionFields.setSpacing(20);
							americanQuestionFields.setPadding(new Insets(20));
							americanQuestionFields.getChildren().addAll(questionLabel, questionText,
									sendAmericanQuestion, answerLabel, radioButtons, answers, saveAmericanQuestion);
							questionFields.getChildren().setAll(americanQuestionFields);
							pane.setCenter(questionFields);

						}

					});

					Button openBtn = new Button("Open Question");
					openBtn.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							Label questionLabel = new Label("Enter question:");
							TextField questionText = new TextField();

							Label answerLabel = new Label("Enter answer:");
							TextField answerText = new TextField();

							Button saveOpenQuestion = new Button("Save");
							saveOpenQuestion.setPrefSize(70, 80);
							saveOpenQuestion.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									for (TestViewListener l : listeners) {
										l.addOpenQuestion(questionText.getText(), answerText.getText());
										answerText.setText("");
										questionText.setText("");
									}

								}
							});

							VBox openQuestionFields = new VBox();
							openQuestionFields.getChildren().addAll(questionLabel, questionText, answerLabel,
									answerText, saveOpenQuestion);
							openQuestionFields.setAlignment(Pos.BASELINE_LEFT);
							openQuestionFields.setSpacing(20);
							openQuestionFields.setPadding(new Insets(30));
							questionFields.getChildren().setAll(openQuestionFields);
							pane.setCenter(questionFields);

						}

					});
					openBtn.setPrefWidth(200);
					questionsButtons.getChildren().addAll(americanBtn, openBtn);
					questionsButtons.setAlignment(Pos.TOP_CENTER);
					questionsButtons.setSpacing(20);
					questionsButtons.setPadding(new Insets(30));
					questionFields.getChildren().addAll(questionsButtons);
					pane.setCenter(questionFields);

				}

			});
//*******************************************************************************
			Button editQuestBtn = new Button("Edit Question");
			editQuestBtn.setPrefWidth(200);
			editQuestBtn.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					VBox editQuestFields = new VBox();
					editQuestFields.setAlignment(Pos.TOP_LEFT);
					editQuestFields.setSpacing(20);
					editQuestFields.setPadding(new Insets(20));
					Label questionLabel = new Label("All questions in system:");
					TextArea questionText = new TextArea();

					for (TestViewListener l : listeners) {
						if (l instanceof TestController) {
							questionText.setText(((TestController) l).getAllQuestions());
						}
					}
					questionText.setEditable(false);
					HBox chooseQuestion = new HBox();
					chooseQuestion.setAlignment(Pos.TOP_LEFT);
					chooseQuestion.setSpacing(20);

					Label chooseQuestLabel = new Label("Choose question by serial number: ");

					chooseQuestion.getChildren().addAll(chooseQuestLabel, cmbAllQuestions);
					Label enterQuestLabel = new Label("Enter new question: ");
					TextField newQuestion = new TextField();
					Button saveQuestBtn = new Button("Save");
					saveQuestBtn.setPrefSize(90, 30);
					cmbAllQuestions.setVisibleRowCount(5);
					cmbAllQuestions.setPrefSize(130, 20);
					cmbAllQuestions.setPromptText("Serial numbers");
					editQuestFields.getChildren().addAll(questionLabel, questionText, chooseQuestion, enterQuestLabel,
							newQuestion, saveQuestBtn);

					pane.setCenter(editQuestFields);
					saveQuestBtn.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {

							for (TestViewListener l : listeners) {
								l.editQuestion(cmbAllQuestions.getValue(), newQuestion.getText());
								newQuestion.setText("");
							}
						}
					});
				}

			});
//*************************************************************************************************
			Button editAnsBtn = new Button("Edit Answer");
			editAnsBtn.setPrefWidth(200);
			editAnsBtn.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					VBox editAnswerFields = new VBox();
					editAnswerFields.setAlignment(Pos.TOP_LEFT);
					editAnswerFields.setSpacing(20);
					editAnswerFields.setPadding(new Insets(20));
					Label questionLabel = new Label("All questions in system:");
					TextArea questionText = new TextArea();
					questionText.setPrefHeight(300);
					for (TestViewListener l : listeners) {
						if (l instanceof TestController) {
							questionText.setText(((TestController) l).getAllQuestions());
						}
					}
					HBox chooseQuestion = new HBox();
					chooseQuestion.setAlignment(Pos.TOP_LEFT);
					chooseQuestion.setSpacing(20);
					Label chooseQuestLabel = new Label("Choose question by serial number: ");

					chooseQuestion.getChildren().addAll(chooseQuestLabel, cmbAllQuestions);
					Label enterQuestLabel = new Label("Enter new answer: ");
					TextField newQuestion = new TextField();

					Button saveAnswerBtn = new Button("Save");
					saveAnswerBtn.setPrefSize(90, 30);
					cmbAllQuestions.setVisibleRowCount(5);
					cmbAllQuestions.setPrefSize(130, 20);
					cmbAllQuestions.setPromptText("Serial numbers");
					// TRUE or FALSE
					HBox ifCorrectBox = new HBox();
					ifCorrectBox.setSpacing(20);
					ifCorrectBox.setVisible(false);
					Label ifCorrectLbl = new Label("If new answer is correct: ");
					ToggleGroup ifCorrect = new ToggleGroup();
					RadioButton right = new RadioButton("True");
					right.setSelected(true); // selected by default
					RadioButton wrong = new RadioButton("False");
					right.setToggleGroup(ifCorrect);
					wrong.setToggleGroup(ifCorrect);
					ifCorrectBox.getChildren().addAll(ifCorrectLbl, right, wrong);

					cmbAllQuestions.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent event) {
							for (TestViewListener l : listeners) {
								l.updateAnswer(cmbAllQuestions.getValue());

							}
							if (cmbNumOfAnswers.isVisible()) {
								ifCorrectBox.setVisible(true);
							} else {
								ifCorrectBox.setVisible(false);
							}
						}
					});
					cmbNumOfAnswers.setPrefSize(130, 20);
					cmbNumOfAnswers.setPromptText("Answer numbers");
					cmbNumOfAnswers.setVisible(false);
					chooseQuestion.getChildren().add(cmbNumOfAnswers);

					editAnswerFields.getChildren().addAll(questionLabel, questionText, chooseQuestion, ifCorrectBox,
							enterQuestLabel, newQuestion, saveAnswerBtn);
					saveAnswerBtn.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {

							for (TestViewListener l : listeners) {
								l.editAnswer(cmbAllQuestions.getValue(), newQuestion.getText(),
										cmbNumOfAnswers.getValue(),
										((RadioButton) ifCorrect.getSelectedToggle()).getText());

								newQuestion.setText("");
							}
						}
					});
					pane.setCenter(editAnswerFields);

				}
			});
//*************************************************************************************************
			Button deleteAnswBtn = new Button("Delete Answer");
			deleteAnswBtn.setPrefWidth(200);
			deleteAnswBtn.setPrefWidth(200);
			deleteAnswBtn.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					VBox deleteAnswerFields = new VBox();
					deleteAnswerFields.setAlignment(Pos.TOP_LEFT);
					deleteAnswerFields.setSpacing(20);
					deleteAnswerFields.setPadding(new Insets(20));
					Label attention = new Label("Attention: You can delete answers only from anerican questions!");
					attention.setTextFill(Color.RED);
					Label questionLabel = new Label("All questions in system:");
					TextArea questionText = new TextArea();
					questionText.setPrefHeight(300);
					for (TestViewListener l : listeners) {
						if (l instanceof TestController) {
							questionText.setText(((TestController) l).getAllQuestions());
						}
					}

					HBox chooseQuestion = new HBox();
					chooseQuestion.setAlignment(Pos.TOP_LEFT);
					chooseQuestion.setSpacing(20);
					Label chooseQuestLabel = new Label("Choose question by serial number: ");
					chooseQuestion.getChildren().addAll(chooseQuestLabel, cmbAllQuestions);

					Button deleteAnswerBtn = new Button("Delete");
					deleteAnswerBtn.setPrefSize(90, 30);
					cmbAllQuestions.setVisibleRowCount(5);
					cmbAllQuestions.setPrefSize(130, 20);
					cmbAllQuestions.setPromptText("Serial numbers");
					cmbAllQuestions.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent event) {
							for (TestViewListener l : listeners) {
								l.updateAnswer(cmbAllQuestions.getValue());

							}
						}
					});
					cmbNumOfAnswers.setPrefSize(130, 20);
					cmbNumOfAnswers.setPromptText("Answer numbers");
					cmbNumOfAnswers.setVisible(true);
					chooseQuestion.getChildren().add(cmbNumOfAnswers);

					deleteAnswerFields.getChildren().addAll(attention, questionLabel, questionText, chooseQuestion,
							deleteAnswerBtn);
					deleteAnswerBtn.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {

							for (TestViewListener l : listeners) {
								int selected = cmbNumOfAnswers.getValue();
								if (l.deleteAnswer(cmbAllQuestions.getValue(), cmbNumOfAnswers.getValue())) {

									deletedAnswerSuccesfully();
								}

							}

						}

					});
					pane.setCenter(deleteAnswerFields);

				}
			});

//*************************************************************************************************

			Button createManBtn = new Button("Create Manualy Test");
			createManBtn.setPrefWidth(200);
			createManBtn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					for (TestViewListener l : listeners) {
						l.createManualTestClicked();

					}
				}
			});
//*************************************************************************************************
			Button createAutoBtn = new Button("Create Auto Test");
			createAutoBtn.setPrefWidth(200);

			createAutoBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					VBox createExamBox = new VBox();
					createExamBox.setAlignment(Pos.TOP_LEFT);
					createExamBox.setSpacing(20);
					createExamBox.setPadding(new Insets(20));
					Label numOfQuestions = new Label("Choose number of questions in exam:");
					ComboBox<Integer> cmbQuestions = new ComboBox<Integer>();
					int comboSize = cmbAllQuestions.getItems().size();
					for (int i = 1; i <= comboSize; i++) {
						cmbQuestions.getItems().add(i);
					}
					Label sortType = new Label("Choose type of sorting:");

					RadioButton lexicSort = new RadioButton("Sort by lexicography order");
					RadioButton answerLengthSort = new RadioButton("Sort by answers lenght");
					ToggleGroup sorting = new ToggleGroup();

					lexicSort.setToggleGroup(sorting);
					answerLengthSort.setToggleGroup(sorting);

					TextArea newExamView = new TextArea();
					newExamView.setVisible(false);
					newExamView.setPrefHeight(400);

					Button createExam = new Button("Create Exam");
					createExam.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							int numOfQuestion = cmbQuestions.getValue();
							int sortType;
							if ((((RadioButton) sorting.getSelectedToggle()).getText())
									.equals("Sort by lexicography order")) {
								sortType = 1;
							} else {
								sortType = 2;
							}

							for (TestViewListener l : listeners) {
								if (l instanceof TestController) {
									String newExam = ((TestController) l).createAutoExam(numOfQuestion, sortType);
									newExamView.setText(newExam);
									newExamView.setVisible(true);
								}

							}

						}

					});

					createExamBox.getChildren().addAll(numOfQuestions, cmbQuestions, sortType, lexicSort,
							answerLengthSort, createExam, newExamView);

					pane.setCenter(createExamBox);

				}

			});

//*************************************************************************************************
			Button copyTestBtn = new Button("Copy Test");
			copyTestBtn.setPrefWidth(200);

			copyTestBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {

					for (TestViewListener l : listeners) {
						l.copyExamButtonClicked();
					}

				}
			});

//*************************************************************************************************

			Button exitBtn = new Button("Exit");
			exitBtn.setPrefWidth(200);
			exitBtn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					for (TestViewListener l : listeners) {
						l.exitButtonClicked();
					}
					stage.close();

				}

			});

			VBox menuButtons = new VBox();
			Text previewMessage = new Text();
			previewMessage.setText("Hello!\nWelcome to our tests creation system.\n\n" + "MENU: \n");
			previewMessage.setFont(Font.font("Impact", 17));
			previewMessage.setTextAlignment(TextAlignment.LEFT);
			previewMessage.setX(10);
			previewMessage.setY(10);

			menuButtons.setAlignment(Pos.TOP_LEFT);
			menuButtons.setSpacing(20);
			menuButtons.setPadding(new Insets(30));
			menuButtons.getChildren().addAll(previewMessage, viewBtn, addBtn, editQuestBtn, editAnsBtn, deleteAnswBtn,
					createManBtn, createAutoBtn, copyTestBtn, exitBtn);

			// root.getChildren().add(menuButtons);
			// pane.setBackground(null);
			// pane.setBackground(new Background(new BackgroundFill(Color.PAPAYAWHIP,
			// CornerRadii.EMPTY, Insets.EMPTY)));

			pane.setLeft(menuButtons);

			Scene scene = new Scene(pane, 1000, 700, Color.WHITE);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dataBaseView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addQuestionsToDataBase() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editQuestion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editAnswer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAnswer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createManualyTest(String allQuestions) {
		VBox createManualyTestBox = new VBox();
		
		createManualyTestBox.setAlignment(Pos.TOP_LEFT);
		createManualyTestBox.setSpacing(20);
		createManualyTestBox.setPadding(new Insets(20));
		HBox chooseQuestionBox = new HBox();
		chooseQuestionBox.setSpacing(20);
		chooseQuestionBox.setAlignment(Pos.TOP_LEFT);
		Label allQuestionsLbl = new Label("All questions in system: ");
		TextArea allQuestionsView = new TextArea(allQuestions);
		allQuestionsView.setPrefHeight(300);
		Label chooseQuestion = new Label("Choose question by serial number: ");		
		chooseQuestionBox.getChildren().addAll(chooseQuestion, cmbAllQuestions);
		
		//numbers of answers for american question in exam
		RadioButton firstAnswer = new RadioButton("1");
		firstAnswer.setVisible(false);
		RadioButton secondAnswer = new RadioButton("2");
		secondAnswer.setVisible(false);
		RadioButton thirdAnswer = new RadioButton("3");
		thirdAnswer.setVisible(false);
		RadioButton fourthAnswer = new RadioButton("4");
		fourthAnswer.setVisible(false);
		RadioButton fifthAnswer = new RadioButton("5");
		fifthAnswer.setVisible(false);
		RadioButton sixthAnswer = new RadioButton("6");
		sixthAnswer.setVisible(false);
		RadioButton seventhAnswer = new RadioButton("7");
		seventhAnswer.setVisible(false);
		RadioButton eighthAnswer = new RadioButton("8");
		eighthAnswer.setVisible(false);
		Label selectAnswers = new Label("Select answers that you want to add to american question:"); 
		selectAnswers.setVisible(false);
		HBox radioButtons = new HBox();
		radioButtons.setSpacing(20);
		radioButtons.setAlignment(Pos.TOP_LEFT);
		radioButtons.getChildren().addAll(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer,
											fifthAnswer, sixthAnswer, seventhAnswer, eighthAnswer);
		
		
		
		
		Map<Integer, ArrayList<Integer>> selectedQuestionsToExam = new HashMap<>();	
		
		cmbAllQuestions.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				int numOfAnswers = 0;
				for (TestViewListener l : listeners) {
					if(l instanceof TestController) {
						//numOfAnswers = 0 if its open question, else - it is number of answers in american question
						numOfAnswers = ((TestController)l).getNumberOfAnswers(cmbAllQuestions.getValue());
					}
				}
				switch (numOfAnswers) {
				case 1:
					selectAnswers.setVisible(true);
					firstAnswer.setVisible(true);
					secondAnswer.setVisible(false);
					thirdAnswer.setVisible(false);
					fourthAnswer.setVisible(false);
					fifthAnswer.setVisible(false);
					sixthAnswer.setVisible(false);
					seventhAnswer.setVisible(false);
					eighthAnswer.setVisible(false);
					break;
				case 2:
					selectAnswers.setVisible(true);
					firstAnswer.setVisible(true);
					secondAnswer.setVisible(true);
					thirdAnswer.setVisible(false);
					fourthAnswer.setVisible(false);
					fifthAnswer.setVisible(false);
					sixthAnswer.setVisible(false);
					seventhAnswer.setVisible(false);
					eighthAnswer.setVisible(false);
					break;
				case 3:
					selectAnswers.setVisible(true);
					firstAnswer.setVisible(true);
					secondAnswer.setVisible(true);
					thirdAnswer.setVisible(true);
					fourthAnswer.setVisible(false);
					fifthAnswer.setVisible(false);
					sixthAnswer.setVisible(false);
					seventhAnswer.setVisible(false);
					eighthAnswer.setVisible(false);
					break;
				case 4:
					selectAnswers.setVisible(true);
					firstAnswer.setVisible(true);
					secondAnswer.setVisible(true);
					thirdAnswer.setVisible(true);
					fourthAnswer.setVisible(true);
					fifthAnswer.setVisible(false);
					sixthAnswer.setVisible(false);
					seventhAnswer.setVisible(false);
					eighthAnswer.setVisible(false);
					break;
				case 5:
					selectAnswers.setVisible(true);
					firstAnswer.setVisible(true);
					secondAnswer.setVisible(true);
					thirdAnswer.setVisible(true);
					fourthAnswer.setVisible(true);
					fifthAnswer.setVisible(true);
					sixthAnswer.setVisible(false);
					seventhAnswer.setVisible(false);
					eighthAnswer.setVisible(false);
					break;
				case 6:
					selectAnswers.setVisible(true);
					firstAnswer.setVisible(true);
					secondAnswer.setVisible(true);
					thirdAnswer.setVisible(true);
					fourthAnswer.setVisible(true);
					fifthAnswer.setVisible(true);
					sixthAnswer.setVisible(true);
					seventhAnswer.setVisible(false);
					eighthAnswer.setVisible(false);
					break;
				case 7:
					selectAnswers.setVisible(true);
					firstAnswer.setVisible(true);
					secondAnswer.setVisible(true);
					thirdAnswer.setVisible(true);
					fourthAnswer.setVisible(true);
					fifthAnswer.setVisible(true);
					sixthAnswer.setVisible(true);
					seventhAnswer.setVisible(true);
					eighthAnswer.setVisible(false);
					break;
				case 8:
					selectAnswers.setVisible(true);
					firstAnswer.setVisible(true);
					secondAnswer.setVisible(true);
					thirdAnswer.setVisible(true);
					fourthAnswer.setVisible(true);
					fifthAnswer.setVisible(true);
					sixthAnswer.setVisible(true);
					seventhAnswer.setVisible(true);
					eighthAnswer.setVisible(true);
					break;

				default:// open question
					break;
				}
				
				
			}
		});
		Button saveQuestion = new Button("Save Question");
		saveQuestion.setPrefSize(110, 30);
		Button createExam = new Button("Create Exam");
		createExam.setPrefSize(110, 30);
		saveQuestion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int questionID = cmbAllQuestions.getValue();
				ArrayList<Integer> answers = new ArrayList<>();
				
				if (firstAnswer.isSelected()) {
					
				};
				
			}
		});
		
		
		
		cmbAllQuestions.setPrefSize(130, 20);
		cmbAllQuestions.setVisibleRowCount(5);
		cmbAllQuestions.setPromptText("Serial Numbers");
		createManualyTestBox.getChildren().addAll(allQuestionsLbl,allQuestionsView, chooseQuestionBox, selectAnswers, radioButtons, saveQuestion, createExam);
		pane.setCenter(createManualyTestBox);
		

	}

	@Override
	public void CreateAutomaticTest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void CreateCopyOfTest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

	public void registerListener(TestViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void viewAllQuestions(String allQuestions) {
		TextArea questionsView = new TextArea();

//		MenuBar menuBar = new MenuBar();
//		Menu menuFile = new Menu("File");
//		Menu menuEdit = new Menu("Edit");
//		Menu menuView = new Menu("View");
//		Menu menuHelp = new Menu("Help");
//		menuBar.getMenus().addAll(menuFile, menuEdit, menuView, menuHelp);
//		pane.setTop(menuBar);

		questionsView.setText(allQuestions);
		questionsView.setEditable(false);
		questionsView.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		questionsView.setPadding(new Insets(20));
		pane.setCenter(questionsView);

	}

	@Override
	public void addQuestionMessage(int serial) {
		systemAlert = new Alert(AlertType.INFORMATION);
		systemAlert.setTitle("Information");
		systemAlert.setHeaderText("Question added succesfully!");
		systemAlert.setContentText("Serial number: " + serial);
		systemAlert.show();

	}

	public void addSerialNUmberToCombo(int serial) {
		cmbAllQuestions.getItems().add(serial);
	}

	public void addedQuestionToView(int serial) {
		addSerialNUmberToCombo(serial);
	}

	@Override
	public void emptyFieldMessage() {
		systemAlert = new Alert(AlertType.ERROR);
		systemAlert.setTitle("Ops...something went wrong");
		systemAlert.setHeaderText("One of the fields are empty!");
		systemAlert.setContentText("Try again");
		systemAlert.show();

	}

	public void deletedAnswerSuccesfully() {
		systemAlert = new Alert(AlertType.INFORMATION);
		systemAlert.setTitle(" ");
		systemAlert.setHeaderText("Answer deleted succesfully!");
		systemAlert.setContentText(" ");
		systemAlert.show();

	}

	public void deleteAnswerFromOpenQuestionMessage() {
		systemAlert = new Alert(AlertType.ERROR);
		systemAlert.setTitle("Ops...something went wrong");
		systemAlert.setHeaderText("You tried delete answer from Open Question!");
		systemAlert.setContentText("Try again - only American Questions");
		systemAlert.show();
	}

	@Override
	public void examCopyCreatedMessage() {
		systemAlert = new Alert(AlertType.INFORMATION);
		systemAlert.setTitle(" ");
		systemAlert.setHeaderText("Exam copied succesfully!");
		systemAlert.setContentText(" ");
		systemAlert.show();
	}

	@Override
	public void exitMessage() {
		systemAlert = new Alert(AlertType.INFORMATION);
		systemAlert.setTitle(" ");
		systemAlert.setHeaderText("Question stock has saved succefully!");
		systemAlert.setContentText("Goodbye!");
		systemAlert.show();

	}

	@Override
	public void updateNumOfAnswersCombo(int numOfAnswers) {
		if (numOfAnswers == 0) {
			cmbNumOfAnswers.setVisible(false);
			cmbNumOfAnswers.getItems().add(1); // by default for open question
			cmbNumOfAnswers.getSelectionModel().select(0); // by default for open question

		} else {
			cmbNumOfAnswers.getItems().clear();
			for (int i = 1; i <= numOfAnswers; i++) {
				cmbNumOfAnswers.getItems().add(i);

			}
			cmbNumOfAnswers.setVisible(true);
		}

	}

	public void copyExam(int numOfExams, String allExam) {
		VBox copyExamBox = new VBox();
		copyExamBox.setAlignment(Pos.TOP_LEFT);
		copyExamBox.setSpacing(20);
		copyExamBox.setPadding(new Insets(30));
		Label allExamsInSystem = new Label("All exams in system: ");
		TextArea allExams = new TextArea();
		allExams.setPrefHeight(400);
		allExams.setText(allExam);
		Label chooseNumOfExams = new Label("Choose number of exam you want to copy:");
		ComboBox<Integer> cmbNumOfExams = new ComboBox<Integer>();
		for (int i = 1; i <= numOfExams; i++) {
			cmbNumOfExams.getItems().add(i);
		}
		Button copyExamBtn = new Button("Copy Exam");
		copyExamBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (TestViewListener l : listeners) {
					l.copyExam(cmbNumOfExams.getValue());
				}

			}
		});
		copyExamBox.getChildren().addAll(allExamsInSystem, allExams, chooseNumOfExams, cmbNumOfExams, copyExamBtn);
		pane.setCenter(copyExamBox);
	}

}
