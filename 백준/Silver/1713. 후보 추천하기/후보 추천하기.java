import java.io.*;
import java.util.*;

public class Main {

    static class Candidate {

        int num;    // 학생 번호
        int count;  // 추천 수
        int time;   // 게시된 시간 (작을수록 오래됨)

        Candidate(int num, int count, int time) {
            this.num = num;
            this.count = count;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사진틀 개수
        int total = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사진틀에 게시된 후보들
        List<Candidate> frames = new ArrayList<>();

        // 학생 번호 -> Candidate 객체
        Map<Integer, Candidate> map = new HashMap<>();

        for (int time = 0; time < total; time++) {

            int student = Integer.parseInt(st.nextToken());

            // 이미 사진틀에 있는 학생이라면 추천 수 증가
            if (map.containsKey(student)) {
                map.get(student).count++;
                continue;
            }

            // 사진틀에 자리가 있는 경우
            if (frames.size() < N) {
                Candidate c = new Candidate(student, 1, time);
                frames.add(c);
                map.put(student, c);
            } 
            // 사진틀이 꽉 찬 경우 -> 삭제 후 추가
            else {
                // 삭제 대상 탐색을 위한 기준값
                Candidate target = frames.get(0);

                for (Candidate c : frames) {
                    // 추천 수가 더 적거나
                    // 추천 수가 같고 더 오래된 경우
                    if (c.count < target.count ||
                       (c.count == target.count && c.time < target.time)) {
                        target = c;
                    }
                }

                // 삭제
                frames.remove(target);
                map.remove(target.num);

                // 새 후보 추가
                Candidate c = new Candidate(student, 1, time);
                frames.add(c);
                map.put(student, c);
            }
        }

        // 출력: 학생 번호 오름차순
        List<Integer> result = new ArrayList<>();
        for (Candidate c : frames) {
            result.add(c.num);
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (int x : result) {
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
