package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 û����˾����� �桤ˮ���� ��2(Codeforces)
����

������Ŀ[��ĺܾ��䣡]

����

�и���˾Ҫ����һ����ᡣΪ���õ����ÿ���˲�������ֱ����˾Լ��������ÿ��ģ���˾�쵼���������������ĳ���ˣ���ôһ����������������ֱ�ӵ���˾�������˵���˾����˾����˾����˾����˾�������������롣��֪ÿ���������Ψһ��һ����˾��
��֪��˾��ÿ���˲μ���ᶼ��Ϊ�������һЩ���գ���һ�����뷽����ʹ����ֵ�ĺ����

�����ʽ

��1��һ������N��1<=N<=6000����ʾ��˾��������
������N��ÿ��һ����������i�е����ʾ��i���˵�����ֵx��-128<=x<=127����
������ÿ����������L��K����ʾ��K�����ǵ�L���˵���˾��
������0 0������

�����ʽ

һ��������������ֵ�͡�

��������

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
�������

5
���ݷ�Χ��Լ��

����100%������:1<=N<=6000��-128<=x<=127
��Դ

�桤������Ŀ

Ϊ�����ˮƽ�������ε��ٶȡ�
 
 
 
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
