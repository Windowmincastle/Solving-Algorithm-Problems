import java.io.*;
import java.util.*;

public class Main {
    
    // 연결된 리스트를 표현
    static List<List<Integer>> adj = new ArrayList<>();
    // 방문 체크,       
    static boolean[] visited;
    static int count = 0;
    
    static void dfs(int nodeNum) {
        
        if (visited[nodeNum] ) return; // 방문했어? 돌아가
        visited[nodeNum] = true; // 방문 안했어? 방문 처리해
        count++; // 방문했으니 횟수 올려
        
        for (Integer num : adj.get(nodeNum)) {
               dfs(num);
        }
    }
    
    public static void main (String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int compNum = Integer.parseInt(br.readLine());
        visited = new boolean[compNum+1];
        
        // compNum+1 개의 노드를 만들고 0번 인덱스를 사용하지 않겟음.
        for (int i=0; i<=compNum; i++) {
            adj.add(new ArrayList<>());
        }
        
        // 간선 정보 입력
        int link = Integer.parseInt(br.readLine());
        
        for (int j=0; j<link; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int Node  = Integer.parseInt(st.nextToken());
            int Child = Integer.parseInt(st.nextToken());
            
            adj.get(Node).add(Child);
            adj.get(Child).add(Node);
            
        }
        
        // 1번 컴퓨터가 웜 바이러스에 걸림.
        dfs(1);
        
        System.out.print(count-1);
    }
    
}