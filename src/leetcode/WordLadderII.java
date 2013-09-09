package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class WordLadderII {

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		if (start.equals(end)) {
			ArrayList<String> tmp = new ArrayList<String>();
			tmp.add(start);
			result.add(tmp);
			return result;
		}

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(2*dict.size());

		char tmp;
		String tmpWord = null;
		for (String word : dict) {
			ArrayList<String> tmpList = new ArrayList<String>();
			map.put(word, tmpList);

			char[] wordArray = word.toCharArray();
			for (int i = 0; i < wordArray.length; i++) {
				tmp = wordArray[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (c != tmp) {
						wordArray[i] = c;
						tmpWord = new String(wordArray);

						if (dict.contains(tmpWord)) {
							tmpList.add(tmpWord);
						}
					}
				}
				wordArray[i] = tmp;
			}
		}

		ArrayList<LNode> tmpResult = new ArrayList<LNode>();

		LinkedList<LNode> queue = new LinkedList<LNode>();
		queue.addLast(new LNode(start));

		int maxCount = 1;
		int nextMaxCount = 0;
		int currentCount = 0;
		boolean find = false;
		ArrayList<String> toRemove = new ArrayList<String>();

		LNode head = null;
		while (!queue.isEmpty()) {
			head = queue.removeFirst();
			String word = head.str;

			for (String tmpStr : map.get(word)) {
				if (tmpStr.equals(end)) {
					find = true;
					LNode newhead = new LNode(tmpStr);
					newhead.next = head;
					tmpResult.add(newhead);
					continue;
				}
				if (!find && dict.contains(tmpStr)) {
					toRemove.add(tmpStr);
					LNode newhead = new LNode(tmpStr);
					newhead.next = head;
					queue.add(newhead);
					nextMaxCount++;
				}
			}

			currentCount++;
			if (currentCount >= maxCount) {
				if (find) {
					break;
				}
				if (!toRemove.isEmpty()) {
					for(String remove:toRemove){
						dict.remove(remove);
					}
					toRemove.clear();
				}
				currentCount = 0;
				maxCount = nextMaxCount;
				nextMaxCount = 0;
			}

		}

		for (LNode tmphead : tmpResult) {
			ArrayList<String> tmpList = new ArrayList<String>();
			Stack<String> tmpStack = new Stack<String>();
			while (tmphead != null) {
				tmpStack.push(tmphead.str);
				tmphead = tmphead.next;
			}

			while (!tmpStack.isEmpty()) {
				tmpList.add(tmpStack.pop());
			}
			result.add(tmpList);
		}

		return result;
	}

	static class LNode {
		private String str = null;
		private LNode next = null;

		public LNode(String s) {
			str = s;
		}
	}

	// public ArrayList<ArrayList<String>> findLadders(String start, String end,
	// HashSet<String> dict) {
	// ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	//
	// if (start.equals(end)) {
	// ArrayList<String> tmp = new ArrayList<String>();
	// tmp.add(start);
	// result.add(tmp);
	// return result;
	// }
	//
	// ArrayList<LNode> tmpResult = new ArrayList<LNode>();
	//
	// LinkedList<LNode> queue = new LinkedList<LNode>();
	// queue.addLast(new LNode(start));
	//
	// int maxCount = 1;
	// int nextMaxCount = 0;
	// int currentCount = 0;
	// boolean find = false;
	// ArrayList<String> toRemove = new ArrayList<String>();
	//
	// LNode head = null;
	// while (!queue.isEmpty()) {
	// head = queue.removeFirst();
	// char[] wordArray = head.str.toCharArray();
	//
	// char tmp;
	// String tmpStr = null;
	// for (int i = 0; i < wordArray.length; i++) {
	// tmp = wordArray[i];
	// for (char c = 'a'; c <= 'z'; c++) {
	// if (c != tmp) {
	// wordArray[i] = c;
	// tmpStr = new String(wordArray);
	// if (tmpStr.equals(end)) {
	// find = true;
	// LNode newhead = new LNode(tmpStr);
	// newhead.next = head;
	// tmpResult.add(newhead);
	// continue;
	// }
	// if (!find && dict.contains(tmpStr)) {
	// toRemove.add(tmpStr);
	// LNode newhead = new LNode(tmpStr);
	// newhead.next = head;
	// queue.add(newhead);
	// nextMaxCount++;
	// }
	// }
	// }
	// wordArray[i] = tmp;
	// }
	//
	// currentCount++;
	// if (currentCount >= maxCount) {
	// if (find) {
	// break;
	// }
	// if (!toRemove.isEmpty()) {
	// dict.removeAll(toRemove);
	// toRemove.clear();
	// }
	// currentCount = 0;
	// maxCount = nextMaxCount;
	// nextMaxCount = 0;
	// }
	//
	// }
	//
	// for (LNode tmphead : tmpResult) {
	// ArrayList<String> tmpList = new ArrayList<String>();
	// Stack<String> tmpStack = new Stack<String>();
	// while (tmphead != null) {
	// tmpStack.push(tmphead.str);
	// tmphead = tmphead.next;
	// }
	//
	// while (!tmpStack.isEmpty()) {
	// tmpList.add(tmpStack.pop());
	// }
	// result.add(tmpList);
	// }
	//
	// return result;
	// }

}
