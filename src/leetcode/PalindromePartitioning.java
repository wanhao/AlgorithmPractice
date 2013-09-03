package leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {

	public static void main(String[] args) {
		PalindromePartitioning t=new PalindromePartitioning();
		
		String s="aab";
		System.out.println(t.partition(s));
		
		s="aba";
		System.out.println(t.partition(s));
		
		s="abba";
		System.out.println(t.partition(s));
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		if (s == null || s.isEmpty())
			return result;

		ArrayList<Integer> locations = new ArrayList<Integer>();
		partition(s, result, locations, 0);

		return result;
	}

	private void partition(String s, ArrayList<ArrayList<String>> result,
			ArrayList<Integer> locations, int startLocation) {
		if (startLocation >= s.length()) {
			ArrayList<String> tmp = new ArrayList<String>();
			for (int i = 0; i < locations.size(); i++) {
				if (i != locations.size() - 1) {
					tmp.add(s.substring(locations.get(i), locations.get(i + 1)));
				} else {
					tmp.add(s.substring(locations.get(i)));
				}
			}
			result.add(tmp);
			return;
		}

		for (int endLocation = s.length() - 1; endLocation >= startLocation; endLocation--) {
			int start = startLocation;
			int end = endLocation;
			while (start <= end && s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			}

			if (start > end) {
				locations.add(startLocation);
				partition(s, result, locations, endLocation + 1);
				locations.remove(locations.size() - 1);
			}
		}
	}
}
