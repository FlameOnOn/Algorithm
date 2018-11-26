
public class UnionFindSet {
	public int number ;
	public int parent[] ;
	
	public UnionFindSet(int n){
		this.number = n ;
		this.parent = new int[n] ;
		for(int i = 0 ; i < n ; i++){
			this.parent[i] = i ;
		}
	}
	
	public int find(int value){
		if(value < 0 || value > number - 1){
			return -1 ;
		}
		int root = value ;
		while(root != parent[root]){
			root = parent[root] ;
		}
		int p = value ;
		int temp ;
		while(parent[p] != root){
			temp = parent[p] ;
			parent[p] = root ;
			p = temp ;
		}
		
		return root ;
	}
	
	public void union(int i , int j){
		if (i <0 || i > number-1 || j < 0 || j > number-1)
			return ;
		
		int rootI = find(i) ;
		int rootJ = find(j) ;
		if(rootI != rootJ)
			parent[rootI] = rootJ ;
	}
	//计算无向图的联通区域有多少个，可以用并查集
	public static void main(String args[]){
		UnionFindSet ufs = new UnionFindSet(10) ;
		ufs.union(1, 2);
		ufs.union(2, 3);
		ufs.union(4, 5);
		ufs.union(5, 6);
		ufs.union(6, 7);
		ufs.union(7, 8);
		ufs.union(9, 0);
		
		int result[] = new int[10] ;
		int resultNumber = 0 ;
		for(int i = 0 ; i < 10 ; i++){
			result[ufs.find(i)]++ ;
		}
		for(int i = 0 ; i < result.length ; i++){
			if(result[i] != 0)
				resultNumber++ ;
		}
		System.out.println(resultNumber) ;
	}
}
