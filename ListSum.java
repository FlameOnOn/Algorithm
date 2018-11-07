import java.util.Random;

public class ListSum {
	public static void main(String args[]){
		
		OnewayList list1 = new OnewayList() ;
		OnewayList list2 = new OnewayList() ;
		
		for(int i = 0 ; i < 10 ; i++){
			list1.add(new Random().nextInt(100)%10);
		}
		
		for (int i = 0 ; i < 6 ; i++){
			list2.add(new Random().nextInt(100)%10);
		}
		System.out.println("                  list1 is: ");
		list1.print(list1.head);
		System.out.println() ;
		System.out.println("                  list2 is: ");
		list2.print(list2.head);
		
		OnewayList sumList = sumOfList(list1 , list2) ;
		System.out.println() ;
		System.out.println("                   the sum of list1 and list2 is: ");
		sumList.print(sumList.head);
	}

	private static OnewayList sumOfList(OnewayList list1, OnewayList list2) {
		int result,carry = 0 ;
		OnewayList sumlist = new OnewayList() ;
		list1.current = list1.head ;
		list2.current = list2.head ;
		while(list1.current != null && list2.current != null){
			result = list1.current.data + list2.current.data + carry;
			if (result >= 10){
				carry = 1 ;
			}else{
				carry = 0 ;
			}
			result = result % 10 ;
			sumlist.add(result);
			list1.current = list1.current.next ;
			list2.current = list2.current.next ;
		}
		
		if (list1.current == null){
			while(list2.current != null){
				int subresult = list2.current.data + carry ;
				if (subresult >= 10){
					carry = 1 ;
					subresult = subresult % 10 ;
				}else{
					carry =0 ;
				}
				sumlist.add(subresult);
				list2.current = list2.current.next ;
			}
		}
		
		if (list2.current == null){
			while(list1.current != null){
				int subresult = list1.current.data + carry ;
				if (subresult >= 10){
					carry = 1 ;
					subresult = subresult % 10 ;
				}else{
					carry =0 ;
				}
				sumlist.add(subresult);
				list1.current = list1.current.next ;
			}
		}
		
		if(carry == 1){
			sumlist.add(1);
		}
		return sumlist ;
	}
}
