
public class ListCommonNode {
	public static void main(String args[]){
		OnewayList list1 = new OnewayList() ;
		OnewayList list2 = new OnewayList() ;
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(5);
		list1.add(7);
		list1.add(8);
		
		list2.add(4);
		list2.add(5);
		list2.add(7);
		list2.add(8);
		
		list1.print(list1.head);
		System.out.println(); 
		list2.print(list2.head);
		System.out.println(); 
		
		Node node = findFirstCommonNode(list1 , list2) ;
		if(node != null){
			System.out.println(node.data); 
		}else{
			System.out.println("no common node");
		}
		
	}

	private static Node findFirstCommonNode(OnewayList list1, OnewayList list2) {
		
		int m = list1.size() ;
		int n = list2.size() ;
		list1.current = list1.head ;
		list2.current = list2.head ;
		for (int i = 0 ; i < (m - n) ; i ++)
			list1.current = list1.current.next ;
		
		for (int i = 0 ; i < n ; i++){
			if (list1.current.data == list2.current.data){
				return list1.current ;
			}else{
				list1.current = list1.current.next ;
				list2.current = list2.current.next ;
			}
		}
		return null;
	}
	
}
