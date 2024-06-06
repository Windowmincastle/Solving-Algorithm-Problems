
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int result=0;
        int count = Integer.parseInt(strs[0]);
        int[] array = new int[count];
        String[] strs1 = br.readLine().split(" ");
        for(int i=0; i<count;i++){
            array[i]=Integer.parseInt(strs1[i]);
        }
        boolean[] trueorfalse = new boolean[1001];
        Arrays.fill(trueorfalse,true);
        trueorfalse[0]=trueorfalse[1]=false;

        for(int i=2;i<=Math.sqrt(1000);i++){
            if(trueorfalse[i]){
                for(int j=i*i;j<=1000;j+=i){
                    trueorfalse[j]=false;
                }
            }
        }


        for(int i=0;i<array.length;i++){
            if(trueorfalse[array[i]]){
                result ++;
            }
        }

        System.out.println(result);
    }
}

