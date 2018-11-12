import java.util.Stack;

public class ZuichangKuohaoPipei {
	public static void main(String args[]){
		String s = "((()))()())(" ;
		String s2 = "(((()()))" ;
		String s3 = "()()()()" ;
		
		System.out.println(longestMatchedKuohao(s));
		System.out.println(longestMatchedKuohaoWithoutStack(s)) ;
		
		System.out.println(longestMatchedKuohao(s2));
		System.out.println(longestMatchedKuohaoWithoutStack(s2)) ;
		
		System.out.println(longestMatchedKuohao(s3));
		System.out.println(longestMatchedKuohaoWithoutStack(s3)) ;
	}

	// using stack, the spatial complexity is O(1)
	private static int longestMatchedKuohaoWithoutStack(String s) {
		int start = -1 ;
		int result = 0 ;
		int deep = 0 ;
		for (int i = 0 ; i < s.length() ; i++){
			if (s.charAt(i) == '('){
				deep++ ;
			}else{
				if(deep == 0){
					start = i ;
					continue ;
				}else{
					deep-- ;
					if(deep == 0){
						result = Math.max(result, i - start) ;
					}else{
						result = Math.max(result, i - deep+1) ;
					}
				}
			}
		}
		
		
		return result ;
	}

	// using stack, the spatial complexity is O(N)
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
