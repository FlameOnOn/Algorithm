import java.util.Random;

public class ReverseList {
	public static void main(String args[]){
		OnewayList list = new OnewayList() ;
		for (int i = 0 ; i < 10 ; i++){
			list.add(new Random().nextInt(100));
		}
		
		list.print(list.head);
		System.out.println();
		int begin = 3 ; 
		int end = 5 ;
		reverseList(list , begin , end) ;
		System.out.println(list.size());
		//list.print(list.head);
	}

	private static void reverseList(OnewayList list, int begin, int end) {
		if (list.size() == 0 ||begin <= 0 || end < begin 
				|| begin >list.size() || begin == end)
			return;
		
		if (end > list.size())
			end = list.size() ;
		Node node = new Node(0) ;
		node.next = list.head ;
		list.current = node ;
		for (int i = 0 ; i < begin-1 ; i++){
			list.current = list.current.next ;
		}
			
		Node temp = list.current.next ;
		for (int i = 0 ; i <= (end - begin) ; i++){
			Node nexttemp = temp.next ;
			temp.next = list.current.next;
			list.current.next = temp ;
			temp = nexttemp ;
		}
	}
}
