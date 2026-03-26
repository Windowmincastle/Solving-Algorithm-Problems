import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
    
        for (int i=0; i<tc; i++) {
        
        String[] input = br.readLine().split(" ");
        String result = "";
        
        int loopCount = Integer.parseInt(input[0]);
        String word = input[1];
        
        char[] charAry = word.toCharArray();
        
            for (int j=0; j<charAry.length; j++) {
                for (int k=0; k<loopCount; k++) {
                    result += String.valueOf(charAry[j]);
                }
            }
        
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}