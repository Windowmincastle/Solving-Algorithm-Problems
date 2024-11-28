import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
//  문제 유형 : 구현
//  문제 난이도 : 실버 5
//  문제 풀이 시간 : 1 시간 잡기.
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        String[] words = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for ( String word : words){

            input = input.replace(word,",");

        }
        
        System.out.println(input.length());


    }

}
