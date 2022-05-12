package proj;

import java.util.Comparator;

public class CompareQuestionsByAnswerLength implements Comparator<Question>{

	@Override
	public int compare(Question q1, Question q2) {
		int l1 = q1.getAnswerLength();
		int l2 = q2.getAnswerLength();
		return Integer.compare(l1, l2);
		
	}

}
