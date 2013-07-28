package dynamicprogramming;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
 * @author wanhao
 */
public class BadNeighbors {

  public static void main(String[] args) {
    int[] a = new int[] { 10, 3, 2, 5, 7, 8 };
    System.out.println(maxDonations(a) == 19);
    System.out.println(maxDonations1(a) == 19);

    a = new int[] { 11, 15 };
    System.out.println(maxDonations(a) == 15);
    System.out.println(maxDonations1(a) == 15);

    a = new int[] { 7, 7, 7, 7, 7, 7, 7 };
    System.out.println(maxDonations(a) == 21);
    System.out.println(maxDonations1(a) == 21);

    a = new int[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
    System.out.println(maxDonations(a) == 16);
    System.out.println(maxDonations1(a) == 16);

    a =
        new int[] { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29,
            95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
    System.out.println(maxDonations(a) == 2926);
    System.out.println(maxDonations1(a) == 2926);
  }

  // d(i) = max donation when considering first i elements and ith element is surely taken in it.
  public static int maxDonations(int[] donations) {
    if (donations == null || donations.length == 0) return 0;
    else if (donations.length == 1) return donations[0];
    else if (donations.length == 2) return donations[0] > donations[1] ? donations[0]
        : donations[1];

    // 0~n-2
    int[] d1 = new int[donations.length];
    d1[0] = donations[0];
    d1[1] = donations[1];
    for (int i = 2; i < donations.length - 1; i++) {
      d1[i] = Math.max(d1[i - 1], d1[i - 2] + donations[i]);
    }

    // 1~n-1
    int[] d2 = new int[donations.length];
    d2[1] = donations[1];
    d2[2] = donations[2];
    for (int i = 3; i < donations.length; i++) {
      d2[i] = Math.max(d2[i - 1], d2[i - 2] + donations[i]);
    }

    return Math.max(d1[donations.length - 2], d2[donations.length - 1]);
  }

  //d(i) = max donations considering just the elements from 0 to i and no constraints on i ,you may take it or not
  public static int maxDonations1(int[] donations) {
    if (donations == null || donations.length == 0) return 0;
    else if (donations.length == 1) return donations[0];
    else if (donations.length == 2) return donations[0] > donations[1] ? donations[0]
        : donations[1];

    // 0~n-2
    int[] d1 = new int[donations.length];
    d1[0] = donations[0];
    d1[1] = donations[1];
    d1[2] = donations[0] + donations[2];
    for (int i = 3; i < donations.length - 1; i++) {
      d1[i] = Math.max(d1[i - 2], d1[i - 3]) + donations[i];
    }

    // 1~n-1
    int[] d2 = new int[donations.length];
    d2[0] = 0;
    d2[1] = donations[1];
    d2[2] = donations[2];
    for (int i = 3; i < donations.length; i++) {
      d2[i] = Math.max(d2[i - 2], d2[i - 3]) + donations[i];
    }

    return Math.max(d1[donations.length - 2], d2[donations.length - 1]);
  }
}
