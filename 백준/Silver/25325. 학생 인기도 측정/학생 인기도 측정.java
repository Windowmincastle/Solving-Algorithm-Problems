import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int studentNumber = Integer.parseInt(br.readLine());
        String[] names = br.readLine().split(" ");
        
        Map<String, Integer> map = new HashMap<>();
        for (String name : names) {
            map.put(name, 0);
        }
        
        for (int j = 0; j < studentNumber; j++) {
            String[] likes = br.readLine().split(" ");
            for (String like : likes) {
                map.put(like, map.get(like) + 1);
            }
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue(); // 인기도 내림차순
                }
                return a.getKey().compareTo(b.getKey()); // 이름 오름차순
            }
        );
        
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
