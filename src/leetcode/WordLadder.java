package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {

	public int ladderLength(String start, String end, HashSet<String> dict) {
		if(start.equals(end)) return 1;
		
		LinkedList<String> queue=new LinkedList<String>();
		queue.addLast(start);
		int level=1;
		int maxCount=1;
		int nextMaxCount=0;
		int currentCount=0;
		
		while(!queue.isEmpty()){
			String word=queue.removeFirst();
			char[] wordArray=word.toCharArray();
			
			char tmp;
			String tmpStr=null;
			for(int i=0;i<wordArray.length;i++){
				tmp=wordArray[i];
				for(char c='a';c<='z';c++){
					if(c!=tmp){
						wordArray[i]=c;
						tmpStr=new String(wordArray);
						if(tmpStr.equals(end)) return level+1;
						if(dict.contains(tmpStr)){
							dict.remove(tmpStr);
							queue.add(tmpStr);
							nextMaxCount++;
						}
					}
				}
				wordArray[i]=tmp;
			}
			
			currentCount++;
			if(currentCount>=maxCount){
				currentCount=0;
				maxCount=nextMaxCount;
				nextMaxCount=0;
				level++;
			}	
			
		}
		
		return 0;
	}

}
