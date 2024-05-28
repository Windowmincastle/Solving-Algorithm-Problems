import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int X = input.nextInt();

        int[] ary = new int[N];

        for (int i = 0; i < N; i++) {
            
            ary[i] = input.nextInt();
        
        }

        for (int i = 0; i < N; i++) {
            if (ary[i] < X) {
                System.out.print(ary[i]+" ");
            }
        }

    }
}