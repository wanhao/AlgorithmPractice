package leetcode;

import java.util.Stack;

public class SurroundedRegions {
	public static void main(String[] args) {
		SurroundedRegions t = new SurroundedRegions();

		char[][] board = new char[][] { { 'X', 'X', 'X', 'X' },
				{ 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		t.print(board);
		t.solve(board);
		t.print(board);

		board = new char[][] { { 'X', 'O', 'X', 'X', 'X' },
				{ 'X', 'O', 'O', 'X', 'X' }, { 'X', 'X', 'O', 'X', 'X' },
				{ 'X', 'X', 'X', 'O', 'X' }, { 'X', 'X', 'O', 'O', 'X' },
				{ 'X', 'O', 'X', 'X', 'X' } };

		t.print(board);
		t.solve(board);
		t.print(board);

	}

	public void print(char[][] board) {
		for (int x = 0; x < board.length; x++) {
			System.out.println(board[x]);
		}
		System.out.println();
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0] == null
				|| board[0].length == 0)
			return;

		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int x = 0; x < board.length; x++) {
			traverseRegion(visited, board, x, 0);
			traverseRegion(visited, board, x, board[0].length - 1);
		}

		for (int y = 0; y < board[0].length; y++) {
			traverseRegion(visited, board, 0, y);
			traverseRegion(visited, board, board.length - 1, y);
		}

		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (board[x][y] == 'O' && !visited[x][y]) {
					board[x][y] = 'X';
				}
			}
		}
	}

	private void traverseRegion(boolean[][] visited, char[][] board, int x,
			int y) {
		if (board[x][y] != 'O')
			return;

		Stack<int[]> stack = new Stack<int[]>();
		stack.push(new int[] { x, y });

		int[] tmp = null;
		while (!stack.isEmpty()) {
			tmp = stack.pop();
			x = tmp[0];
			y = tmp[1];

			if (visited[x][y] || board[x][y] != 'O')
				continue;

			visited[x][y] = true;

			if (x < board.length - 1) {
				stack.push(new int[] { x + 1, y });
			}

			if (x > 0) {
				stack.push(new int[] { x - 1, y });
			}

			if (y < board[0].length - 1) {
				stack.push(new int[] { x, y + 1 });
			}

			if (y > 0) {
				stack.push(new int[] { x, y - 1 });
			}
		}

	}

	// private void traverseRegion(boolean[][] visited, char[][] board, int x,
	// int y) {
	// if (visited[x][y] || board[x][y] != 'O')
	// return;
	//
	// visited[x][y] = true;
	//
	// if (x < board.length - 1) {
	// traverseRegion(visited, board, x + 1, y);
	// }
	//
	// if (x > 0) {
	// traverseRegion(visited, board, x - 1, y);
	// }
	//
	// if (y < board[x].length - 1) {
	// traverseRegion(visited, board, x, y + 1);
	// }
	//
	// if (y > 0) {
	// traverseRegion(visited, board, x, y - 1);
	// }
	// }
}
