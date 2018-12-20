public class QuickSort {
	public static void main(String args[]){
		int text[] = {1,3,8,4,7,45,7,5,5,7,5,6,7,4,7,4} ;
		quickSort(text , 0 , text.length - 1) ;
		for (int i : text){
			System.out.print(i + "|") ;
		}
	}

	//快速排序一定要從右邊開始，http://blog.csdn.net/w282529350/article/details/50982650
	private static void quickSort(int[] text, int start, int end) {
		if (start >= end)
			return ;
		
		int i = start ; 
		int j = end ;
		int pivot = text[i] ;
		while (i != j){
			while(text[j] >= pivot && j > i){
				j-- ;
			}
			
			while(text[i] <= pivot && i < j){
				i++ ;
			}
			
			swap(text , i , j) ;
		}
		
		swap(text , start , j) ;
		quickSort(text , start , i-1) ;
		quickSort(text , j+1 , end) ;
	}

	private static void swap(int[] text, int i, int j) {
		int temp = text[i] ;
		text[i] = text[j] ;
		text[j] = temp ;
	}
}
