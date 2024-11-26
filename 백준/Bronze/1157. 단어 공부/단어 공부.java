import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

//  문제 유형 : 구현
//  문제 난이도 : 브론즈 1

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //영문자의 갯수는 26개.
        int[] wordCntAry = new int[26];
        String word = br.readLine();

        //입력받은 word만큼 반복문을 돌린다.
        for (int i = 0; i < word.length(); i++) {

            //내부에서 조건을 따져서 분기하기.
            if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') {

                wordCntAry[word.charAt(i) - 97 ]++;

            } else {

                wordCntAry[word.charAt(i) - 65 ]++;

            }

        }

        int max = -1;
        char ch = '?';

        for (int i = 0; i < 26; i++) {

            if (wordCntAry[i] > max) {

                //문자열 빈도수를 체크하는 wordCntAry 배열에서 max 값 보다 큰 값이 있는지 순회 하기.
                max = wordCntAry[i];
                // 그리고 형변환해서 해당 값에 아스키코드 값 더해서 ch에 저장해주기
                ch = (char) (i + 65);
            } else if ( wordCntAry[i] == max ){
                //단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
                ch = '?'; //를 저장해서 출력해주기

            }

        }

        System.out.println(ch);

    }

}
