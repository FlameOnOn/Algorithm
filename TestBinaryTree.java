
public class TestBinaryTree {
	public static void main(String args[]){
		int node[] = {7,5,9,4,6,8,10} ;
		BinaryTree biTree = new BinaryTree(node) ;
		/*System.out.println(biTree.root.data);
		System.out.println(biTree.search(4).data) ;
		System.out.println(biTree.searchRecursive(biTree.root, 11));
		System.out.println(biTree.searchRecursive(biTree.root, 12));
*/
		biTree.insert(11) ;
		biTree.insertRecursive(biTree.root, biTree.root , 12) ;
		/*System.out.println(biTree.searchRecursive(biTree.root, 11).data);
		System.out.println(biTree.searchRecursive(biTree.root, 12).data);*/

		biTree.preOrder(biTree.root);
		System.out.println(); 
		biTree.postOrder(biTree.root);
		System.out.println();
		biTree.inOrder(biTree.root);
		System.out.println();
		
		biTree.delete(9) ;
		biTree.preOrder(biTree.root);
		System.out.println();
		biTree.inOrder(biTree.root);
		
	}
}
