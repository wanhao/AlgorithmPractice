package leetcode;

public class ScrambleString {

	public static void main(String[] args) {
		ScrambleString t=new ScrambleString();
		System.out.println(t.isScramble("great","rgtae"));
	}

	public boolean isScramble(String s1, String s2) {
		boolean a = (s1 == null || s1.length() == 0);
		boolean b = (s2 == null || s2.length() == 0);
		if (a && b) {
			return true;
		} else if (a | b) {
			return false;
		} else {
			return isScramble(s1.toCharArray(), 0, s1.length() - 1,
					s2.toCharArray(), 0, s2.length() - 1);
		}
	}

	private boolean isScramble(char[] s1, int start1, int end1, char[] s2,
			int start2, int end2) {
		if (end1 - start1 != end2 - start2)
			throw new RuntimeException();

		if (start1 > end1)
			return true;
		if (start1 == end1) {
			return s1[start1] == s2[start2];
		}

		for (int i = start1; i <= end1; i++) {
			boolean left = isScramble(s1, start1, i, s2, start2, start2 + i
					- start1);
			boolean right = isScramble(s1, i + 1, end1, s2,
					i + 1 - end1 + end2, end2);
			if (left && right)
				return true;

			left = isScramble(s1, start1, i, s2, end2 + i - start1, end2);
			right = isScramble(s1, i + 1, end1, s2, start2, start2 + end1 - i
					- 1);
			if (left && right)
				return true;
		}

		return false;
	}
}
