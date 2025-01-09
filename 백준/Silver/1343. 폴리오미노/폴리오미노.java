import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String board = sc.nextLine();

        // XXXX를 AAAA로 치환
        board = board.replace("XXXX", "AAAA");
        // XX를 BB로 치환
        board = board.replace("XX", "BB");

        // X가 남아있으면 -1 출력, 아니면 결과 출력
        if (board.contains("X")) {
            System.out.println("-1");
        } else {
            System.out.println(board);
        }
    }
}
