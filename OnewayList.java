
public class OnewayList {
	class Node{
		public int data ;
		public Node next ;
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
	
	public void delete(int data){
		if (head == null){
			return ;
		}
		
		if(head.data == data){
			if(head.next != null){
				head = head.next ;
				
			}else{
				head = null ;
			}
			current = head ;
		}else{
			current = head ;
			while(current.next != null){
				if(current.next.data == data){
					current.next = current.next.next;
				}
				current = current.next ;
			}
		}
	}
	
	
	public static void main(String args[]){
		OnewayList list = new OnewayList() ;
		for (int i = 0 ; i < 10 ; i++){
			list.add(i);
		}
		for (int i = 0 ; i < 10 ; i++){
			list.add(i);
		}
		list.print(list.head) ;
		list.delete(5);
		System.out.println() ;
		list.print(list.head);
	}
}

