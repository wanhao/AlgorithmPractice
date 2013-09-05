package leetcode;

public class ValidPalindrome {

	public static void main(String[] args) {
		ValidPalindrome t=new ValidPalindrome();
		String s="";
		System.out.println(t.isPalindrome(s)==true);

		s=",,%^@)";
		System.out.println(t.isPalindrome(s)==true);

		s=",,%a^@)";
		System.out.println(t.isPalindrome(s)==true);
		
		s=",,a%^b@)";
		System.out.println(t.isPalindrome(s)==false);

		s=",a,%a^@)";
		System.out.println(t.isPalindrome(s)==true);

	}

	public boolean isPalindrome(String s) {
		if(s==null) return false;
		if(s.isEmpty()) return true;
		
		int low=0,high=s.length()-1;
		for(;;){
			while(low<=high && !isAlphaNumeric(s.charAt(low))){
				low++;
			}
			
			while(low<=high && !isAlphaNumeric(s.charAt(high))){
				high--;
			}
			
			if(low>high){
				break;
			}else{
				if(transfer(s.charAt(low))==transfer(s.charAt(high))){
					low++;high--;
				}else{
					return false;
				}
			}
		}
		return true;
    }
	
	private char transfer(char c){
		if(c>='A' && c<='Z'){
			return (char)('a'-'A'+c);
		}else{
			return c;
		}
	}
	
	private boolean isAlphaNumeric(char c){
		if((c>='A' && c<='Z') ||(c>='a' && c<='z') || c>='0' && c<='9'){
			return true;
		}else{
			return false;
		}
	}

}
