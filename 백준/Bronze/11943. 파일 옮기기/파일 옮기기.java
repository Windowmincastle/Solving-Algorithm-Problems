import java.util.*;
import java.io.*;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int A = sc.nextInt();
            int B = sc.nextInt();

            int C = sc.nextInt();
            int D = sc.nextInt();
            sc.close();

//            A B 사과 , C D 오렌지
            System.out.println(Math.min(A + D, B + C));

        }
}