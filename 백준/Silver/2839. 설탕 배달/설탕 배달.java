import java.util.Scanner;

public class Main{
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int weight=sc.nextInt();
		
		if(weight==0) {
			System.out.println(-1);
		}
		if(weight<5 && weight >0) {
			if(weight%3==0) {
				System.out.println(1);
			}else if(weight%3!=0)
				System.out.println(-1);
		}
		
		else if(weight>4) {
			for(int i=weight/5;i>=0;i--) {
				if((weight-(5*i))%3==0) {
					System.out.println(i+((weight-(5*i))/3));
					break;
				}else if((weight%5)%3!=0) {
					if(i==0) {
						System.out.println(-1);
					}
					continue;
				}
			}
		}
	}
}