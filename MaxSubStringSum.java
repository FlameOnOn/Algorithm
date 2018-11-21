public class MaxSubStringSum {

	public static void main(String args[]){
		int text[] = {1,-2,3,10,-4,7,2,-5} ;
		System.out.println("The max value of subString of text is " + getMaxSubString(text));
	}
	

	private static int getMaxSubString(int[] text) {
		int sum[] = new int[text.length] ;
		sum[0] = text[0] ;
		for(int i = 1 ; i < sum.length ; i++){
			sum[i] = sum[i-1] + text[i] ;
		}
		
		Arrays.sort(sum);
		return sum[sum.length - 1] - sum[0] ;
	}

}
