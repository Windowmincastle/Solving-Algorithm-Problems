import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {

            String word = sc.nextLine();
            String answer ="";
            if (word.equals("END")) {
                break;
            }

            for (int i = word.length()-1; i >= 0; i--) {

                answer += word.charAt(i);
            }

            System.out.println(answer);
        }
    }

}