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
		
		System.out.println("ggggggggggggggg" + preStart + " " + preEnd + " " + inStart + " " + inEnd) ;
		if(preStart == preEnd && inStart == inEnd){
			System.out.println("haha" + preStart + " " + preEnd + " " + inStart + " " + inEnd) ;
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
		System.out.println("root is " + temp + " left tree length is " + next_leftChildTree_length) ;
		int next_rightChildTree_length = inEnd - temp ;  //右子树长度
		System.out.println("root is " + temp + " right tree length is " + next_rightChildTree_length) ;
		
		if (next_leftChildTree_length > 0){
			System.out.println("enter left tree " + temp) ;
			inPreToPost(pre , in , preStart+1 , preStart + next_leftChildTree_length , inStart , temp-1) ;
			System.out.println("leave left tree " + temp) ;
		}
		
		System.out.println("walalaallalalalalaal " + temp) ;
		
		if (next_rightChildTree_length > 0){
			System.out.println("enter right tree " + temp) ;
			inPreToPost(pre , in , preStart + 1 + next_leftChildTree_length , inEnd , temp+1 , inEnd) ;
			System.out.println("leave right tree " + temp) ;
		}
		
		System.out.println("reached herereached herereached herereached herereached herereached here") ;
		post[index] = root ;
		index++ ;
	}

}
/*
ggggggggggggggg0 7 0 7
test 4
root is 4 left tree length is 4
root is 4 right tree length is 3
enter left tree 4
ggggggggggggggg1 4 0 3
test 1
root is 1 left tree length is 1
root is 1 right tree length is 2
enter left tree 1
ggggggggggggggg2 2 0 0
haha2 2 0 0
leave left tree 1
walalaallalalalalaal 1
enter right tree 1
ggggggggggggggg3 3 2 3
test 3
root is 3 left tree length is 1
root is 3 right tree length is 0
enter left tree 3
ggggggggggggggg4 4 2 2
haha4 4 2 2
leave left tree 3
walalaallalalalalaal 3
reached herereached herereached herereached herereached herereached here
leave right tree 1
reached herereached herereached herereached herereached herereached here
leave left tree 4
walalaallalalalalaal 4
enter right tree 4
ggggggggggggggg5 7 5 7
test 6
root is 6 left tree length is 1
root is 6 right tree length is 1
enter left tree 6
ggggggggggggggg6 6 5 5
haha6 6 5 5
leave left tree 6
walalaallalalalalaal 6
enter right tree 6
ggggggggggggggg7 7 7 7
haha7 7 7 7
leave right tree 6
reached herereached herereached herereached herereached herereached here
leave right tree 4
reached herereached herereached herereached herereached herereached here
A |E |F |D |H |Z |M |G |
*/
