import java.io.*;
import java.util.*;

public class Main {
    
    static List<List<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static int[] parentAry; 
    
    static void dfs(int node) {
        
        // n번 노드로 들어왔다. 방문 처리를 해야지,
        visited[node] = true;
        // 반복문을 돌면서 n번 노드에 연결된 모든 노드에 방문해야함.
        for (int next : adj.get(node)) {
            
            // 만약에 방문 안 했으면 방문해야지, 다른 조건이 또 잇나..
            if( visited[next] == false ) {
                // 부모 배열에 등록하고, 방문을한 node가 next의 부모임.
                parentAry[next] = node;
                dfs(next);
            }
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        // 1-based 인덱스 체크를 하기위해서 +1
        visited = new boolean[n+1];
        parentAry = new int[n+1];
        
        // 노드를 만들어야지 +1 해서
        for (int i=0; i<n+1; i++) {
            adj.add(new ArrayList<>());
        }
        
        
        // 노드 입력 받기. 양방향으로 삽입.
        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        
        dfs(1);
        
        StringBuilder sb = new StringBuilder();
        
for (int i = 2; i <= n; i++) {
    sb.append(parentAry[i]).append("\n");
}
        
        System.out.println(sb.toString());
    }
}