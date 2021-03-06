package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class RestoreIPAddresses {
	
	public static void main(String[] args) {
		RestoreIPAddresses t=new RestoreIPAddresses();
		
		System.out.println(t.restoreIpAddresses("010010"));
	}

	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> result=new ArrayList<String>();
		restore(s,0,4,new ArrayList<String>(),result);
		return result;
	}

	private boolean restore(String s, int pos, int remain,
			ArrayList<String> posList, ArrayList<String> resultList) {
		if((s.length()-pos)>3*remain ||(s.length()-pos)<remain) return false;
		if(remain<=0){
			if(pos!=s.length()) return false;
			
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<3;i++){
				sb.append(posList.get(i));
				sb.append('.');
			}
			sb.append(posList.get(3));
			resultList.add(sb.toString());
			
			return true;
		}else{
			boolean valid=false;
			if(s.length()-pos>=1){
				posList.add(s.substring(pos,pos+1));
				if(restore(s,pos+1,remain-1,posList,resultList)){
					valid=true;
				}
				posList.remove(4-remain);
			}
			if(s.length()-pos>=2 && s.charAt(pos)!='0'){
				posList.add(s.substring(pos,pos+2));
				if(restore(s,pos+2,remain-1,posList,resultList)){
					valid=true;
				}
				posList.remove(4-remain);
			}
			if(s.length()-pos>=3  && s.charAt(pos)!='0'&& Integer.valueOf(s.substring(pos,pos+3))<=255){
				posList.add(s.substring(pos,pos+3));
				if(restore(s,pos+3,remain-1,posList,resultList)){
					valid=true;
				}
				posList.remove(4-remain);
			}
			return valid;
		}
	}
}
