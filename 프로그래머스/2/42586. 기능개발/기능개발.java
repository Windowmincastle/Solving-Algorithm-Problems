import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        // 각 작업이 완료되기까지 걸리는 일수를 계산
        int n = progresses.length;
        int[] days = new int[n];
        
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if (remain % speeds[i] != 0) day++;  // 나머지가 있으면 하루 더 필요
            days[i] = day;
        }
        
        // 배포 시뮬레이션
        int current = days[0]; // 첫 배포 기준일
        int count = 1; // 첫 기능 포함
        
        for (int i = 1; i < n; i++) {
            if (days[i] <= current) {
                // 앞 기능이 끝날 때 같이 배포 가능
                count++;
            } else {
                // 새로운 배포 시작
                result.add(count);
                count = 1;
                current = days[i];
            }
        }
        
        // 마지막 그룹 추가
        result.add(count);
        
        // 리스트를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
