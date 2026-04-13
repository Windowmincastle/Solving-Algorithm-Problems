import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 28984 알람 시계 문제
public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int hour = Integer.parseInt(input[0]);
        int min = Integer.parseInt(input[1]);

        // 45분을 더 일찍 일어나야한다.
        // min이 45보다 크다, 즉 46분 이상이라면 그냥 시간을 빼면되고 그보다 작다면
        // hour를 -1하고 60-45+min 하면되지않나?
        if (min >= 45) {
            min -= 45;
        } else {

            if (hour == 0) hour = 24;
            
            hour -= 1;
            min = 60 - 45 + min;
        }

        if (hour == -1) hour = 23;

        // 24시간인점을 고려하기 0시는 24:00임

        StringBuilder sb = new StringBuilder();
        sb.append(hour).append(" ").append(min);
        System.out.println(sb);
    }
}
