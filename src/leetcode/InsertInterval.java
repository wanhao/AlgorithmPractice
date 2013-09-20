package leetcode;

import java.util.ArrayList;


public class InsertInterval {
	
	public static void main(String[] args) {
		InsertInterval t = new InsertInterval();
		ArrayList<Interval> result = new ArrayList<Interval>();
		result.add(new Interval(1, 5));
//		result.add(new Interval(2, 6));
//		result.add(new Interval(8, 10));
//		result.add(new Interval(15, 18));

		System.out.println(t.insert(result, new Interval(6,8)));
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		if (intervals.isEmpty()) {
			intervals.add(newInterval);
			return intervals;
		}

		ArrayList<Interval> result = new ArrayList<Interval>();
		if(newInterval.end<intervals.get(0).start){
			result.add(newInterval);
			result.addAll(intervals);
		}else if(newInterval.start>intervals.get(intervals.size()-1).end){
			result.addAll(intervals);
			result.add(newInterval);
		}else{
			boolean found = false;
			boolean insert= false;
			for (int i = 0; i < intervals.size(); i++) {
				Interval interval = intervals.get(i);
				if (!insert && interval.start <= newInterval.end
						&& newInterval.start <= interval.end) {
					found = true;
					newInterval.start = Math.min(newInterval.start, interval.start);
					newInterval.end = Math.max(newInterval.end, interval.end);
				}else{
					if(found&& !insert){
						result.add(newInterval);
						insert=true;
					}
					
					result.add(interval);
				}
			}
			
			if(!insert){
				result.add(newInterval);
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
