//寻找模式串在文本串中首次出现位置，KMP是一种线性时间复杂度的字符串匹配算法，模式串长度为M，时间复杂度是O(M+N),空间复杂度是O(M)
public class KMP{
	public static void main(String args[]){
		String text = "have a nice day" ;
		String patten = "abaabcaba" ;
		//System.out.println("The index when patten first appears in text if text contains patten: " + kmp(text , patten)); 
		int i[] = getNext(patten.toCharArray()) ;
		for (int x : i){
			System.out.print(x); 
		}
	}

	private static String kmp(String text, String patten) {
		char textChar[] = text.toCharArray() ;
		char pattenChar[] = patten.toCharArray() ;
		int nextPatten[] = getNext(pattenChar) ;
		return textChar.toString() ;
	}

	private static int[] getNext(char[] pattenChar) {
		int nextPatten[] = new int[pattenChar.length] ;
		nextPatten[0] = -1 ;
		
		int i = 0 ;
		int k = -1 ;
		while (i < nextPatten.length-1){
			if(k == -1 || pattenChar[ i] == pattenChar[k]){
				++i ;
				++k ;
				nextPatten[i] = k ;
			}else{
				k = nextPatten[k] ;
			}
			}
		return nextPatten ;
	}
}