public class JueDuiZhongshu {
	public static void main(String args[]){
		int text[] = {1,2,5,2,6,2,3,4,2,2,2,2} ;
		System.out.println("result is : " + getJueDuiZhongshu(text)) ;
		System.out.println("result is : " + getRegularJueDuiZhongshu(text)) ;
		System.out.println("result is : " + getRegularJueDuiZhongshuHash(text)) ;
		System.out.println("1/3 zhongshu is " + getThirdsZhongshu(text)) ;
	}


	//求出现次数大于N/K的 众数,时间复杂度为O(N)，空间复杂度为O(K),还是，必须得知道已经有超过n/k的众数，不然这个算法还是错的。
	private static String getThirdsZhongshu(int[] text) {
		int m = 0 , n = 0 ;
		int mcount = 0 , ncount = 0 ;
		
		for(int i = 0 ; i < text.length ; i++){
			if(mcount ==0){
				mcount++ ;
				m = text[i] ;
			}else if(ncount == 0){
				ncount++ ;
				n = text[i] ;
			}else if(m == text[i]){
				mcount++ ;
			}else if(n == text[i]){
				ncount++ ;
			}else{
				mcount-- ;
				ncount-- ;
			}
		}
		
		return ""+ m + " " + n ;
	}

	private static int getRegularJueDuiZhongshuHash(int[] text) {
		HashMap<Integer , Integer> hash = new HashMap<Integer, Integer>() ;
		for (int i : text){
			if(hash.get(i) == null){
				hash.put(i, 1) ;
			}else{
				hash.put(i, hash.get(i)+1) ;
			}
		}
		
		int max = 0 ;
		int index = 0 ;
		for (int i = 0 ; i < text.length ; i++){
			
			if(hash.get(text[i]) > max){
				index = text[i] ;
				max = hash.get(text[i]) ;
			}
		}
		
		return index ;
	}

	//用数组做一个哈希,因为原始text数组中的元素相差都不大，可以用数组做一个哈希，如果差的多的话，只用用真正的hash了。
	private static int getRegularJueDuiZhongshu(int[] text) {
		int result[] = new int[10] ;
		for (int i = 0 ; i < text.length ; i++){
			result[text[i]]++ ;
		}
		
		int max = 0 ; 
		int index = 0 ;
		for(int i = 0 ; i < result.length ; i++){
			if(result[i]> max){
				index = i ;
				max = result[i] ;
			}
				
		}
		return index ;
	}

	//这个算法只能应付数组中肯定有绝对众数这种情况下，如果求普通的众数，那这个就不对了。求普通的众数，可以用哈希，或者用数组，数组其实也是哈希
	private static int getJueDuiZhongshu(int[] text) {
		int count = 0 ;
		int zhongShu = 0 ;
		for (int i = 0 ; i < text.length ; i++){
			if(count == 0 || zhongShu == text[i]){
				zhongShu = text[i] ;
				count++ ;
			}
			else{
				count-- ;
			}
		}
		return zhongShu ;
	}
	
	//求出现次数大于N/K的 众数
}
