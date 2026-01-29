import java.io.*;
import java.util.StringTokenizer; // StringTokenizer를 위해 import 필요

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. readLine()으로 한 줄을 읽어와서 st에 담습니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 2. st 객체에서 데이터를 하나씩 꺼내옵니다.
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        // 3. 문제의 공식대로 출력 (괄호 주의)
        System.out.println((a + b) % c);
        System.out.println(((a % c) + (b % c)) % c); // 괄호 위치 수정
        System.out.println((a * b) % c);
        System.out.println(((a % c) * (b % c)) % c);
    }
}