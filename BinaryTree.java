
public class BinaryTree {
	public TreeNode root ;
	
	public BinaryTree(int node[]){
		for (int i : node){
			insert(i) ;
		}
	}

	public boolean insert(int i) {
		TreeNode pnode = root ;
		TreeNode pcurrent = pnode ;
		if(root == null){
			TreeNode node = new TreeNode(i , null , null) ;
			root = node ;
			return true ;
		}else{
			while(pnode != null){
				pcurrent = pnode ;
				if(pnode.data > i){
					pnode = pnode.leftNode ;
				}else if(pnode.data < i){
					pnode = pnode.rightNode ;
				}else{
					return false ;
				}
			}
			
			TreeNode node = new TreeNode(i , null , null) ;
			if(i < pcurrent.data){
				pcurrent.leftNode = node ;
			}else{
				pcurrent.rightNode = node ;
			}
			return true ;
		}
	}
	
	public TreeNode search(int value){
		if(root == null)
			return null ;
		
		TreeNode node = root ;
		while(node != null){
			if(node.data == value){
				return node ;
			}else if(value < node.data){
				node = node.leftNode ;
			}else{
				node = node.rightNode ;
			}
		}
		
		return null ;
	}
	
	public TreeNode searchRecursive(TreeNode node , int value){
		if(value == node.data || node == null)
			return node ;
		else if(value > node.data)
			return searchRecursive(node.rightNode , value) ;
		else
			return searchRecursive(node.leftNode , value) ;
	}
	
	public boolean insertRecursive(TreeNode node , int value){
		if(node == null){
			node = new TreeNode(value , null , null) ;
			return true ;
		}else if(value > node.data){
			return insertRecursive(node.rightNode , value) ;
		}else if(value < node.data){
			return insertRecursive(node.leftNode , value) ;
		}
		return false ; //如果节点已经存在，就返回false。
		
	}
	
}

class TreeNode{
	public int data ; //其实这里存的可能是个别的什么大的数据结构。 如果不能比较的话，还要定义这个数据结构的比较规则。
	public TreeNode leftNode ;
	public TreeNode rightNode ;
	
	public TreeNode(int data , TreeNode leftNode , TreeNode rightNode){
		this.data = data ;
		this.leftNode = leftNode ;
		this.rightNode = rightNode ;
	}
}
