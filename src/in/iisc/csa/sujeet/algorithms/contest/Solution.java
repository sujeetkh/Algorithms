package in.iisc.csa.sujeet.algorithms.contest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.iisc.csa.sujeet.algorithms.greedy.Activity;

class SortByStartTime implements Comparator<Activity> {
	public int compare(Activity a, Activity b) {
		return a.startTime - b.startTime;
	}
}

public class Solution {

	static int minimumNumber(int n, String password) {
		int res = 0;
		String regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%()+-]).{6,200})";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			return 0;
		} else {
			if (Pattern.compile(".*\\d.*").matcher(password).matches())
				res++;
			if (Pattern.compile(".*[a-z].*").matcher(password).matches())
				res++;
			if (Pattern.compile(".*[A-Z].*").matcher(password).matches())
				res++;
			if (Pattern.compile(".*[@#$%+-].*").matcher(password).matches())
				res++;
			res = 4 - res;
			if (n + res >= 6)
				return res;

			return 6 - n;

		}

	}

	static int pairs(int k, int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = 0;
		for (int i = 0; i < arr.length; i++)
			if (map.containsKey(arr[i])) {
				int val = map.get(arr[i]);
				map.put(arr[i], val + 1);
			} else
				map.put(arr[i], 1);

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] + k)) {
				res += map.get(arr[i] + k);
			}
			if (map.containsKey(arr[i] - k)) {
				res += map.get(arr[i] - k);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		//String str = "mkyong12@";
		//System.out.println(Pattern.compile(".*[!@#$%^&*()\\-+].*").matcher("AU-zsnV").matches());
		//System.out.println(minimumNumber(str.length(), str));
		int[] arr= {1, 2, 3, 4};
		System.out.println(pairs(1,arr));
	}

}
