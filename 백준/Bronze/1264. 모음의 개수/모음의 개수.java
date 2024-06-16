import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int cnt = 0;
            String word = sc.nextLine();

            if (word.equals("#")) {
                break;
            }

            for (int i = 0; i < word.length(); i++) {

//            a e i o u
                if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                    cnt++;
                }

                if (word.charAt(i) == 'A' || word.charAt(i) == 'E' || word.charAt(i) == 'I' || word.charAt(i) == 'O' || word.charAt(i) == 'U') {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}