import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 참가자 수 (사실 문제에서는 안 씀)
        int kim = Integer.parseInt(input[1]);
        int lim = Integer.parseInt(input[2]);
        
        int round = 0;
        
        while (kim != lim) {
            kim = (kim + 1) / 2;
            lim = (lim + 1) / 2;
            round++;
        }
        
        System.out.println(round);
    }
}
