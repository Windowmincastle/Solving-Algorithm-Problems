import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    // DFS: 이 메서드는 하나의 섬을 샅샅이 뒤지는 역할!
    static void dfs(int node) {
        visited[node] = true; // 1. 현재 노드 방문 처리

        // 2. 현재 노드와 연결된 친구들을 하나씩 확인
        for (int child : adj.get(node)) { 
            if (!visited[child]) { // 3. 아직 안 가본 친구라면?
                dfs(child);        // 4. 거기로 더 깊이 들어간다 (재귀)
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 주의: M번 반복해서 간선 데이터를 읽음
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        // main의 역할: 새로운 섬이 발견될 때마다 카운트하고 DFS 시작
        for (int j = 1; j <= n; j++) {
            if (!visited[j]) {
                count++; // 새 섬 발견!
                dfs(j);  // 이 섬 전체를 방문 처리하러 출발
            }
        }

        System.out.println(count);
    }
}