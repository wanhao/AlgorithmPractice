package codinginterview;

public class Problem3{
	public static void main(String[] args){
		//0
		int[] matrix=new int[]{1, 2, 8, 9, 2, 4, 9, 12, 4, 7, 10, 13, 6, 8, 11, 15};
		int m=4;
		int n=4;
		int value=7;
		System.out.println(findNumber(matrix,m,n,value)==true);
		
		//1
		matrix=new int[]{1, 2, 8, 9, 2, 4, 9, 12, 4, 7, 10, 13, 6, 8, 11, 15};
		m=4;
		n=4;
		value=5;
		System.out.println(findNumber(matrix,m,n,value)==false);
		
		//2
		matrix=new int[]{1, 2, 8, 9, 2, 4, 9, 12, 4, 7, 10, 13, 6, 8, 11, 15};
		m=4;
		n=4;
		value=1;
		System.out.println(findNumber(matrix,m,n,value)==true);

		//3
		matrix=new int[]{1, 2, 8, 9, 2, 4, 9, 12, 4, 7, 10, 13, 6, 8, 11, 15};
		m=4;
		n=4;
		value=15;
		System.out.println(findNumber(matrix,m,n,value)==true);
		
		//4
		matrix=new int[]{1, 2, 8, 9, 2, 4, 9, 12, 4, 7, 10, 13, 6, 8, 11, 15};
		m=4;
		n=4;
		value=0;
		System.out.println(findNumber(matrix,m,n,value)==false);
		
		//5
		matrix=new int[]{1, 2, 8, 9, 2, 4, 9, 12, 4, 7, 10, 13, 6, 8, 11, 15};
		m=4;
		n=4;
		value=16;
		System.out.println(findNumber(matrix,m,n,value)==false);
		
		//3
		matrix=null;
		m=0;
		n=0;
		value=15;
		System.out.println(findNumber(matrix,m,n,value)==false);
	}
	
	public static boolean findNumber(int[] matrix,int rows, int columns, int value) {
		if (matrix == null|| rows<=0 ||columns<=0){
			return false;
		}

		int i = 0, j = columns - 1;
		int tmp=-1;
		while (i < rows && j >= 0) {
			tmp=matrix[i*columns+j];
			if (tmp == value) {
				return true;
			} else if (tmp < value) {
				i++;
			} else {
				j--;
			}
		}
		
		return false;
	}
}