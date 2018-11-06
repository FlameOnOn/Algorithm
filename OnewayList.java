
public class OnewayList {
	class Node{
		private int data ;
		private Node next ;
		public Node(int data){
			this.data = data ;
		}
	}
	
	public Node head ;
	public Node current ;
	
	public void add(int data){
		Node node = new Node(data) ;
		if (head == null){
			head = node ;
			current = head ;
		}else{
			current.next = node ;
			current = current.next ;
		}
	}
	
	public void print(Node node){
		if (node == null)
			return ;
		current = node ;
		while(current != null){
			System.out.print(current.data);
			current = current.next;
		}
	}
	
	public static void main(String args[]){
		OnewayList list = new OnewayList() ;
		for (int i = 0 ; i < 10 ; i++){
			list.add(i);
		}
		list.print(list.head) ;
	}
}
