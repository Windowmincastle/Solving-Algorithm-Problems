import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 브론즈2 / 백준 2920번 / 음계 문제
public class Main {
    public static void main(String[] args) throws IOException {

        String ase  = "ascending";
        String desc = "descending";
        String mix  = "mixed";

        String aseStr = "1 2 3 4 5 6 7 8";
        String descStr = "8 7 6 5 4 3 2 1";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.equals(aseStr)) {
            System.out.println(ase);
        } else if (input.equals(descStr)) {
            System.out.println(desc);
        } else {
            System.out.println(mix);
        }

    }
}
