import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine()); // 명령어 개수
        int bitSet = 0; // 비트마스킹을 위한 변수 (1~20 숫자를 표현하는 비트마스크)
        
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" "); // 명령어 입력
            String com = input[0]; // 명령어 추출
            
            if (input.length == 2) {
                int x = Integer.parseInt(input[1]);
                int bitMask = 1 << (x - 1); // x번째 숫자를 비트마스크에서 관리하기 위해 왼쪽으로 shift
                
                switch (com) {
                    case "add":
                        bitSet |= bitMask; // 해당 비트를 1로 설정 (집합에 추가)
                        break;
                    case "remove":
                        bitSet &= ~bitMask; // 해당 비트를 0으로 설정 (집합에서 제거)
                        break;
                    case "check":
                        sb.append((bitSet & bitMask) != 0 ? "1\n" : "0\n"); // 해당 비트가 1이면 집합에 존재, 0이면 존재하지 않음
                        break;
                    case "toggle":
                        bitSet ^= bitMask; // 해당 비트를 반전시킴 (존재하면 제거, 없으면 추가)
                        break;
                }
            } else if (input.length == 1) {
                switch (com) {
                    case "all":
                        bitSet = (1 << 20) - 1; // 모든 비트를 1로 설정 ({1, 2, ..., 20} 모두 포함)
                        break;
                    case "empty":
                        bitSet = 0; // 모든 비트를 0으로 설정 (공집합)
                        break;
                }
            }
        }
        
        System.out.print(sb);        
    }
}
