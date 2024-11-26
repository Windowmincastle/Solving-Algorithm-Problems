import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

//  문제 유형 : 구현
//  문제 난이도 : 브론즈 2

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {

            String[] str = br.readLine().split(" "); // 공백을 분리해서 String 배열에 저장하기
            // 3 abc
            // 4 cdf
            // 5 3434 이런거 짤라서 저장하는것 각 테스트 케이스 마다.

            int R = Integer.parseInt(str[0]); // 반복 횟수 String -> int형으로 변환하기

            String word = str[1];

            for (int j = 0; j < word.length(); j++) {

                // str[1]의 문자를 word에 할당하고 반복문으로 charAt으로 반복횟수만큼 출력하기.

                for (int k = 0; k < R; k++) {

                    System.out.print(word.charAt(j));

                }


            }
            System.out.println();

        };


    }

}
