import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i =0 ; i < n ; i++){
            ary[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);

        int ans = 0;
        for(int target = 0 ; target < n ; target++){

            int left = 0;
            int right = n-1;    // 음수값이 있음에 유의!

            while(true){

                // 현재 나(target)의 위치에 있는 경우
                if (left == target) {

                    left++;

                } else if (right == target) {

                    right--;

                }
                // 결과를 찾을 수 없다.
                if( left >= right) break;

                // 정렬이 되어 있으므로, 합이 더 크다면 더 작은 수와 더해주어야 하니까 왼쪽으로 움직이는 right 값을 변경
                if ( (ary[left]+ary[right]) > ary[target] ) {

                    right--;

                } else if ( (ary[left] + ary[right]) < ary[target] ) {

                    left++;

                } else {
                    //좋다의 경우는 ary[target] == ary[left]+ary[right] 인 경우 -> 즉 수 N이 다른 수 두개의 합으로 나타낼수있는 경우.
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}