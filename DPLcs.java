import java.util.Stack;
//LCS的应用可以用来求LIS，最长递增子序列，先拍个序再去求LCS就可以了。LIS其实可以用O［nlogn］的复杂度来求出来
public class DPLcs {
	public static void main(String args[]){
		String[] x = {"A","B","C","B","D","A","B"} ;
		String[] y = {"B","D","C","A","B","A"} ;
		int xy[][] = new int[x.length + 1][y.length + 1] ;
		int length = lcs(x , y , xy) ;
		String result = lcsResult(xy , x.length , y.length , x , y) ;
		System.out.println(length);
		System.out.println(result);
	}

	private static String lcsResult(int[][] xy, int xLength, int yLength, String[] x, String[] y) {
		Stack<String> stack = new Stack<String>() ;
		int i = xLength ;
		int j = yLength ;
		while(i != 0 && j !=0){
			if(x[i-1] == y[j-1]){
				stack.push(x[i-1]) ;
				i-- ;
				j-- ;
			}else{
				if (xy[i-1][j] >= xy[i][j-1]){ // 这里可以不加等号，就是决定当左面和上面相等的时候，xy[i][j]是从它上面还是左面来的
					i-- ;
				}else{
					j-- ;
				}
			}
		}
		StringBuilder result = new StringBuilder() ;
		while(!stack.isEmpty()){
			result.append(stack.pop()) ;
		}
		return result.toString() ;
	}

	private static int lcs(String[] x, String[] y, int[][] xy) {
		
		for(int i = 1 ; i <=x.length ; i++){
			for(int j = 1 ; j <= y.length ; j++){
				if(x[i-1].equals(y[j-1])){
					xy[i][j] = xy[i-1][j-1] + 1 ;
				}else{
					xy[i][j] = Math.max(xy[i-1][j] , xy[i][j-1]) ; 
				}
			}
		}
		return xy[x.length][y.length] ;
	}
	
	
}
