public class FindRotateSortedArrayMin {
	public static void main(String args[]){
		int text[] = {7,8,3,4,5,6} ;
		System.out.println("The min value of text is " + getMinOfRotateSortedArray(text));
	}

	private static int getMinOfRotateSortedArray(int[] text) {
		int low = 0 ; 
		int high = text.length - 1 ;
		int mid = -1 ;
		while(low < high){
			mid = (low + high) / 2 ;
			if(text[mid] > text[high]){
				low = mid + 1 ;
			}else{
				high = mid ;
			}
		}
		return text[low] ;
	}
}
