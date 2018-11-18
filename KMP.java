//寻找模式串在文本串中首次出现位置，KMP是一种线性时间复杂度的字符串匹配算法，模式串长度为M，时间复杂度是O(M+N),空间复杂度是O(M)
public class KMP{
	public static void main(String args[]){
		String text = "have a nice dayabaabcaba" ;
		String patten = "abaabcaba" ;
		System.out.println("The index when patten first appears in text if text contains patten: " + kmp(text , patten)); 
		
	}

	private static int kmp(String text, String patten) {
		int index = -1 ;
		char textChar[] = text.toCharArray() ;
		char pattenChar[] = patten.toCharArray() ;
		int nextPatten[] = getNextImprov(pattenChar) ;
		int i = 0 , j = 0 ;
		while(i < text.length() && j < patten.length()){
			if (j == -1 || textChar[i] == pattenChar[j]){
				i++ ;
				j++ ;
				if (j == patten.length()){
					index = i - patten.length() ;
					return index ;
				}
			}else{
				j = nextPatten[j] ;
			}
		}
		return index ;
	}

	private static int[] getNext(char[] pattenChar) {
		int nextPatten[] = new int[pattenChar.length] ;
		nextPatten[0] = -1 ;
		
		int i = 0 ;
		int k = -1 ;
		while (i < nextPatten.length -1){
			if(k== -1 || pattenChar[i] == pattenChar[k]) //其实这里比较的是p[next[i-1]]和p[i-1]是否相等。循环的时候相当于待求的p[i]不动，去循环next[k]
			{k++ ;                                       //看看哪个next[k]能和[i]相等。
			i++ ;
			nextPatten[i] = k ;
			}else{
				k = nextPatten[k] ; //循环的时候，并不是每次next[i+1]的长度看似都是next[i]的减半，或者比next[i]少很多。前缀串和后缀串是有重合的可能
				                    //自己推一下就知道这个递推关系了。
			}
		}
		return nextPatten ;
	}
	
	private static int[] getNextImprov(char[] pattenChar) {
		int nextPatten[] = new int[pattenChar.length] ;
		nextPatten[0] = -1 ;
		
		int i = 0 ;
		int k = -1 ;
		while (i < nextPatten.length -1){
			if(k== -1 || pattenChar[i] == pattenChar[k]) //其实这里比较的是p[next[i-1]]和p[i-1]是否相等。循环的时候相当于待求的p[i]不动，去循环next[k]
			{k++ ;                                       //看看哪个next[k]能和[i]相等。
			i++ ;
			nextPatten[i] = k ;
			if(pattenChar[i] == pattenChar[k])
				nextPatten[i] = nextPatten[k] ; 
			}else{
				k = nextPatten[k] ; //循环的时候，并不是每次next[i+1]的长度看似都是next[i]的减半，或者比next[i]少很多。前缀串和后缀串是有重合的可能
				                    //自己推一下就知道这个递推关系了。
			}
		}
		return nextPatten ;
	}
}