import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5; // 캐시가 없으면 전부 miss
        
        int totalTime = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            String lowerCity = city.toLowerCase();

            if (cache.contains(lowerCity)) {
                // cache hit
                cache.remove(lowerCity);
                cache.addFirst(lowerCity);
                totalTime += 1;
            } else {
                // cache miss
                if (cache.size() >= cacheSize) {
                    cache.removeLast(); // LRU 제거
                }
                cache.addFirst(lowerCity);
                totalTime += 5;
            }
        }

        return totalTime;
    }
}
