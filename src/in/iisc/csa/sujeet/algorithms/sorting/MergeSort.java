package in.iisc.csa.sujeet.algorithms.sorting;

public class MergeSort {
	int[] arr;

	MergeSort(int[] arr) {
		this.arr = arr;
	}

	void merge(int low, int mid, int high) {
		// 0,9,4
		int[] tmp1 = new int[mid - low + 1];
		int[] tmp2 = new int[high - mid];

		for (int i = 0; i < mid - low + 1; i++)
			tmp1[i] = arr[low + i];

		for (int i = 0; i < high - mid; i++)
			tmp2[i] = arr[mid + 1 + i];

		int i = 0, j = 0, curr = low;

		while (i < mid - low + 1 && j < high - mid) {
			if (tmp1[i] <= tmp2[j]) {
				arr[curr] = tmp1[i];
				curr++;
				i++;
			} else {
				arr[curr] = tmp2[j];
				curr++;
				j++;
			}
		}

		while (i < mid - low + 1) {
			arr[curr] = tmp1[i];
			curr++;
			i++;
		}

		while (j < high - mid) {
			arr[curr] = tmp2[j];
			curr++;
			j++;
		}

	}

	public void mergeSortUtil(int low, int high) {
		if (low >= high)
			return;
		int mid = low + (high - low) / 2;

		mergeSortUtil(low, mid);
		mergeSortUtil(mid + 1, high);
		merge(low, mid, high);
	}

	public void mergeSort() {
		mergeSortUtil(0, arr.length - 1);
	}

	public void print() {
		for (int value : arr)
			System.out.println(value);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 9, 15, 27, 57, 2, 15, 56, 657 };
		MergeSort sarr = new MergeSort(arr);
		sarr.mergeSort();
		sarr.print();
	}
}
