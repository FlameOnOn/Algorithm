public class InsertSort {
	public static void main(String args[]){
		int text[] = {4,5,46,4,56,45,35,6,3,6,35,6,3,35} ;
		insertSort(text) ;
		for (int i : text){
			System.out.print(i + "|") ;
		}
	}

	private static void insertSort(int[] text) {
		for (int i = 1 ; i < text.length ; i++){
			int j = i ;
			while (j > 0 && text[j] < text[j-1]){
				swap(text , j , j-1) ;
				j-- ;
			}
		}
	}

	private static void swap(int[] text, int j, int i) {
		int temp = text[i] ;
		text[i] = text[j] ;
		text[j] = temp ;
	}
}
