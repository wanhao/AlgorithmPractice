package leetcode;

import java.util.ArrayList;


public class InsertInterval {
	
	public static void main(String[] args) {
		InsertInterval t = new InsertInterval();
		ArrayList<Interval> result = new ArrayList<Interval>();
		result.add(new Interval(1, 2));
		result.add(new Interval(3, 5));
		result.add(new Interval(6, 7));
		result.add(new Interval(8, 10));
		result.add(new Interval(12, 16));

		System.out.println(t.insert(result, new Interval(4,9)));
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		if (intervals.isEmpty()) {
			intervals.add(newInterval);
			return intervals;
		}

		ArrayList<Interval> result = new ArrayList<Interval>();
		int startPos=-1, endPos=-1;
		
		Interval tmp=null;
		int low=0,high=intervals.size()-1,middle=0;
		while(low<=high){
			middle=(low+high)/2;
			tmp=intervals.get(middle);
			if(tmp.end==newInterval.start){
				startPos=middle;
				break;
			}else if(tmp.end<newInterval.start){
				low=middle+1;
			}else{
				high=middle-1;
			}
		}
		if(startPos<0){
			startPos=low;
		}

		low=0;
		high=intervals.size()-1;
		while(low<=high){
			middle=(low+high)/2;
			tmp=intervals.get(middle);
			if(tmp.start==newInterval.end){
				endPos=middle;
				break;
			}else if(tmp.start<newInterval.end){
				low=middle+1;
			}else{
				high=middle-1;
			}
		}
		if(endPos<0){
			endPos=high;
		}
		
		if(startPos>endPos){
			for(int i=0;i<=endPos;i++){
				result.add(intervals.get(i));
			}
			result.add(newInterval);
			for(int i=startPos;i<intervals.size();i++){
				result.add(intervals.get(i));
			}
		}else{
			for(int i=0;i<startPos && i<intervals.size();i++){
				result.add(intervals.get(i));
			}
			for(int i=startPos;i<=endPos;i++){
				newInterval.start=Math.min(newInterval.start,intervals.get(i).start);
				newInterval.end=Math.max(newInterval.end,intervals.get(i).end);
			}
			result.add(newInterval);
			for(int i=endPos+1;i<intervals.size();i++){
				result.add(intervals.get(i));
			}
		}
		
		return result;
	}

	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}
}
