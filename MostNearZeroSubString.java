import java.util.Arrays;

public class MostNearZeroSubString {
	public static void main(String args[]){
		int text[] = {1,-2,3,10,-4,7,2,-5} ;
		System.out.println("The most nearing value to 0 of text substring is " + getNearZeroValue(text)) ;
	}
	

	//如果想求0子数组本身，那排序的时候把是第几位也存上就可以了。
	private static int getNearZeroValue(int[] text) {
		int sum[] = new int[text.length + 1] ;
		sum[0] = 0 ;
		for(int i = 1 ; i < sum.length ; i++){
			sum[i] = sum[i-1] + text[i-1] ;
		}
		
		Arrays.sort(sum);
		int result = Math.abs(sum[1] - sum[0]) ;
		for(int i = 1 ; i < sum.length ; i++){
			if(Math.abs(sum[i] - sum[i-1]) < result){
				result = Math.abs(sum[i] - sum[i-1]) ;
			}
		}
		
		return result ;
	}
}
