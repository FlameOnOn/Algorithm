
public class HanoTower {
	public static void main(String args[]){
		String a = "A" , b = "B" , c = "C" ;
		int n = 3 ;
		moveAll(a , c , b , n) ;
	}

	private static void moveAll(String a, String c, String b, int n) {
		if(n == 1){
			moveOne(a , c) ;
			return ;
		}
			
//汉诺塔的规则是每次移动不允许有大的条在小的条的上面，也就是必须保证之前的顺序不能颠倒。之前a在c底下，那不管ac在哪个
//柱子上，a还是必须在c底下。这种规则在算法中已经得到了保证： 要想把n个条移动到C上，就得先把上面那n-1个移动过去，同理
// 想要移动n-1个，必须先把上面得n－2个移动过去，这样就保证了顺序
		moveAll(a , b , c , n-1) ;
		moveOne(a , c) ;   
		moveAll(b , c , a , n-1) ;
	}

	private static void moveOne(String a, String c) {
		System.out.println(a + "➡️" + c);
	}
}
