import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄 입력: 신청 횟수 N, 게임 종류 game
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        char game = input[1].charAt(0);
        
        // 중복 제거용 Set
        Set<String> players = new HashSet<>();
        
        // 게임별 필요한 인원 수 (임스 포함)
        int playersNeeded;
        if (game == 'Y') playersNeeded = 2;
        else if (game == 'F') playersNeeded = 3;
        else playersNeeded = 4;
        
        // 신청자 이름 입력 받기, 중복 제거
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            players.add(name);
        }
        
        // 플레이 가능한 최대 횟수 = (중복 제거된 사람 수) / (게임에 필요한 사람 수 - 1)
        // -1은 임스를 제외한 인원 수
        int maxPlays = players.size() / (playersNeeded - 1);
        
        System.out.println(maxPlays);
    }
}
