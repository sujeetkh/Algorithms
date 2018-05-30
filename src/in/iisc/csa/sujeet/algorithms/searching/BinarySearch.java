package in.iisc.csa.sujeet.algorithms.searching;

public class BinarySearch {
	int[] arr;

	public BinarySearch(int[] arr) {
		this.arr = arr;
	}

	public boolean isElementExits(int value) {
		int start, mid, end;
		start = 0;
		end = arr.length;
		while (start < end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == value)
				return true;
			if (value < arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr= {10,20,35,40,54,59,69,75};
		BinarySearch search=new BinarySearch(arr);
		System.out.println(search.isElementExits(20));
	}

}
