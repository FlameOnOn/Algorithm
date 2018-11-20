public class LocalMax {
	public static void main(String args[]){
		int text[] = {3,6,2,4,6,6,3,3,5,7,4,2,5,67,7,4,6,7,4,5} ;
		System.out.println("one local max value is " + getLocalMax(text)) ;
	}

	private static int getLocalMax(int[] text) {
		int left = 0 ; 
		int right = text.length - 1 ;
		while(left < right){
			int mid = (left + right) / 2 ;
			if(text[mid] <= text[mid + 1]){
				left = mid + 1 ;
			}else{
				right = mid ;
			}
		}
		
		return text[left] ;
	}
}
