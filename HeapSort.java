public class HeapSort {
	public static void main(String args[]){
		int text[] = {5,6,31,6,42,6,3,7,45,67,4};
		int k = text.length ; // top K 問題, 用小頂堆解決 最大的k個數問題。
		k = 3;
		heapSort(text , k) ;
		
		for (int i : text){
			System.out.print(i + "|"); 
		}
	}

	private static void heapSort(int[] text, int k ) {
		int size = text.length ;
		for (int i = text.length / 2 - 1 ; i >= 0 ; i--){ // create the original heap.
			adjustHeap(text , i , size) ;
		}
		swap(text , 0 , size - 1) ;
		while(k > 1){
			size-- ;
			adjustHeap(text , 0, size) ;
			k-- ;
			swap(text , 0 , size - 1) ;
		}
	}

	private static void adjustHeap(int[] text, int i, int size) {
		int nchild = 2*i + 1 ;//左孩子
		while (nchild < size){
			if ((nchild + 1 < size) && (text[nchild] > text[nchild + 1])){
				nchild++ ;
			}
			
			if (text[i] < text[nchild]){
				break ;
			}else{
				swap(text , i , nchild) ;
				i = nchild ;
				nchild = nchild*2 + 1 ;
			}
		}
	}

	private static void swap(int[] text, int i, int child) {
		int temp = text[i] ;
		text[i] = text[child] ;
		text[child] = temp ;
	}
}
