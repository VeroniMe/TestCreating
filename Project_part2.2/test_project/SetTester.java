package test_project;

import java.util.Iterator;

public class SetTester {

	public static void main(String[] args) {
		
		MySet<Answer> set = new MySet<Answer>();
		Answer a1 = new Answer("cat", true);
		Answer a2 = new Answer("dog", true);
		Answer a3 = new Answer("fish", false);
		Answer a4 = new Answer("fish", false);
		
		set.add(a1);
		set.add(a2);
		
		System.out.println(set.contains(a2));
		System.out.println(set.contains(a4));
		System.out.println(set.size());
		
		//set.remove(a1);
		System.out.println(set.isEmpty());
		//set.remove(a2);
		System.out.println(set.isEmpty());
		
		set.add(a3);
		set.add(a2);
		set.add(a2);
		
		Iterator<Answer> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}

	}

}
