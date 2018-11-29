
public class Floyd {
	public static void main(String args[]){
		int[][] text = new int[8][8] ;
		for (int i = 0 ; i < text.length ; i++){
			for(int j = 0 ; j < text.length ; j++){
				if(i != j)
				text[i][j] = Integer.MAX_VALUE ;
			}
		}
		
		text[0][5] = 24 ;
		text[0][2] = 47 ;
		text[0][4] = 70 ;
		text[1][3] = 31 ;
		text[1][6] = 74 ;
		text[1][7] = 79 ;
		text[2][1] = 55 ;
		text[2][3] = 88 ;
		text[2][4] = 23 ;
		text[2][6] = 66 ;
		text[3][7] = 29 ;
		text[4][1] = 31 ;
		text[4][6] = 42 ;
		text[5][2] = 25 ;
		text[5][3] = 120 ;
		text[6][7] = 66 ;
		floyd(text) ;
		for (int i = 0 ; i < text.length ; i++){
			for (int j = 0 ; j < text.length ; j++){
				System.out.print(text[i][j] + "|");
			}
			System.out.println();
		}
	}

	private static void floyd(int[][] text) {
		for (int k = 0 ; k < text.length ; k++){
			for (int i = 0 ; i < text.length ; i++){
				for (int j = 0 ; j < text.length ; j++){
					if(text[i][j] > text[i][k] + text[k][j]){
						if(text[i][k] != Integer.MAX_VALUE && text[k][j] != Integer.MAX_VALUE){
							text[i][j] = text[i][k] + text[k][j] ;
						}
						
					}
				}
			}
		}
	}
}
