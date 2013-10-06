package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 没有上司的晚会 真·水题赛 ＃2(Codeforces)
背景

经典题目[真的很经典！]

描述

有个公司要举行一场晚会。为了让到会的每个人不受他的直接上司约束而能玩得开心，公司领导决定：如果邀请了某个人，那么一定不会再邀请他的直接的上司，但该人的上司的上司，上司的上司的上司……都可以邀请。已知每个人最多有唯一的一个上司。
已知公司的每个人参加晚会都能为晚会增添一些气氛，求一个邀请方案，使气氛值的和最大。

输入格式

第1行一个整数N（1<=N<=6000）表示公司的人数。
接下来N行每行一个整数。第i行的书表示第i个人的气氛值x（-128<=x<=127）。
接下来每行两个整数L，K。表示第K个人是第L个人的上司。
输入以0 0结束。

输出格式

一个数，最大的气氛值和。

样例输入

7
1
1
1
1
1
1
1
1 3
2 3
6 4
7 4
4 5
3 5
0 0
样例输出

5
数据范围与约定

对于100%的数据:1<=N<=6000，-128<=x<=127
来源

真·经典题目

为了提高水平建议屏蔽掉百度。
 
 
 
 * @author wanhao
 *
 */
public class PartyWithoutBoss {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int n = Integer.parseInt(reader.readLine());
		TreeNode[] tree = new TreeNode[n];
		int root = n * (n - 1) / 2;

		for (int i = 0; i < n; i++) {
			tree[i] = new TreeNode(Integer.parseInt(reader.readLine()));
		}

		for (;;) {
			String[] tmp = reader.readLine().split(" ");
			int child = Integer.parseInt(tmp[0]) - 1;
			int parent = Integer.parseInt(tmp[1]) - 1;
			if (child < 0 || parent < 0)
				break;

			if (tree[parent].child != -1) {
				tree[child].sibling = tree[parent].child;
			}
			tree[parent].child = child;

			root -= child;
		}

		int[][] f = new int[n][2];

		PartyWithoutBoss t=new PartyWithoutBoss();
		t.maxValue(tree,f,root);
		
		System.out.println(Math.max(f[root][0],f[root][1]));
	}

	public void maxValue(TreeNode[] tree, int[][] f, int root) {

		f[root][0] = 0;
		f[root][1] = tree[root].value;

		int tmp = tree[root].child;
		while (tmp != -1) {
			maxValue(tree, f, tmp);
			f[root][1] += f[tmp][0];
			f[root][0] += Math.max(f[tmp][0], f[tmp][1]);
			tmp = tree[tmp].sibling;
		}

	}

	static class TreeNode {
		private int value;
		private int child, sibling;

		public TreeNode(int value) {
			this.value = value;
			this.child = -1;
			this.sibling = -1;
		}

		public String toString() {
			return value + "";
		}
	}
}
