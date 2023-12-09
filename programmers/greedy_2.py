'''
프로그래머스 고득점 kit 조이스틱 문제
문제 유형 : 그리디
1회 푼 data : 12월 8일 금요일
'''
# 풀이 1번
def solution(name):
    # 알파벳 변경 횟수( 상하 이동 )
    spell_move = 0
    # 커서 이동 횟수, 이름의 길이 - 1( 좌우 이동 )
    cursor_move = len(name) - 1

    for i, target in enumerate(name):
        # 알파벳 변경 횟수, 위아래 중 최소 이동 값 ( 상하 이동 )
        # ord로 target에서 A를 뺀 값 , Z에서 target을 뺀 값을 min 함수로 비교해서 최소값을 가져와서 spell_move에 저장.
        spell_move += min(ord(target) - ord('A'), ord('Z') - ord(target) + 1)
        # +1을 왜 하나? A에서 Z로 이동하는 경우를 합쳐야하기 때문에 +1을 하는듯

        # 해당 알파벳 다음부터 연속된 A 문자열 찾기
        next = i + 1 # 예를들어 TAAAJ 라면
        # 주어진 name 길이보다 작고 name[next]의 값이 'A'인 동안
        while next < len(name) and name[next] == 'A':
            next += 1 # 무브 무브 무브

        # 아래 3가지 경우 중 최소 이동 값으로 갱신
        # 1. 이전 커서 이동 값 ( 초기값 - 이름의 길이 - 1 )
        # 2. 연속된 A의 왼쪽 시작
        # 3. 연속된 A의 오른쪽 시작
        cursor_move = min([cursor_move, 2 * i + len(name) - next,
                           i + 2 * (len(name) - next)])

    # 조이스틱 조작 횟수 = 알파벳 변경 횟수( 상하 이동 ) + 커서 이동 횟수( 좌우 이동 )
    return spell_move + cursor_move
