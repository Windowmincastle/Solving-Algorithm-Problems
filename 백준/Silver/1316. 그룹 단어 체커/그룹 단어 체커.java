import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

//  문제 유형 : 구현
//  문제 난이도 : 실버 5
//  문제 풀이 시간 : 1 시간 잡기.
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine()); // 단어 개수
        int cnt = 0; // 그룹 단어 개수

        for (int i = 0; i < n; i++) {

            String word = br.readLine();

            if (isGroupWord(word)) {

                cnt++;

            }


        }


        System.out.println(cnt);
    }

    public static boolean isGroupWord(String word){

        Set<Character> check = new HashSet<>(); // 등장한 문자를 기록.

        char prev = '\0'; // 이전 문자 초기화 초기값은 null 문자로 두기.

        for (char current : word.toCharArray()) {

            if (current != prev) { // 현재 문자랑 이전문자가 같지 않다면.

                if (check.contains(current)) { //이미 등장한 문자라면 그룹 단어가 아니다.
                    return false;
                } // 체크리스트에 존재하지 않는다면 add하기
                
                check.add(current); // 현재 문자 기록

            }

            prev = current; // 이전 문자를 갱신.
        }

        return true; // 조건위반이 없으면 그룹단어이므로 true를 반환하기.
    }

}
