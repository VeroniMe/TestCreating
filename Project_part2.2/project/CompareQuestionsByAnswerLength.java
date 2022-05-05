package project;

import java.util.Comparator;

public class CompareQuestionsByAnswerLength implements Comparator<Question>{

	@Override
	public int compare(Question q1, Question q2) {
		
		System.out.println("im in sorting");
//		if(q1.getAnswerLength() < q2.getAnswerLength()) {
//			System.out.println("return -1");
//			return -1;
//		} else if (q1.getAnswerLength() > q2.getAnswerLength()) {
//			System.out.println("return 1");
//			return 1; 
//		} else {
//			System.out.println("return 0");
//			return 0;
//		}
		int l1 = q1.getAnswerLength();
		int l2 = q2.getAnswerLength();
		return Integer.compare(l1, l2);
		
	}

}
