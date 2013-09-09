package leetcode;

public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EditDistance t = new EditDistance();
		System.out.println(t.minDistance("a", "b"));
	}
	


	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 0;
		} else if (word1 == null) {
			return word2.length();
		} else if (word2 == null) {
			return word1.length();
		} else {
			int[][] distance = new int[word1.length() + 1][word2.length() + 1];
			for (int j = 0; j <= word2.length(); j++) {
				distance[word1.length()][j] = word2.length() - j;
			}
			for (int i = 0; i <= word1.length(); i++) {
				distance[i][word2.length()] = word1.length() - i;
			}
			
			for (int i = word1.length() - 1; i >= 0; i--) {
				for (int j = word2.length() - 1; j >= 0; j--) {
					if (word1.charAt(i) == word2.charAt(j)) {
						distance[i][j] = distance[i + 1][j + 1];
					} else {
						distance[i][j] = Math.min(distance[i + 1][j],
								distance[i + 1][j + 1]);
						distance[i][j] = Math.min(distance[i][j],
								distance[i][j + 1]);
						distance[i][j]+=1;
					}
				}
			}

			return distance[0][0];
		}
	}

	private int minDistance(String word1, int i, String word2, int j) {
		if (i >= word1.length()) {
			return word2.length() - j;
		} else if (j >= word2.length()) {
			return word1.length() - i;
		} else {
			if (word1.charAt(i) == word2.charAt(j)) {
				return minDistance(word1, i + 1, word2, j + 1);
			} else {
				int min = minDistance(word1, i + 1, word2, j + 1);
				min = Math.min(min, minDistance(word1, i + 1, word2, j));
				min = Math.min(min, minDistance(word1, i, word2, j + 1));

				return min + 1;
			}
		}
	}

}
