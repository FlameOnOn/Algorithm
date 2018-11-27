import java.util.LinkedList;

public class Dijstra {
	public static void main(String args[]){
		int max = Integer.MAX_VALUE ;
		int text[][] = {{0 , 20 , 50 , 30 , max , max , max},
				{max , 0 , 25 , max , max , 70 , max},
				{max , max , 0 , 40 ,25, 50 , max},
				{max , max , max , 0 , 55 , max , max},
				{max , max , max , max , 0 , 10 , 70},
				{max , max , max , max , max , 0 , 50},
				{max , max , max , max , max , max , 0}} ;
		
		System.out.println("the shorted path from 0 to 6 is " + dijkstra(text));
	}

	private static int dijkstra(int[][] text) {
		int dist[] = text[0] ;
		LinkedList<Integer> list = new LinkedList<Integer>() ;
		
		list.add(0) ;
		
		while(list.size() < text.length-1){
			int element = list.get(list.size()-1) ;
			int min = Integer.MAX_VALUE ;
			int minIndex = 0 ;
			for(int i = 0 ; i < text.length ; i++){
				if(dist[i] < min && dist[i] != 0 && !list.contains(i)){
					min = dist[i] ;
					minIndex = i ;
				}
			}
			list.add(minIndex) ;
			dist[minIndex] = min ;
			System.out.println("minindex is " + minIndex);
			for(int i = 0 ; i < text.length ; i++){

				if(list.contains(i))//已经加入到list中的节点就 不去计算了
					continue ;
				if(text[minIndex][i] > 0 && text[minIndex][i] < Integer.MAX_VALUE){
					System.out.println(i + " " + dist[minIndex] + " " + text[minIndex][i] + " " + dist[i]);

					if(dist[minIndex] + text[minIndex][i] < dist[i]){
						dist[i] = dist[minIndex] + text[minIndex][i] ;
					}
				}
			}
			for(int i: dist){
				System.out.print("|" + i);
			}
			System.out.println();
		}
		
		return dist[text.length - 1] ;
	}
}
