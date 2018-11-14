public class Permutation {
	public static void main(String args[]){
		String s[] = {"1" , "2" , "3" , "4"} ;
		permutation( 0 , s) ;
	}

	private static void permutation(int start, String[] s) {
		if(start == s.length-1){
			for (String each : s){
				System.out.print(each) ;
			}
			System.out.println() ;
			
			//return ;
		}
			
		for (int i = start ; i < s.length ; i++){
				swap(s , i , start) ;
				permutation(start + 1 , s) ;
				swap(s , i , start) ;
			}
			
		
	}

	private static void swap(String[] s, int start, int i) {
		String temp = s[i] ;
		s[i] = s[start] ;
		s[start] = temp ;
	}
}
