public class LeftRotateString {
	public static void main(String args[]){
		String s = "abcdef" ;
		System.out.println(leftRotate(s , 3)) ;
	
	}

	private static String leftRotate(String s, int i) {
		char sChar[] = s.toCharArray() ;
		reverse(sChar , 0 , i-1) ;
		reverse(sChar , i , s.length() - 1) ;
		reverse(sChar , 0 , s.length() -1) ;
		return String.valueOf(sChar) ;
	}

	private static void reverse(char[] sChar, int i, int j) {
		while(i < j){
			char temp = sChar[i] ;
			sChar[i] = sChar[j] ;
			sChar[j] = temp ;
			i++ ;
			j-- ;
		}
	}
}
