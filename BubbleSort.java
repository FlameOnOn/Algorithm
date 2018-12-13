
public class BubbleSort {
	public static void main(String args[]){
		int text[] = {10,4,3,6,3,6,7,2,5,8,3,5,7,3,7,9,4,7,4} ;
		bubbleSort(text) ;
		for(int i : text){
			System.out.print(i + "|") ;
		}
	}

	private static void bubbleSort(int[] text) {
		
		for (int i = 0 ; i < text.length ; i++){
			boolean hasSwapAtLeastOnce = false ;
			for (int j = 0 ; j < text.length - i - 1 ; j ++){
				if(text[j] > text[j+1]){
					int temp = text[j] ;
					text[j] = text[j+1] ;
					text[j+1] = temp ;
					hasSwapAtLeastOnce = true ;
				}
			}
			if(!hasSwapAtLeastOnce){
				break ;
			}
		}
	}
}
