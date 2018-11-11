
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
	public static void main(String args[]){
		
		int n = 12 ;
		int inDgree[] = new int[13] ;
		int topoSortResult[] = new int[13] ;
		int current = 0 ;
		int figure[][] = {{0,1,0,0,0,1,1,0,0,0,0,0,0},
				          {0,0,0,0,0,0,0,0,0,0,0,0,0},
				          {1,0,0,1,0,0,0,0,0,0,0,0,0},
				          {0,0,0,0,0,1,0,0,0,0,0,0,0},
				          {0,0,0,0,0,0,0,0,0,0,0,0,0},
				          {0,0,0,0,1,0,0,0,0,0,0,0,0},
				          {0,0,0,0,1,0,0,0,0,1,0,0,0},
				          {0,0,0,0,0,0,1,0,0,0,0,0,0},
				          {0,0,0,0,0,0,0,1,0,0,0,0,0},
				          {0,0,0,0,0,0,0,0,0,0,1,1,1},
				          {0,0,0,0,0,0,0,0,0,0,0,0,0},
				          {0,0,0,0,0,0,0,0,0,0,0,0,1},
				          {0,0,0,0,0,0,0,0,0,0,0,0,0}} ;
		int j = 0 ;
		int sum = 0 ;
		while(j < 13){
			for (int i = 0 ; i < 13 ; i++){
				sum += figure[i][j] ;
			}
			inDgree[j] = sum ;
			j++ ;
			sum = 0 ;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>() ;
		for(int i  = 0 ; i < 13 ; i++){
			if (inDgree[i] == 0)
				queue.offer(i) ;
		}
	
		while(!queue.isEmpty()){
			int curr = queue.poll() ;
			topoSortResult[current++] = curr ;
			for (int i = 0 ; i < 13 ; i++){
				if(figure[curr][i] != 0){
					inDgree[i]-- ;
					if(inDgree[i] == 0)
						queue.offer(i) ;
				}
					
			}
			
		}
		
		for (int i : topoSortResult){
			System.out.print(i + " ") ;
		}
		
	}
}
