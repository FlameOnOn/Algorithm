public class ZuichangKuohaoPipei {
	public static void main(String args[]){
		String s = "((()))()())(" ;
		System.out.println(longestMatchedKuohao(s));
	}

	private static int longestMatchedKuohao(String s) {
		int start = -1 ;
		int result = 0 ;
		Stack<Integer> stack = new Stack<Integer>() ;
		for (int i = 0 ; i < s.length() ; i++){
			if(s.charAt(i) == '('){
				stack.push(i);
			}else{
				if(stack.isEmpty()){
					start = i ;
				}else{
					stack.pop() ;
					if(stack.isEmpty()){
						result = Math.max(result, i - start) ;
					}else{
						result = Math.max(result, i - stack.peek()) ;
					}
				}
			}
		}
		
		return result ;
	}
}
