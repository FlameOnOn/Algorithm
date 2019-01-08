public class Jishupaixu {
	public static void main(String args[]){
		int text[] = {2,5,3,0,2,3,0,3} ;
		int result[] = jiShuSort(text) ;
		for (int i : result)
			System.out.print(i + "|") ;
	}

	private static int[] jiShuSort(int[] text) {
		int max = getMax(text) ;
		int c[] = new int[max + 1] ;   //c数组的作用是统计text数组中元素i的个数
		int b[] = new int[text.length] ; // 数组b用来存放最终结果
		for(int i : text){
			c[i]++ ;
		}
		
		for(int i = 0 ; i < c.length-1 ; i++){ //现在数组c用来统计数组text中，小于等于i的元素个数。
			c[i+1] += c[i] ;
		}
		
		for (int i = text.length - 1 ; i >= 0 ; i--){//从最后一个元素往前循环是为了保证排序是稳定的
			b[c[text[i]]-1] = text[i] ;
			c[text[i]]-- ;
		}
		return b ;
	}

	//用选择排序找出最大值
	private static int getMax(int[] text) {
		int max = text[0] ;
		for(int i = 1 ; i < text.length ; i++){
			if (max < text[i]){
				max = text[i] ;
			}
		}
		return max;
	}
}
