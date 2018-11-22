public class HollandFlag {
	public static void main(String args[]){
		int text[] = {1,3,1,2,3,3,1,2,3,1,3,2,3,2,3,1} ;
		getHollanFlag(text) ;
		for (int i : text){
			System.out.print(i + "|") ;
		}
	}
        //或者用快速排序的partition思想，两次partition就可以搞定荷兰国旗，能保证算法时间复杂度是nlogn的
	private static void getHollanFlag(int[] text) {
		int current = 0 , begin = 0 , end = text.length - 1 ;
		while(current <= end){
			if(text[current] == 1){
				swap(current , begin , text) ; 
				begin++ ;
				if(current <= begin)//// 可以是int curernt = 0,这里用current<=begin. 或者用int current=1，这里用current==begin.总之current不能落后于begin
					current++ ;
			}else if(text[current] == 3){
				swap(current , end , text) ;
				end-- ;
			}else{
				current++ ;
			}
		}
	}

	private static void swap(int current, int beginOrEnd, int[] text) {
		int temp = text[beginOrEnd] ;
		text[beginOrEnd] = text[current] ;
		text[current] = temp ;
	}
}
