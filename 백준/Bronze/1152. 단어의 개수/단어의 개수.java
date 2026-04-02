import java.io.BufferedReader;
import java.io.InputStreamReader;

// 문제 이름 : 단어의 개수
// 문제 번호 : 1152
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();
        
        if(input.isEmpty()) {
            System.out.println(0);    
        } else {
            String[] toDivide = input.split(" ");
            System.out.println(toDivide.length);
        }
        
    }
}
