package in.iisc.csa.sujeet.algorithms.patternsearch;

public class KMPAlgorithm {
	char[] text;
	char[] pattern;
	int[] lps;

	public KMPAlgorithm(String text, String pattern) {
		super();
		this.text = text.toCharArray();
		this.pattern = pattern.toCharArray();
		lps = new int[pattern.length()];
	}

	public void generateLPS() {

		if (pattern.length == 0)
			return;

		lps[0] = 0;

		int i = 1, longestPrefix = 0;

		while (i < pattern.length) {
			if (pattern[i] == pattern[longestPrefix]) {
				longestPrefix++;
				lps[i] = longestPrefix;
				i++;
			} else {
				if (longestPrefix != 0) {
					longestPrefix = lps[longestPrefix - 1];// tricky
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}

	public void printLPS() {
		for (int value : lps)
			System.out.println(value);
	}

	public void printMatches() {
		int i = 0, j = 0;

		while (i < text.length) {

			if (text[i] == pattern[j]) {
				i++;
				j++;
			}

			if (j == pattern.length) {
				System.out.println("Match found from index: " + (i - j));
				j = lps[j - 1];
			} else if (i < text.length && text[i] != pattern[j]) {
				if (j != 0)
					j = lps[j - 1];
				else
					i++;
			}
		}
	}

	public static void main(String[] args) {
		KMPAlgorithm kmp = new KMPAlgorithm("ABABDABACDABABCABAB", "ABABCABAB");
		kmp.generateLPS();
		kmp.printLPS();
		kmp.printMatches();
	}

}
