
public class FirstMissingInteger {
	public static void main(String args[]){
		int text[] = {1,3,5,6,7,8,2,9,14} ;
		System.out.println("The first missing element is " + getFirstMissingInteger(text));
	}

	//如果是用排序再二分查找得话是 nlogn + n乘以logn. 如果用hash得话，时间是O(N),空间也是O(N).下面这个是时间是
	//O(N),空间是O(1)的。
	private static int getFirstMissingInteger(int[] text) {
		int size = text.length ;
		int i = 1 ;
		while(i <= size){
			if(text[i - 1] == i){
				i++ ;
			}else if(text[i - 1] > i){
				swap(text , i - 1 , text[i-1]-1) ;
			}else if(text[i -1] < i || text[i-1] > text.length ||
					text[i-1] <= 0){
				text[i-1] = text[size - 1] ;
				size-- ;
			}
		}
		return i ;
	}

	private static void swap(int[] text, int i, int j) {
		int temp = text[i] ; 
		text[i] = text[j] ; 
		text[j] = temp ;
	}
}
