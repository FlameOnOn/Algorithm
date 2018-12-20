public class SelectionSort {
	public static void main(String args[]){
		int text[] = {1,4,6,23,54,78,4,7,4,7,3,6,4,7} ;
		selectionSort(text) ;
		for (int i : text){
			System.out.print(i + "|") ;
		}
	}

	private static void selectionSort(int[] text) {
		for(int i = 0 ; i < text.length ; i++){
			int min = text[i] ;
			int minIndex = i ;
			for(int j = i + 1 ; j < text.length ; j++){
				if (text[j] < min){
					min = text[j] ;
					minIndex = j ;
				}
				
				
			}
			swap(text , i , minIndex) ;
			//System.out.println("min is " + min + " index is " + minIndex) ;
		}
	}

	private static void swap(int text[] , int i, int j) {
		int temp = text[i] ;
		text[i] = text[j] ;
		text[j] = temp ;
	}
}
