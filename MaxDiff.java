//给定一个无序的整数数组，第i个元素只能和其右边的元素进行比较，按照这种方式数组中两个元素之间的最大差
public class MaxDiff {
	public static void main(String args[]){
		int text[] = {6,6,3,5,7,7,5,4,7,7,5,3,7,5,1} ;
		System.out.println(getMaxDiff(text)) ;
	}

	private static int getMaxDiff(int[] text) { // 元素只能和它右边的元素做比较，用动态规划来做，maxDiff为当前位置i之前的最大差值，max为当前位置i之前的数组中的最大值。
		int max = text[0] ;
		int maxDiff = 0 ;
		
		for (int i = 1 ; i < text.length ; i++){
			if(text[i] > max){
				maxDiff += (text[i] - max) ;
				max = text[i] ;
			}else{
				maxDiff = Math.max(maxDiff, max - text[i]) ;
			}
		}
		
		return maxDiff ;
	}
}
