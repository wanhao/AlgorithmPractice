package practice;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AllFraction {

	public static void main(String[] args) {
		AllFraction t=new AllFraction();
		System.out.println(t.getAllFraction(2,6));
	}

	public List<Fraction> getAllFraction(int m, int n){
		LinkedList<Fraction> list=new LinkedList<Fraction>();
		if(m>n || m<=0) return list;
		
		for(int p=m;p<=n;p++){
			LinkedList<Fraction> tmpList=new LinkedList<Fraction>();
			for(int q=1;q<p;q++){
				if(getGCD(p,q)==1){
					tmpList.add(new Fraction(p,q));
				}
			}
			list=mergeList(list,tmpList);
		}
		
		return list;
	}
	
	private LinkedList<Fraction> mergeList(LinkedList<Fraction> list1,
			LinkedList<Fraction> list2){
		LinkedList<Fraction> list=new LinkedList<Fraction>();
		int cmp=0;
		
		while(!list1.isEmpty() && !list2.isEmpty()){
			cmp=COMPARATOR.compare(list1.peek(), list2.peek());
			if(cmp<=0){
				list.add(list1.removeFirst());
			}else{
				list.add(list2.removeFirst());
			}
		}
		if(!list1.isEmpty()){
			list.addAll(list1);
		}
			
		if(!list2.isEmpty()){
			list.addAll(list2);
		}
		return list;
	}
	private static Comparator<Fraction> COMPARATOR=new Comparator<Fraction>(){

		@Override
		public int compare(Fraction o1, Fraction o2) {
			return o1.q*o2.p-o1.p*o2.q;
		}
		
	};
	
	private int getGCD(int x, int y){
		if(x<y) return getGCD(y,x);
		if(y==0) return x;
		return getGCD(y, x%y);
	}
	
	static class Fraction{
		int p;
		int q;
		public Fraction(int p, int q){
			this.p=p;
			this.q=q;
		}
		
		public String toString(){
			return q+"/"+p;
		}
	}
}
