package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals t = new MergeIntervals();
		ArrayList<Interval> result = new ArrayList<Interval>();
//		result.add(new Interval(1, 3));
//		result.add(new Interval(2, 6));
//		result.add(new Interval(8, 10));
//		result.add(new Interval(15, 18));

		System.out.println(t.merge(result));
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();

		if (intervals == null|| intervals.size()==0){
			return result;
		}

		Collections.sort(intervals, IntervalComp);
		Interval interval=intervals.get(0);
		int start = interval.start;
		int end = interval.end;
		for (int i=1;i<intervals.size();i++) {
			interval=intervals.get(i);
			if (interval.start <= end && start <= interval.end) {
				if (interval.start < start) {
					start = interval.start;
				}
				if (interval.end > end) {
					end = interval.end;
				}
			} else {
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		result.add(new Interval(start, end));

		return result;
	}

	static final Comparator<Interval> IntervalComp =new  Comparator<Interval>() {

		@Override
		public int compare(Interval i1, Interval i2) {
			int value = i1.start - i2.start;
			if (value != 0)
				return value;
			value = i2.end - i1.end;
			return value;
		}

	};

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
