package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		RestoreIPAddresses t=new RestoreIPAddresses();
		
		System.out.println(t.restoreIpAddresses("010010"));
	}

	public ArrayList<String> restoreIpAddresses(String s) {
		HashSet<String> result=new HashSet<String>();
		restore(s,0,4,new ArrayList<Integer>(),result);
		ArrayList<String> finalResult=new ArrayList<String>();
		finalResult.addAll(result);
		return finalResult;
	}

	private boolean restore(String s, int pos, int remain,
			ArrayList<Integer> posList, HashSet<String> resultList) {
		if((s.length()-pos)>3*remain ||(s.length()-pos)<remain) return false;
		if(remain<=0){
			if(pos!=s.length()) return false;
			
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<3;i++){
				sb.append(Integer.valueOf(s.substring(posList.get(i),posList.get(i+1))));
				sb.append('.');
			}
			sb.append(Integer.valueOf(s.substring(posList.get(3),s.length())));
			resultList.add(sb.toString());
			
			return true;
		}else{
			boolean valid=false;
			if(s.length()-pos>=1 && Integer.valueOf(s.substring(pos,pos+1))<=255){
				posList.add(pos);
				if(restore(s,pos+1,remain-1,posList,resultList)){
					valid=true;
				}
				posList.remove(4-remain);
			}
			if(s.length()-pos>=2 && Integer.valueOf(s.substring(pos,pos+2))<=255){
				posList.add(pos);
				if(restore(s,pos+2,remain-1,posList,resultList)){
					valid=true;
				}
				posList.remove(4-remain);
			}
			if(s.length()-pos>=3 && Integer.valueOf(s.substring(pos,pos+3))<=255){
				posList.add(pos);
				if(restore(s,pos+3,remain-1,posList,resultList)){
					valid=true;
				}
				posList.remove(4-remain);
			}
			return valid;
		}
	}
}
