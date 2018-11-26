public class InPreToPostTree {
	public static int index = 0 ;
	public static char pre[] = "GDAFEMHZ".toCharArray() ;
	public static char in[] = "ADEFGHMZ".toCharArray() ;
	
	public static char post[] = new char[pre.length] ;
	
	public static void main(String args[]){
		
		inPreToPost(pre , in , 0 , pre.length - 1 , 0 , in.length - 1) ;
		for (char i : post)
		System.out.print(i + " |") ;
	}

	private static void inPreToPost(char[] pre, char[] in, int preStart, int preEnd, int inStart,
			int inEnd) {
		
		char root = pre[preStart] ;
		
		if(preStart == preEnd && inStart == inEnd){
			post[index] = root ;
			index++ ;
			return ;
		}
		
		int temp = 0 ; 
		for(temp = inStart ;temp <= inEnd ; temp++){
			if(in[temp] == root)
				break ;
		}
		System.out.println("test " + temp) ;
		int next_leftChildTree_length = temp - inStart ; // 左子树长度
		int next_rightChildTree_length = inEnd - temp ;  //右子树长度
		
		if (next_leftChildTree_length > 0){
			inPreToPost(pre , in , preStart+1 , preStart + next_leftChildTree_length , inStart , temp-1) ;
		}
		if (next_rightChildTree_length > 0){
			inPreToPost(pre , in , preStart + 1 + next_leftChildTree_length , inEnd , temp+1 , inEnd) ;
		}
		post[index] = root ;
		index++ ;
	}

}
