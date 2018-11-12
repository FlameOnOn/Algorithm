//给定一个句子，要求把词的顺序调整一下，比如， I love java 变成 java love I,那就是这种思路，先是 I  evol avaj, 然后是java love I. 以空格或者tab符号
//当做分隔符来做就可以了。

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
