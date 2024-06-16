import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

//        M , F
        Scanner input = new Scanner(System.in);
        int ans = 0;
        while (true) {
            ans = 0;
            int m = input.nextInt();
            int f = input.nextInt();

            if (m == 0 && f == 0) {
                break;
            }
            ans = m+f;
            System.out.println(ans);
        }


    }
}