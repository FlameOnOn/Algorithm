public class Permutation {
	public static void main(String args[]){
		String s[] = {"1" , "2" , "3" , "4"} ;
		//permutation( 0 , s) ;
		String s2[] = {"6" , "3" , "4" , "5"} ;
		sort(s2) ;
		for (String temp : s2){
			System.out.print(temp);
		}
		System.out.println();
		while(permutationNoRecursion(s2)) {
			for (String temp : s2){
				System.out.print(temp);
			}
			System.out.println();
		}
		
		
	}

	//如果元素可以比较大小，那么可以用这种方式找全排列，找到字符串最后一个升序的位置i，i和他后面的元素中最小的交换，然后后面的再升序排列，由于之前的操作，在升序操作前，i后面的肯定是降序排列的，所以反转就可以了。
	private static boolean permutationNoRecursion(String[] s2) {
		
		int i = s2.length - 2 ;
		while(i >= 0 && Integer.valueOf(s2[i]) >= Integer.valueOf(s2[i+1])){
			i-- ;
		}
		if (i < 0)
			return false ;
		int j = s2.length -1 ;
		while(Integer.valueOf(s2[i])>=Integer.valueOf(s2[j])){
			j-- ;
		}
			
		
		swap(s2 , i , j) ;
		reverse(s2 , i+1) ;
		return true ;
	}

	private static void reverse(String[] s2, int from) {
		int end = s2.length - 1 ;
		while(from < end){
			String temp = s2[from] ;
			s2[from] = s2[end] ;
			s2[end] = temp ;
			from++ ;
			end-- ;
		}
	}

	private static void sort(String[] s2) {
		int temp[] = new int[s2.length] ;
		int i = 0 ;
		int j = 0 ;
		for(String s : s2)
			temp[i++] = Integer.valueOf(s) ;
		Arrays.sort(temp);
		for (int value : temp)
			s2[j++] = ""+value ;
	}

	private static void permutation(int start, String[] s) {
		if(start == s.length-1){
			for (String each : s){
				System.out.print(each) ;
			}
			System.out.println() ;
			
			//return ;
		}
			
		for (int i = start ; i < s.length ; i++){
			    if(isDuplicatedElement(s ,start, i ))
			    	continue ;
			    	
				swap(s , i , start) ;
				permutation(start + 1 , s) ;
				swap(s , i , start) ;
			}
			
		
	}

	private static boolean isDuplicatedElement(String[] s, int start, int i) {
		for(int j = start ; j < i ; j++){
			if(s[j] == s[i])
				return true;
		}
		return false ;
	}

	private static void swap(String[] s, int start, int i) {
		String temp = s[i] ;
		s[i] = s[start] ;
		s[start] = temp ;
	}
}
