package oneil.marcel;

public class Sorts {

	public static void selectionSort(int[] list) {
		int length = list.length;
		for (int i = 0; i < length; i++) {
			int min = i;
			for (int selection = i + 1; selection < length; selection++) {
				if (list[selection] < list[min])
					min = selection;
			}
			swap(list, i, min);
		}
	}
	
	public static void insertionSort(int[] array) {
	    for (int i = 0; i < array.length - 1; i++) {
	        int j = i + 1;
	        int tmp = array[j];
	        while (j > 0 && tmp < array[j-1]) {
	            array[j] = array[j-1];
	            j--;
	        }
	        array[j] = tmp;
	    }
	}

	public static void mergeSort(int[] array, int[] aux, int left, int right) {
	    if (left == right) return; 
	    int middleIndex = (left + right)/2;
	    mergeSort(array, aux, left, middleIndex);
	    mergeSort(array, aux, middleIndex + 1, right);
	    merge(array, aux, left, right);
	  
	    for (int i = left; i <= right; i++) {
	        array[i] = aux[i];
	    }
	} 

	public static void quicksort(int[] array, int left, int right) {
	    if (left < right) { 
	        int boundary = left;
	        for (int i = left + 1; i < right; i++) { 
	            if (array[i] < array[left]) { 
	                swap(array, i, ++boundary);
	            }
	        }
	        swap(array, left, boundary);
	        quicksort(array, left, boundary);
	        quicksort(array, boundary + 1, right);
	    }     
	}

	private static void merge(int[] array, int[] aux, int left, int right) {
	    int middleIndex = (left + right)/2;
	    int leftIndex = left; 
	    int rightIndex = middleIndex + 1;
	    int auxIndex = left;
	    while (leftIndex <= middleIndex && rightIndex <= right) {
	        if (array[leftIndex] <= array[rightIndex]) {
	            aux[auxIndex] = array[leftIndex++];
	        } else {
	            aux[auxIndex] = array[rightIndex++];
	        }
	        auxIndex++;
	    }
	    while (leftIndex <= middleIndex) {
	        aux[auxIndex] = array[leftIndex++];
	        auxIndex++;
	    }
	    while (rightIndex <= right) {
	        aux[auxIndex] = array[rightIndex++];
	        auxIndex++;
	    }
	}    

	private static void swap(int[] array, int left, int right) {
		int tmp = array[right];
		array[right] = array[left];
		array[left] = tmp;
	}

}
