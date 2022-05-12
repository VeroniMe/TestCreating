package proj;

import java.util.Comparator;

public class CompareQuestionsLexicodraphy implements Comparator<Question> {

	@Override
	public int compare(Question q1, Question q2) {
		return q1.getQuestion().compareToIgnoreCase(q2.getQuestion());
	
	}

}
