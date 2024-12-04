import java.io.*;
import java.util.*;


public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[N];
        int sum = 0;
        
        for (int i=0; i<N; i++){
            
            ary[i] = Integer.parseInt(br.readLine());
            sum += ary[i];

        }
        
        // 산술 평균
        double mean = (double) sum / N;
        sb.append(Math.round(mean)).append("\n");
        
        //중앙 값
        Arrays.sort(ary);
        int median = ary[N/2];
        sb.append(median).append("\n");
        
        //최빈값.
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num : ary ){
            
            freq.put(num,freq.getOrDefault(num,0)+1);

        }

        /// 빈도 정렬
        List<Integer> modes = new ArrayList<>(freq.keySet());
        modes.sort((a,b) -> {
            int freqCompare = freq.get(b) - freq.get(a);
            
            if (freqCompare == 0 ){
                return a-b;
            }
            return freqCompare;
        
        });

        int mode = modes.get(0);

        if (modes.size() > 1 && freq.get(modes.get(0)).equals(freq.get(modes.get(1)))){

            mode = modes.get(1);

        }
        sb.append(mode).append("\n");

        //범위
        int range = ary[N - 1] - ary [0];
        sb.append(range);

        System.out.println(sb);

    }
    
}
