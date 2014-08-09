package Leetcode_mergeInterval;
import java.util.*;

public class Solution {
	public static void main(String[] args){
		Interval a= new Interval(1,3);
		Interval b= new Interval(6,9);
		Interval c= new Interval(2,5);
		ArrayList<Interval> results = new ArrayList<Interval>();
		results.add(a);
		results.add(b);
		results = insert(results,c);
		for(int i = 0;i<results.size();i++){
			System.out.println(results.get(i).start+" "+results.get(i).end);

		}

	}
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> results = new ArrayList<Interval>();
		if(intervals == null||intervals.size()<=1)
			return results;
		Collections.sort(intervals, new Comparator<Interval>() {  
			@Override  
			public int compare(Interval o1, Interval o2) {  
				return o1.start - o2.start;
			}
		});  
		Interval a = intervals.get(0);
		for(int i = 1;i<intervals.size();i++){
			Interval b = intervals.get(i);
			if(b.end<a.start){
				results.add(b);
			}
			else if(a.end<b.start){
				results.add(a);
				a=b;
			}
			else{
				a = new Interval(Math.min(a.start, b.start),Math.max(a.end, b.end));

			}
		}
		results.add(a);
		return results;
	}
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> output = new ArrayList<Interval>();
		if(intervals==null||intervals.size()==0){
			output.add(newInterval);
			return output;
		}
		int index =0;
		for(int i=0;i<intervals.size();i++){
			Interval curr = intervals.get(i);
			if(curr.end<newInterval.start){
				output.add(curr);
				index++;
			}else if(newInterval.end<curr.start){
				output.add(curr);
			}else{
				newInterval = new Interval(Math.min(newInterval.start, curr.start),
						Math.max(newInterval.end, curr.end));
			}
		}

		output.add(index,newInterval);
		return output;
	}
}
