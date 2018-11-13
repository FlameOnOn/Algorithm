//求解最长公共子串，可以用递归，或者用循环和subString 和contains做。其实两者是一样的。或者用球最长公共子序列的思路，用dp做一个二维数组。
public class LongestCommonSubstring {
	public static void main(String args[]){
		String a = "ABABDBC" ;
		String b = "ABDBC" ;
		StringBuilder sResult = new StringBuilder() ;
		int length = lcsDp(a , b , sResult) ;
		System.out.println("the longest common substring of " + a + " and " +b + " is "  + sResult + ", the length is " + length) ;
	}

	private static int lcsDp(String a, String b, StringBuilder sResult) {
		int length = 0 ;
	    int indexI = 0 , indexJ = 0 ;
	    Stack<Integer> stack = new Stack<Integer>() ;
		int ab[][] = new int[a.length() + 1][b.length() + 1] ;
		int i = 1, j = 1 ;
		for (i = 1 ; i <= a.length() ; i++){
			for(j = 1 ; j <= b.length() ; j++){
				if (a.charAt(i - 1) == b.charAt(j - 1)){
					ab[i][j] = ab[i-1][j-1] + 1 ;
					if(length < ab[i][j]){
						length = ab[i][j] ;
						indexI = i ; // locate the index of the longest common substring, unlike the longest common subsequence, it is not obtained at the end of the matrix
						indexJ = j ;         // and it can be traced back easily.
					}
				}else{
					//do nothing, because the default value ab[i][j] is already 0
				}
			}
		}
		while(ab[indexI][indexJ] != 0){
			//stack.push(a.charAt(indexI - 1));   这里可以优化一下，不存数据，存索引
			stack.push(indexI - 1);
			indexI-- ;
			indexJ-- ;
		}

		while(!stack.isEmpty())
			sResult.append(a.charAt(stack.pop())) ;
		
		return length;
	}

}
