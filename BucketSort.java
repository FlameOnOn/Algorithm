public class BucketSort {
	public static void main(String args[]){
		int text[] = {2,5,3,0,2,3,0,3} ;
		bucketSort(text) ;
		for (int i : text)
			System.out.print(i + "|") ;
	}

	private static void bucketSort(int[] text) {
		int max = getMax(text) ;
		int c[] = new int[max+1] ;  // c 就是桶
		
		for(int i : text)
			c[i]++ ;
		
		int i = 0 ; 
		int j = 0 ;
		while(i < c.length){
			while(c[i]-- > 0){
				text[j++] = i ;
			}
			i++ ;
		}
		
	}

	private static int getMax(int[] text) {
		int max = text[0] ;
		for (int i = 1 ; i < text.length ; i++){
			max = Math.max(max, text[i]) ;
		}
		
		return max ;
	}
}
