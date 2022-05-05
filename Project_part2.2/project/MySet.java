package project;

import java.util.Iterator;

public class MySet<T> {

	private T[] data;
	private final int ENLARGE_FACTOR = 2;
	private int numOfItems;

	public MySet() {
		data = (T[]) new Object[ENLARGE_FACTOR];
		numOfItems = 0;
	}

	public boolean add(T newItem) {

		if (numOfItems == data.length) {
			T[] newData = (T[]) new Object[data.length * ENLARGE_FACTOR];
			for (int i = 0; i < data.length; i++) {
				newData[i] = data[i];
			}
			data = newData;
		}
		if (numOfItems != 0) {
			if (contains(newItem)) {
				return false;
			}
		}
		data[numOfItems++] = newItem;
		return true;

	}

	public boolean contains(T item) {
		if (numOfItems != 0) {
			for (int i = 0; i < numOfItems; i++) {
				if (data[numOfItems - 1].equals(item)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean remove(T item) {
		if (item != null) {
			int index = indexOf(item);
			if (index != -1) {
				data[index] = data[numOfItems - 1];
				data[numOfItems - 1] = null;
				numOfItems--;
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		if (numOfItems == 0)
			return true;
		return false;
	}

	public int size() {
		return numOfItems;

	}

	public int indexOf(T item) {
		for (int i = 0; i < numOfItems; i++) {
			if (data[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	public Iterator<T> iterator() {
		return new SetIterator();
	}

	private class SetIterator implements Iterator<T> {
		private int index = 0;

		@Override
		public boolean hasNext() {
			if (index < numOfItems)
				return true;
			return false;
		}

		@Override
		public T next() {
			return data[index++];

		}

	}

}
