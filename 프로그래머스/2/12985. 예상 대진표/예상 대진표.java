class Solution
{
    public int solution(int n, int a, int b)
    {
        // 라운드 초기화
        int round = 0;

        // A와 B가 같은 그룹에 속할 때까지 반복
        while (a != b) {
            // 현재 라운드 증가
            round++;

            // 다음 라운드의 참가자 번호 재배정
            // (번호 + 1) // 2를 통해 다음 라운드의 번호를 계산
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        // A와 B가 만난 라운드를 반환
        return round;
    }
}