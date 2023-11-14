import sys
sys.stdin=open('input.txt','r')
'''
SWEA D3 Magnetic
11월 11일 마그네틱 풀이 도전
'''
T = 10  # 테스트 케이스의 개수
for test_case in range(1, T + 1):  # 1부터 T까지의 테스트 케이스에 대해 반복
    N = int(input())  # 배열의 크기 N을 입력받음
    arr = [list(map(int, input().split())) for _ in range(N)]  # N개의 행을 입력받아 2차원 배열 arr을 만듦

    ans = 0  # 결과 값을 저장할 변수 초기화
    arr_t = list(zip(*arr))  # 입력받은 배열 arr의 전치행렬을 만듦

    for lst in arr_t:  # 전치행렬을 순회하면서 각 행에 대한 작업 수행
        prev = 0  # 이전 값(prev) 초기화 , idx 단위로 체크하기전에 설정해야함.
        for idx in lst:  # 현재 행에서 각 원소(idx)에 대해 반복
            if idx:  # 원소가 0이 아닌 경우 진입
                if idx == 2 and prev == 1:  # 교착 상태 조건: 현재 원소가 2이고 이전 원소가 1인 경우
                    # 19라인 -> 행 단위로 보았을 때 [1,2] 이런 상태
                    ans += 1  # 교착 상태 조건을 만족할 때 결과 변수 ans를 1 증가
                prev = idx  # 현재 원소를 이전 값(prev)으로 설정하여 교착 상태 조건을 다음 원소에서 체크하기 위함

    print(f'#{test_case} {ans}')  # 현재 테스트 케이스의 결과를 출력