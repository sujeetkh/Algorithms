package in.iisc.csa.sujeet.algorithms.hashing;

import java.util.HashSet;

public class PairSum {
	int[] arr;

	public PairSum(int[] arr) {
		this.arr = arr;
	}
	
	public boolean isPairSumPresent(int sum)
	{
		HashSet<Integer> set=new HashSet<Integer>();
		
		for(int value:arr)
		{
			if(set.contains(sum-value))
				return true;
			set.add(value);
		}
		return false;
	}
	
	public void print()
	{
		for(int val:arr)
			System.out.println(val);
	}
	
	public static void main(String[] args) {
		int[] arr= {10,20,35,40,54,59,69,75};
		PairSum pr=new PairSum(arr);
		pr.print();
		System.out.println("Is pair sum present for 30: "+pr.isPairSumPresent(30));
		System.out.println("Is pair sum present for 50: "+pr.isPairSumPresent(50));
		System.out.println("Is pair sum present for 70: "+pr.isPairSumPresent(70));
	}
}
