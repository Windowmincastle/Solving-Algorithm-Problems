import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 기본 요금 정보
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        // 차량별 마지막 입차 시각 (분 단위) 저장
        Map<String, Integer> inTimeMap = new HashMap<>();
        // 차량별 누적 주차 시간(분) 저장
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        // 기록 처리
        for (String rec : records) {
            String[] parts = rec.split(" ");
            String timeStr = parts[0];
            String car = parts[1];
            String action = parts[2];
            
            int hh = Integer.parseInt(timeStr.substring(0, 2));
            int mm = Integer.parseInt(timeStr.substring(3, 5));
            int time = hh * 60 + mm;
            
            if (action.equals("IN")) {
                inTimeMap.put(car, time);
            } else { // "OUT"
                int inTime = inTimeMap.remove(car);
                int parked = time - inTime;
                totalTimeMap.put(car, totalTimeMap.getOrDefault(car, 0) + parked);
            }
        }
        
        // 아직 출차하지 않은 차량들은 23:59에 출차된 것으로 처리
        int endOfDay = 23 * 60 + 59;
        for (Map.Entry<String, Integer> entry : inTimeMap.entrySet()) {
            String car = entry.getKey();
            int inTime = entry.getValue();
            int parked = endOfDay - inTime;
            totalTimeMap.put(car, totalTimeMap.getOrDefault(car, 0) + parked);
        }
        
        // 차량 번호 오름차순으로 정렬
        List<String> cars = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(cars);
        
        // 결과 배열
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            String car = cars.get(i);
            int total = totalTimeMap.get(car);
            
            if (total <= baseTime) {
                answer[i] = baseFee;
            } else {
                int extra = total - baseTime;
                int units = (extra + unitTime - 1) / unitTime;  // 올림
                answer[i] = baseFee + units * unitFee;
            }
        }
        
        return answer;
    }
}
