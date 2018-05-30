package in.iisc.csa.sujeet.algorithms.sorting;

public class QuickSort {
	int[] arr;

	void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	QuickSort(int[] arr) {
		this.arr = arr;
	}

	int pivot(int low, int high) {
		return high;
	}

	int partition(int low, int high) {
		int i, j, pivot;
		i = low - 1;
		j = high - 1;
		pivot = high;

		while (i < j) {
			if (arr[j] <= arr[pivot]) {
				i++;
				swap(i, j);
			} else {
				j--;
			}
		}
		swap(i + 1, pivot);

		return i + 1;
	}

	void quicksortUtil(int low, int high) {
		if (low >= high)
			return;
		int pi = partition(low, high);
		quicksortUtil(low, pi - 1);
		quicksortUtil(pi + 1, high);
	}

	public void quicksort() {
		quicksortUtil(0, arr.length - 1);
	}

	public void print() {
		for (int value : arr)
			System.out.println(value);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 9, 15, 27, 57, 2, 15, 56, 657 };
		QuickSort sarr = new QuickSort(arr);
		sarr.quicksort();
		sarr.print();
	}
}
