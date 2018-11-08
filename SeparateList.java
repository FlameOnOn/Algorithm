//给定链表和一个数字x，将链表划分成两部分，使得划分后小于x的节点在前，大于等于x的节点在后，在这两部分中要保持原链表中的出现顺序。
//其实这就是快速排序的链表实现。说明，快排对于单链表存储结构仍然适用。

public class SeparateList {
	public static void main(String args[]){
		OnewayList list = new OnewayList() ;
		list.add(1);
		list.add(8);
		list.add(2);
		list.add(2);
		list.add(9);
		list.add(7);
		list.add(3);
		list.add(5);
		list.add(8);
		list.add(1);
		list.add(4);
		
		list.print(list.head);
		System.out.println() ;
		int pivot = 5 ;
		separateList(list , pivot) ;
		list.print(list.head);
		
	}

	private static void separateList(OnewayList list, int pivot) {
		Node leftHead = new Node(0) ;
		Node rightHead = new Node(0) ;
		Node leftCurrent = leftHead ;
		Node rightCurrent = rightHead ;
		list.current = list.head ;
		while(list.current != null){
			if(list.current.data < pivot){
				leftCurrent.next = list.current ;
				leftCurrent = list.current;
				list.current.next = null ;
			}else{
				rightCurrent.next = list.current ;
				rightCurrent = list.current ;
				list.current = null ;
			}
			
			list.current = list.current.next ;
		}
		leftCurrent.next = rightHead.next;
		rightCurrent = null ;
		list.head = leftHead.next ;
	}
	
	
	
	
}

