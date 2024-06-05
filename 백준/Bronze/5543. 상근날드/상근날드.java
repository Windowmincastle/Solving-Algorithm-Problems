import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int buger1 = Integer.parseInt(br.readLine());
        int buger2 = Integer.parseInt(br.readLine());
        int buger3 = Integer.parseInt(br.readLine());

        int col1 = Integer.parseInt(br.readLine());
        int col2 = Integer.parseInt(br.readLine());


        int buger = Math.min(buger1,buger2);
        int buger_min = Math.min(buger,buger3);
        int drink_min = Math.min(col1, col2);

        int result = buger_min + drink_min - 50 ;
        System.out.println(result);


    }

}
