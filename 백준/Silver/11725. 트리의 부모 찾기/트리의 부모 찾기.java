import java.io.*;
import java.util.*;

public class Main {
    
    // ROOT 상수값
    static int ROOT = 1;
    // x번 노드의 부모가 누군지 기록할 배열
    static int[] parent;
    // x번 노드를 방문했는지 체크할 배열
    static boolean[] visited;
    // 트리를 표현할 인접리스트
    static List<List<Integer>> adj;
    
    public static void dfs(int cur) {
        
        visited[cur] = true;
        
        for (int nextNode : adj.get(cur)) {
            
            if(!visited[nextNode]) {
                // 그럼 내 자식이니까
                parent[nextNode] = cur; // 저장
                // 자식 집으로 가봐야 손주가 누군지 알수있다.
                dfs(nextNode);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 노드를 n-1개 만들어준다.
        adj = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            // < 비교연산자라서 0-1-2-3-4-5-6까지니까 노드는 n-1개 생성
            adj.add(new ArrayList<>());
        }
        
        //부모 배열 초기화, 왜 n+1개인지 이해가 좀 안됌 0번 idx는 안쓰려고 그런가? 
        parent  = new int[n+1];
        visited = new boolean[n+1];
        
        // 인접리스트에 그래프 저장 (양방향으로 넣기)
        for (int i=0; i<n-1; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adj.get(a).add(b);
            adj.get(b).add(a);
            
        }
        
        //dfs 호출 root부터
        dfs(ROOT);
        
        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=n; i++) {
            //문제에서 2번 노드부터 순서대로 출력하라고햇음.
            sb.append(parent[i]).append("\n");
        }
        
        System.out.print(sb);        
    }
    
    
}