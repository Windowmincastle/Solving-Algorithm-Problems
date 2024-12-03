import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(br.readLine());
        
        for (int i=0; i<TC; i++){

            String[] input = br.readLine().split(" ");
            
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            //문서 중요도 
            String[] pri = br.readLine().split(" ");
            
            Queue<int[]> Q = new LinkedList<>();
            
            for( int j=0; j<N; j++){
                
                Q.add(new int[] {j,Integer.parseInt(pri[j])});

            }

            int cnt = 0; // 출력 순서
            
            while (!Q.isEmpty()){
                
                int[] cur = Q.poll(); // 현재 문서
                boolean chk = false; // 뒤에 더 중요한 문서가 잇는지 확인
                
                for (int[] doc : Q) {

                    if (doc[1] > cur [1]){ // 현재 문서의 중요도보다 높은 중요도를 가진 문서가 있다면
                        chk = true; // 더 중요한 문서가 잇다고 표시하고 break
                        break;
                    }
                }

                if (chk) { // chk가 true이면 진입
                    Q.add(cur); // 중요도가 낮으면 뒤로 이동
                } else {
                    cnt++;
                    if (cur[0] == M){
                        sb.append(cnt).append("\n"); //목표문서 출력
                        break;
                    }
                }

            }
            

        }
        System.out.print(sb);

    }
}
