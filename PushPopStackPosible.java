public class PushPopStackPosible {
	public static void main(String args[]){
		String pushString = "ABCDEFG" ;
		String popString = "BAEDFGC" ;
		
		String pushString2 = "ABCD" ;
		String popString2 = "BDAC" ;
	
		System.out.println(isPossible(pushString , popString)) ;
		System.out.println(isPossible(pushString2 , popString2)) ;
	}

	private static boolean isPossible(String pushString, String popString) {
		Stack<Character> stack = new Stack<Character>() ;
		int  i = 0 ;
		int j = 0 ;
		while(i < popString.length()){
			if(!stack.isEmpty()){
				if (stack.peek() == popString.charAt(i)){
					stack.pop() ;
					i++ ;
				}else if(j != popString.length()){
					stack.push(pushString.charAt(j++));
				}else{
					return false ;
				}
			}else{
				stack.push(pushString.charAt(j++));
			}
		}
		return true ;
	}
}
