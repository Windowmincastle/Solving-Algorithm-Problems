import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        // cacheSize 캐시 크기,
        // cities 도시 이름 배열
        
        int time = 0; // 총 실행 시간을 저장하는 변수.
        
        LinkedList<String> cache = new LinkedList<>();
        
        // 도시 배열을 순회하며 캐시 로직을 실행한다
        for (String city : cities){
            
            //대소문자 구분하지 않으므로 모두 소문자로 통일하기.
            // 캐시에 이미 도시가 있을 경우
            //해당 도시를 현재 위치에서 제거 ( 기존 사용 흔적 삭제)
            //캐시의 가장 마지막(최근 사용 위치)에 다시 추가
            // 실행시간을 +1
            
            city = city.toLowerCase();
            
            if( cache.contains(city)){
                
                cache.remove(city);
                
                cache.addLast(city);
                
                time += 1;
            } else {
                
                if( cacheSize > 0 && cache.size() >= cacheSize){
                    
                    cache.removeFirst(); // 가장 먼저 들어온, 오래된 도시를 제거
                    
                }
                
                if(cacheSize > 0){
                    
                    cache.addLast(city); // 가장 최근 사용된 도시로 추가하기.
                
                }
                
                time += 5;
            }
            
            // else 부분
            // 캐시에 도시가 없을 경우, -> 캐시가 꽉 찬 경우, 가장 오래된 도시를 제거한다 -> 캐시 크기가 0이 아닌 경우에만 새 도시 추가->가장 최근 사용된 도시로 추가, 실행시간 +5
            
        } 
        
        
        return time;

    }
}