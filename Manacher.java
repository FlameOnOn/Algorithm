//寻找最长回文字串
public class Manacher{
	
	public static void main(String args[]){
		String s = "ababaccccccccccc" ;
		String huiWen = manacher(s) ;
		System.out.println(huiWen); 
	}

	private static String manacher(String s) {
		StringBuilder sb = new StringBuilder() ;
		StringBuilder result = new StringBuilder() ;
		sb.append("#") ;
		for (char c : s.toCharArray()){
			sb.append(c).append("#") ;
		}
		String temp = sb.toString() ;
		int length = temp.length() ;
		int p[] = new int[length] ;
		p[0] = 1 ;
		int mx = 1 ;
		int id = 0 ;
		int maxID = 0 ;
		int maxValue = 1;
		for (int i = 1 ; i < length ; i++){
			if (mx > i){
				p[i] = Math.min(p[2*id - i ], mx - i) ;
			}else{
				p[i] = 1 ;
			}
			
			for(;i+p[i]<temp.length() && i-p[i]>=0 &&temp.charAt(i+p[i]) == temp.charAt(i - p[i]);p[i]++) ;
			//System.out.println(i + " haha " + p[i]); 
			if (p[i] > maxValue){
				maxID = i ;
				maxValue = p[i] ;
			}
			if (mx < p[i] + i){
				id = i ;
				mx = p[i] + i ;
			}	
		}
		//System.out.println(id); 
		for (int j = maxID +1 - maxValue ; j < maxID + maxValue ; j++ ){
			if(sb.charAt(j) != '#')
			result.append(sb.charAt(j)) ;
		}
		return result.toString() ;
	}
	
}