//删除排序链表中的重复元素，只保留第一次出现的节点/只保留最后一次出现的节点/所有重复节点都删除掉
public class DeleteDuplicateList {
	public static void main(String args[]){
		OnewayList list = new OnewayList() ;
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(9);
		list.add(9);
		list.print(list.head);
		
		//deleteFirstDuplicateElement(list) ;
		//deleteLastDuplicateElement(list) ;
		//deleteAllDuplicateElement(list) ;
		System.out.println() ;
		list.print(list.head);
	}

	private static void deleteAllDuplicateElement(OnewayList list) {
		if (list == null)
			return ;
		Node node = new Node(0) ;
		node.next = list.head ;
		Node begin = node ;
		Node end = list.head.next ;
		int data = begin.next.data;
		boolean moveBeginFlag  = false ;
		while(end != null){
			if (data == end.data){
				begin.next = end.next ;
				end = end.next ;
				moveBeginFlag = false ;
			}else{
				if (moveBeginFlag)
					begin = begin.next ;
				end = begin.next.next ;
				data = begin.next.data ;
				moveBeginFlag = true ;
			}
		}
	}

	private static void deleteLastDuplicateElement(OnewayList list) {
		if(list == null)
			return ;
		Node begin = list.head ;
		Node end = list.head.next ;
		while(end != null){
			if (end.data == begin.data){
				begin.next = end.next ;
				end = end.next ;
			}else{
				begin = begin.next ;
				end = end.next ;
			}
		}
	}

	private static void deleteFirstDuplicateElement(OnewayList list) {
		if(list == null)
			return ;
		Node node = new Node(0) ;
		node.next = list.head ;
		Node begin = node ;
		Node end = list.head.next ;
		while(end != null){
			if (begin.next.data == end.data){
				begin.next = end ;
				end = end.next ;
			}else{
				begin = begin.next ;
				end = end.next ;
			}
		}
	}
}
