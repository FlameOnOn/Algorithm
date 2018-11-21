
public class MaxSequence {
	public static void main(String args[]){
		int text[] = {1,2,3,34,56,57,58,59,60,61,99,121} ;
		System.out.println("The max length of sequence of text is " + getMaxSequence(text)) ;
	}

	private static int getMaxSequence(int[] text) {
		int resultSum = 1 ;
		int sum = 1 ;
		int from = 0 , to = 0 , fromNew = 0;
		for(int i = 1 ; i < text.length ; i++){
			if(text[i] - text[i-1] == 1){
				sum++ ;
				if(sum > resultSum){
					from = fromNew ;
					resultSum = sum ;
					to = i ;
				}
			}else{
				fromNew = i ;
				sum = 1 ;
			}
		}
		StringBuilder sb = new StringBuilder() ;
		for(int i = from ; i <= to ; i++){
			sb.append(text[i]+"|") ;
		}
		System.out.println("The sequence is " + sb);
		return resultSum ;
	}
}
