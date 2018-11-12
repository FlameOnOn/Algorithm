public class ReversePolishNotation {
	public static void main(String args[]){
		String[] s = {"2" , "1" , "+" , "3" , "*"} ;
		System.out.println(reversePolish(s)) ;
	}

	private static int reversePolish(String[] s) {
		int sum = 0 ;
		Stack<String> stack = new Stack<String>() ;
		for(int i = 0 ; i < s.length ; i ++){
			if(!isOperationMark(s[i])){
				stack.push(s[i]);
			}else{
				int firstPop = Integer.parseInt(stack.pop()) ;
				int secondPop = Integer.parseInt(stack.pop()) ;
				if (s[i] == "+"){
					stack.push(""+(firstPop + secondPop));
				}else if(s[i] == "-"){
					stack.push(""+(secondPop - firstPop));
				}else if(s[i] == "*"){
					stack.push(""+(secondPop * firstPop));
				}else{
					stack.push(""+(secondPop / firstPop));
				}
			}
		}
		return Integer.parseInt(stack.peek()) ;
	}

	private static boolean isOperationMark(String string) {
		return (string.equals("+") || string.equals("*")
				|| string.equals("-") || string.equals("/")) ;
	}
}
