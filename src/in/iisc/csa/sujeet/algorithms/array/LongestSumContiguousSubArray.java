package in.iisc.csa.sujeet.algorithms.array;

public class LongestSumContiguousSubArray {
	int[] arr;
	int start;
	int end;

	LongestSumContiguousSubArray(int[] arr) {
		this.arr = arr;
		start = -1;
		end = -1;
	}

	public void findSubArray() {
		if (arr.length == 0) {
			System.out.println("Array is empty.");
			return;
		}

		int max, currentSum, tmpStart;

		max = -1234567623;
		currentSum = 0;
		tmpStart = 0;

		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			if (max < currentSum) {
				max = currentSum;
				start = tmpStart;
				end = i;
			}
			if (currentSum < 0) {
				tmpStart = i + 1;
				currentSum = 0;
			}
		}
	}

	public void printSubArray() {
		if (start == -1)
			return;

		for (int i = start; i <= end; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		int a[] = {-2, -3, -5, -1, -2, -17, -1, -3};
		LongestSumContiguousSubArray subArray=new LongestSumContiguousSubArray(a);
		subArray.findSubArray();
		subArray.printSubArray();
	}

}
