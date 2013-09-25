package practice;


public class Clockwisewalk {

	public static void main(String[] args) {
		Clockwisewalk t=new Clockwisewalk();
		System.out.println(t.clockwise(5));
	}
	
	static String clockwise(int size) {
		int[][] array=new int[size][size];
		int i=size/2, j=size/2, next=1, max=size*size, len=1;
		while(next<=max){
			
			for(;i<size/2+len/2;i++){
				array[i][j]=next++;
			}
			
			for(;j>size/2-len/2;j--){
				array[i][j]=next++;
			}
			
			for(;i>size/2-len/2;i--){
				array[i][j]=next++;
			}
			
			for(;j<=size/2+len/2;j++){
				array[i][j]=next++;
			}
			len+=2;
		}

		StringBuilder sb=new StringBuilder();
		for(int x=0;x<size;x++){
			for(int y=0;y<size;y++){
				sb.append(array[x][y]);
				if(y!=size-1){
					sb.append('*');
				}
			}
			if(x!=size-1){
				sb.append('\n');
			}
		}
		return sb.toString();
    }

	/**
	7*8*9
	6*1*2
	5*4*3  
	 
	21*22*23*24*25
	20*7* 8* 9* 10
	19*6* 1* 2* 11
	18*5* 4* 3* 12
	17*16*15*14* 13
	*/
}
