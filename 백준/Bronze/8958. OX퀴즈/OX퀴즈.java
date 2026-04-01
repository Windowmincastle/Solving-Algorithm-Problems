import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i=0; i<tc; i++) {

            int score = 0;
            String input = br.readLine();
            char[] toCharAry = input.toCharArray();
            int check = 0;

            for (char ox : toCharAry) {

                char o = 'O';
                char x = 'X';

                if (ox == o) {
                    score += ( 1 + check );
                    check++;
                } else if ( ox == x) {
                    check = 0;
                }
            }

            sb.append(score).append(" ");
        }
        System.out.println(sb);
    }
}
