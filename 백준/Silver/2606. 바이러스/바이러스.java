import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        
        visited = new boolean[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < E; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        dfs(1);
        
        System.out.println(count - 1); // 1번 컴퓨터를 제외한 감염된 컴퓨터의 수
    }

    public static void dfs(int node) {
        visited[node] = true;
        count++;
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
