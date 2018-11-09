import java.util.LinkedList;
import java.util.Queue;

//Dijkstra算法可以搞定单源点最短路径是什么的问题，但是最短路径总共有多少条，是搞不定的。
//这个程序是模拟涟漪产生的过程
//其实有点贪心算法的意思，因为到每一个节点的前一个节点的路径都保证是最短的。
public class TotalNumOfShortPath {
	public static void main(String args[]){
		int num = 16 ;
		int figure[][] = new int[16][16] ;
		figure[0][1] = figure[0][4] = 1 ;
		figure[1][0] = figure[1][5] = figure[1][2] = 1 ;
		figure[2][1] = figure[2][6] = figure[2][3] = 1 ;
		figure[3][2] = figure[3][7] = 1 ;
		figure[4][0] = figure[4][5] = 1 ;
		figure[5][1] = figure[5][4] = figure[5][6] = figure[5][9] = 1 ;
		figure[6][2] = figure[6][5] = figure[6][7] = figure[6][10] = 1 ;
		figure[7][3] = figure[7][6] = 1 ;
		figure[8][9] = figure[8][12] = 1 ;
		figure[9][8] = figure[9][10] = figure[9][13] = 1 ;
		figure[10][9] = figure[10][11] = figure[10][14] = 1 ;
		figure[11][10] = figure[11][15] = 1 ;
		figure[12][8] = figure[12][13] = 1 ;
		figure[13][9] = figure[13][12] = figure[13][14] = 1 ;
		figure[14][10] = figure[14][13] = figure[14][15] = 1 ;
		figure[15][11] = figure[15][14] = 1 ;
		int number = totalNumofShortPath(figure , num) ;
		System.out.println(number);
	}

	private static int totalNumofShortPath(int[][] figure, int num) {
		Queue<Integer> q = new LinkedList<Integer>() ;
		int stepNum[] = new int[16] ;
		stepNum[0] = 1 ;
		int step[] = new int[16] ;
		q.offer(0) ;
		
		while(!q.isEmpty()){
			int value = q.poll() ;
			for (int i = 1 ; i < num ; i++){
				if(figure[value][i] == 1){
					if (step[i] == 0 || step[i] > step[value] + 1){//在权值都相同的情况下，step[i] > step[value] + 1 这种情况不会发生。 画个例子图就知道为什么这种情况不会发生了，节点只能发现与它相连的节点。
						step[i] = step[value] + 1 ;
						stepNum[i] = stepNum[value] ;
						q.offer(i) ;
					}else if(step[i] == step[value] + 1){ //这里对于step[value] + 1 > step[i]这种情况，直接舍去这种情况，因为要求最短路径。这里是模拟涟漪的生成方式，所以前一层
						 stepNum[i] += stepNum[value] ;   //的节点只能由和它相连的更前一层的节点去发现，不可能由它后面的节点去发现。因此step[value] + 1 不可能 < step[i].（因为每个
						                                    //节点都是由与它相邻的节点去发现的，只有通过step[i]==0这种方式发现的路径才是最短路径，才是由它的前驱直接发现的，别的发现方式都要绕圈 ）
						
					}
				}
			}
		}
		return stepNum[num - 1] ;
	}
	
	
	
}
