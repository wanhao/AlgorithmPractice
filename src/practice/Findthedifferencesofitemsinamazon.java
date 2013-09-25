package practice;

public class Findthedifferencesofitemsinamazon {

	public static void main(String[] args) {
		String s1 = "Hadoop in practice";
		String s2 = "Hadoop operations";
		System.out.println(Findthedifferencesofitemsinamazon.differ(s1, s2));

		s1 = "Hadoop cookbook";
		s2 = "Hadoop operations";
		System.out.println(Findthedifferencesofitemsinamazon.differ(s1, s2));

		s1 = "Ruby in action";
		s2 = "Hadoop operations";
		System.out.println(Findthedifferencesofitemsinamazon.differ(s1, s2));

		s1 = "Kindle Fire HD Tablet";
		s2 = "Kindle Fire HD 8.9\" 4G LTE Wireless Tablet";
		System.out.println(Findthedifferencesofitemsinamazon.differ(s1, s2));
	}

	static int differ(String string1, String string2) {
		String[] s1 = new String[0], s2 = new String[0];
		if (string1 != null) {
			s1 = string1.split(" ");
		}
		if (string2 != null) {
			s2 = string2.split(" ");
		}

		int[][] distance = new int[s1.length + 1][s2.length + 2];
		int i, j;
		for (i = 0; i <= s1.length; i++)
			distance[i][0] = i;
		for (j = 0; j <= s2.length; j++)
			distance[0][j] = j;
		for (i = 1; i <= s1.length; i++) {
			for (j = 1; j <= s2.length; j++) {
				if (s1[i - 1].equals(s2[j - 1])) {
					distance[i][j] = distance[i - 1][j - 1];
				} else {
					distance[i][j] = distance[i - 1][j - 1];
					if (distance[i - 1][j] < distance[i][j]) {
						distance[i][j] = distance[i - 1][j];
					}
					if (distance[i][j - 1] < distance[i][j]) {
						distance[i][j] = distance[i][j - 1];
					}
					distance[i][j]++;
				}
			}
		}
		return distance[s1.length][s2.length];
	}

	static int differ(String[] s1, int pos1, String[] s2, int pos2) {
		if (pos1 >= s1.length) {
			return s2.length - pos2;
		}
		if (pos2 >= s2.length) {
			return s1.length - pos1;
		}
		int difference = 0;
		if (s1[pos1].equals(s2[pos2])) {
			difference = differ(s1, pos1 + 1, s2, pos2 + 1);
		} else {
			difference = differ(s1, pos1, s2, pos2 + 1);
			difference = Math.min(difference, differ(s1, pos1 + 1, s2, pos2));
			difference = Math.min(difference,
					differ(s1, pos1 + 1, s2, pos2 + 1));
			difference++;
		}
		return difference;
	}

}
