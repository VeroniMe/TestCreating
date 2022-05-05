package project;

public class BubbleSort {
	
	private boolean hasChanged = true;
	
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
	public void sort(int[] arr) {		
		for (int i = arr.length-1; i > 0 && hasChanged; i--) {//with each iteration array is getting smaller
			hasChanged = false;
			for (int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					hasChanged = true;
				}
			}
		}
	}

}
