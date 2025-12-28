import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 걸그룹 수
        int M = Integer.parseInt(st.nextToken()); // 문제 수

        // 팀 이름 -> 멤버 리스트
        Map<String, List<String>> teamMap = new HashMap<>();

        // 멤버 이름 -> 팀 이름
        Map<String, String> memberMap = new HashMap<>();

        // 걸그룹 정보 입력
        for (int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());

            List<String> members = new ArrayList<>();
            for (int j = 0; j < memberCount; j++) {
                String memberName = br.readLine();
                members.add(memberName);
                memberMap.put(memberName, teamName);
            }

            Collections.sort(members); // 사전순 정렬
            teamMap.put(teamName, members);
        }

        StringBuilder sb = new StringBuilder();

        // 퀴즈 처리
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if (type == 0) {
                // 팀 이름 -> 멤버 출력
                List<String> members = teamMap.get(name);
                for (String member : members) {
                    sb.append(member).append('\n');
                }
            } else {
                // 멤버 이름 -> 팀 이름 출력
                sb.append(memberMap.get(name)).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
