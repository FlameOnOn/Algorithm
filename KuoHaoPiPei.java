public class KuoHaoPiPei {
	public static void main(String args[]){
		
		String s = "({][(){)}{(" ;
		String s2 = "()()(({{}})){}([[[]]])" ;
		System.out.println(isMatch(s)) ;
		System.out.println(isMatch(s2)) ;
		
	}

	private static boolean isMatch(String s) {
		Stack<Character> stack = new Stack<Character>() ;
		for (int i = 0 ; i < s.length() ; i ++){
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
				stack.push(s.charAt(i));
			}else{
				if(stack.isEmpty()){
					return false;
				}else{
					char firstElement = stack.pop() ;
					if ((s.charAt(i) == ')' && firstElement == '(') || 
							(s.charAt(i) == ']' && firstElement == '[') ||
							(s.charAt(i) == '}' && firstElement == '{')){
						continue ;
					}else{
						return false ;
					}
				}
			}
		}
		
		return stack.isEmpty() ;
	}
}
