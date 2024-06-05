import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    //주사위 세 개
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
//        int dice1 = Integer.parseInt(bf.readLine());
//        int dice2 = Integer.parseInt(bf.readLine());
//        int dice3 = Integer.parseInt(bf.readLine());
        int dice1 = sc.nextInt();
        int dice2 = sc.nextInt();
        int dice3 = sc.nextInt();


        int money = 0;

        if ( dice1 == dice2 && dice2 == dice3) {

            //case1
            money = 10000 + dice1 * 1000;

            // 1 == 2 != 3, 2 == 3 != 1 , 1 == 3 != 2
            // case2
        } else if (dice1 == dice2 && dice2 != dice3 || dice2 == dice3 && dice2 != dice1 || dice1 == dice3 && dice1 != dice2) {
            int temp = 0;
            if (dice1 == dice2) {
                temp = dice1;
            } else if (dice2 == dice3) {
                temp = dice2;
            } else {
                temp = dice3;
            }
            money = 1000 + temp * 100;
        } else {

            int max;
            if (dice1 > dice2 && dice1 > dice3) {
                max = dice1;
            } else if (dice2 > dice1 && dice2 > dice3) {
                max = dice2;
            } else {
                max = dice3;
            }

            money = max * 100;
        }

        System.out.println(money);

    }
}
