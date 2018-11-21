public class MaxSubStringSum {

	public static void main(String args[]){
		int text[] = {1,-2,3,10,-4,7,2,-5} ;
		System.out.println("The max value of subString of text is " + getMaxSubString(text));
		System.out.println("The max sum of text substring is " + getMaxSubStringDp(text)) ;
	}
	

	//用动态规划可以O(N)的时间复杂度实现。找以a[i]为结尾的最大子数组的和
	private static int getMaxSubStringDp(int[] text) {
		int sum[] = new int[text.length] ;
		int result = -1 ;
		sum[0] = text[0] ;
		int from = 0 , to = 0 ;
		for(int i = 1 ; i < text.length ; i++){
			if(sum[i-1]  > 0){
				sum[i] = sum[i-1] + text[i] ;
			}else{
				sum[i] = text[i] ;
				from = i ;
			}
			if (sum[i] > result){
				result = sum[i] ;
				to = i ;
			}
		}
		StringBuilder sb = new StringBuilder() ;
		for(int i = from ; i <= to ; i++){
			sb.append(text[i] + " ") ;
		}
		System.out.println("The max substring is " + sb.toString()) ;
		return result ;
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
