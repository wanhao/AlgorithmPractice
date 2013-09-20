package leetcode;

import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		if(s==null || s.isEmpty()) return true;
		
		if((s.length()&0x01)!=0){
			return false;
		}
		
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++){
			switch(s.charAt(i)){
			case '(':
			case '{':
			case '[':
				stack.push(s.charAt(i));
				break;
			case ')':
				if(stack.isEmpty() || !stack.pop().equals('(')){
					return false;
				}
				break;
			case '}':
				if(stack.isEmpty() || !stack.pop().equals('{')){
					return false;
				}
				break;
			case ']':
				if(stack.isEmpty() || !stack.pop().equals('[')){
					return false;
				}
				break;
			default:
				return false;
			}
		}
		
		return stack.isEmpty();
	}
}
