public class ErfenSearch {
	public static void main(String args[]){
		int test[] = new int[10] ;
		for(int i = 0 ; i < test.length ; i++){
			test[i] = (new Random()).nextInt(15) ;
		}
		
		int search = new Random().nextInt(15) ;
		erfenSearch(test , search) ;
	}

	// 如果有重复数据的话，找到哪个数不一定。
	private static void erfenSearch(int[] test, int search) {
		int result = -1 ;
		Arrays.sort(test);
		for (int i : test){
			System.out.print(i + " |") ;
		}
		System.out.println() ;
		
		
		int from = 0, end = test.length - 1;
		while(from <= end){
			int mid = (from + end) / 2 ;
			if(search == test[mid]){
				result = mid ;
				break;
			}else if (search > test[mid]){
				from = mid + 1 ;   // 这两个地方别忘了 +1 和 -1. 不然会死循环的。当 (from + end) / 2 = from 的时候就会死循环。 比如 from=7,end=8.
			}else{
				end = mid  - 1 ;   //
			}
			
		}
		System.out.println("the Element to be searched is: " + search + ", result is " + result) ;
	}
	
}
