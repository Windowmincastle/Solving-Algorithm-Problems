import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
        int[] days = new int[len];
        
        for (int i=0; i<len; i++){
            days[i] = (int) Math.ceil( (double) (100 - progresses[i]) / speeds[i]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        queue.add(days[0]); // 첫번째 기능의 배포 예상일을 넣기
        int count = 1; // 현재 배포될 기능 개수
        
        for (int i=1; i<len; i++){
            //앞의 기능이 배포될 떄 함께 배포 가능.
            if(queue.peek() >= days[i]){
                count++;
            } else {
                //새로운 배포 시작
                result.add(count);
                queue.poll();
                queue.add(days[i]);
                count = 1;
            }
        }
        
        result.add(count);
        
        return result.stream().mapToInt(i->i).toArray();
    }
}