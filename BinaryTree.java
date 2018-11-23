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
	
	public boolean deleteChildless(TreeNode parent , TreeNode node){
		if(node == root){
			root = null ;
			return true ;
		}
		
		if(parent.leftNode == node){
			parent.leftNode = null ;
			return true ;
		}
		if(parent.rightNode == node){
			parent.rightNode = null ;
			return true ;
		}
		return false ;
			
	}
	
	public boolean deleteSingleSon(TreeNode parent , TreeNode node){
		TreeNode grandSon = node.leftNode == null? node.rightNode : node.leftNode ;
		if (root == node){
			root = grandSon ;
			return true ;
		}
		if (parent.leftNode == node){
			parent.leftNode = grandSon ;
			return true ;
		}
		if (parent.rightNode == node){
			parent.rightNode = grandSon ;
			return true ;
		}
		return false ;
	}
	
	public boolean delete(int value){
		if(root == null)
			return false ;
		
		TreeNode node = root ;
		TreeNode parent = root ;
		while(node != null){
			if (node.data < value){
				node = node.rightNode ;
				parent = node ;
			}else if (node.data > value){
				node = node.leftNode ;
				parent = node ;
			}else{
				break ;
			}
		}
		
		if(node == null)
			return false ;
		
		if (node.leftNode == null && node.rightNode == null)
			return deleteChildless(parent , node) ;
		else if(node.leftNode == null || node.rightNode == null)
			return deleteSingleSon(parent , node) ;
		else{
			TreeNode tempnode = node.leftNode ;    // 这里可以用直接后继，即右孩子的最左分支。也可以用直接前驱，即 左孩子的最右分支
			TreeNode tempParent = node.leftNode ;  //
			while(tempnode.rightNode != null){
				tempParent = tempnode ;
				tempnode = tempnode.rightNode ;
			}
			node.data = tempnode.data ;
			
			if(tempnode.leftNode == null)
				return deleteChildless(tempParent , tempnode) ;
			else
				return deleteSingleSon(tempParent , tempnode) ;
		}
			
		
		
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
