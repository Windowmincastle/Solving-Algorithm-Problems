import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();
        
        int[] ary = new int[26];
        
        // 빈도 계산
        for (int i = 0; i < input.length(); i++) {
            ary[input.charAt(i) - 'a']++;
        }
        
        int max = 0;
        char answer = '?';
        
        for (int j = 0; j < 26; j++) {
            if (ary[j] > max) {
                max = ary[j];
                answer = (char)('A' + j);
            } else if (ary[j] == max && ary[j] != 0) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}
