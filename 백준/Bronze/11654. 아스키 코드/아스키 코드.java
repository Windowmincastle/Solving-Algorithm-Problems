import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char ch = input.charAt(0);
        int ascii = (int)ch;
        System.out.println(ascii);
        
    }
}
