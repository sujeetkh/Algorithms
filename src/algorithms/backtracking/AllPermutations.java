package algorithms.backtracking;

public class AllPermutations {
	char[] arr;

	AllPermutations(char[] arr) {
		this.arr = arr;
	}

	void swap(int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	void printArr() {
		System.out.println(String.valueOf(arr));
	}

	public void generateAllPermutations(int low, int high) {
		if (low >= high)
			return;
		for (int i = low + 1; i < high; i++) {
			printArr();
			swap(low, i);
			generateAllPermutations(i, high);
			swap(low, i);
		}
	}

	public static void main(String[] args) {
		String str = "abcde";
		AllPermutations per = new AllPermutations(str.toCharArray());
		per.generateAllPermutations(0, str.length() - 1);
	}

}
