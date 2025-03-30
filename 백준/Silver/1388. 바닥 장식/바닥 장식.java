import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력 처리: BufferedReader와 StringTokenizer를 사용하여 입력을 빠르게 읽어옴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄에서 방의 크기 N(세로)와 M(가로)를 읽어옴
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 행의 개수
        int M = Integer.parseInt(st.nextToken()); // 열의 개수
        
        // 2. 바닥 장식 정보를 저장할 2차원 char 배열 board 생성
        // 각 칸에는 '-' 또는 '|' 문자만 들어있음
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            // 각 행마다 문자열을 읽어와 char 배열로 변환하여 저장
            board[i] = br.readLine().toCharArray();
        }
        
        // 3. 판자의 수를 세기 위한 변수 count 초기화
        int count = 0;
        
        // 4. 이중 반복문을 통해 전체 board를 순회
        // (i, j) 좌표에 해당하는 칸을 검사하여 판자 하나의 시작점인지 판단
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char curr = board[i][j]; // 현재 칸의 문자를 저장 ('-' 또는 '|')
                
                // 5. 가로 판자('-')인 경우
                if (curr == '-') {
                    // 현재 칸이 가로 판자의 시작점인지 판단하는 조건:
                    // 5-1. 만약 현재 칸이 행의 맨 왼쪽(인덱스 0)이라면,
                    //     이 칸은 왼쪽에 비교할 대상이 없으므로 새로운 판자 시작.
                    // 5-2. 만약 현재 칸의 왼쪽 칸(board[i][j-1])이 '-'가 아니라면,
                    //     현재 칸은 이전 판자와 이어지지 않으므로 새로운 판자 시작.
                    if (j == 0 || board[i][j - 1] != '-') {
                        count++; // 새로운 가로 판자 발견하여 카운트 증가
                    }
                } 
                // 6. 세로 판자('|')인 경우
                else if (curr == '|') {
                    // 현재 칸이 세로 판자의 시작점인지 판단하는 조건:
                    // 6-1. 만약 현재 칸이 열의 맨 위(i==0)라면,
                    //     이 칸은 위에 비교할 대상이 없으므로 새로운 판자 시작.
                    // 6-2. 만약 현재 칸의 위쪽 칸(board[i-1][j])이 '|'가 아니라면,
                    //     현재 칸은 이전 판자와 이어지지 않으므로 새로운 판자 시작.
                    if (i == 0 || board[i - 1][j] != '|') {
                        count++; // 새로운 세로 판자 발견하여 카운트 증가
                    }
                }
            }
        }
        
        // 7. 최종적으로 세어진 판자의 수를 출력
        System.out.println(count);
    }
}
