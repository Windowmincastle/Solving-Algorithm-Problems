import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 채팅 기록 수
        Set<String> users = new HashSet<>(); // 입장한 후 처음 채팅하는 사용자 저장
        int count = 0; // 곰곰티콘 사용 횟수

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                users.clear(); // 새로운 사람이 입장하면 리스트 초기화
            } else if (users.add(input)) { // 처음 등장하는 유저라면 곰곰티콘 사용
                count++;
            }
        }

        System.out.println(count);
    }
}
