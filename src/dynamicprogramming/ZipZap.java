package dynamicprogramming;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
 * @author wanhao
 *
 */
public class ZipZap {
	
	public static void main(String[] args){
		int[] a=new int[]{ 1, 7, 4, 9, 2, 5 };
		System.out.println(longestZipZap(a)==6);
		
		a=new int[]{ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		System.out.println(longestZipZap(a)==7);
		
		a=new int[]{ 44};
		System.out.println(longestZipZap(a)==1);
		
		a=new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(longestZipZap(a)==2);
		
		a=new int[]{ 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };
		System.out.println(longestZipZap(a)==8);
		
		a=new int[]{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		System.out.println(longestZipZap(a)==36);
		
	}

	public static int longestZipZap(int[] sequence) {
		if (sequence == null || sequence.length == 0)
			return 0;

		int maxLen=1;
		int[] len = new int[sequence.length];
		int[] sign = new int[sequence.length];

		for (int i = 0; i < sequence.length; i++) {
			len[i] = 1;
			sign[i] = 0;

			int maxFlag = -1;
			for (int j = 0; j < i; j++) {
				if (sequence[i] != sequence[j]
						&& (sign[j] == 0 || sign[j] * (sequence[i] - sequence[j]) < 0)) {
					if (len[j] + 1 > len[i]) {
						len[i] = len[j] + 1;
						maxFlag = j;
					}
				}
			}
			if (maxFlag != -1) {
				sign[i] = sequence[i] - sequence[maxFlag] >0 ? 1:-1;
			}
			
			if(len[i]>maxLen){
				maxLen=len[i];
			}
		}

		return maxLen;
	}
}
