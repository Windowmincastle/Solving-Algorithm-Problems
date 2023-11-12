import sys
sys.stdin=open('input.txt','r')

T = int(input())
for tc in range(1, T + 1):
    lst = list(map(int, input().split()))
    MIN = lst.copy()
    MAX = lst.copy()

    # 최솟값 M 찾기
    for i in range(len(lst)):
        for j in range(i + 1, len(lst)):
            if lst[j] != 0 and lst[i] > lst[j]:  # 바꾸려는 숫자가 더 작으면 스왑
                lst[j], lst[i] = lst[i], lst[j]  # 두 숫자 위치 바꾸기
                temp_M = int(''.join(map(str, lst)))  # 리스트를 숫자로 변환
                if temp_M < int(''.join(map(str, MIN))) and str(temp_M)[0] != '0':  # 현재까지 찾은 최솟값보다 작을 때만 업데이트
                    MIN = lst.copy()

    # 최댓값 M 찾기
    for i in range(len(lst)):
        for j in range(i + 1, len(lst)):
            if lst[j] != 0 and lst[i] < lst[j]:  # 바꾸려는 숫자가 더 크면 스왑
                lst[j], lst[i] = lst[i], lst[j]  # 두 숫자 위치 바꾸기
                temp_M = int(''.join(map(str, lst)))  # 리스트를 숫자로 변환
                if temp_M > int(''.join(map(str, MAX))):  # 현재까지 찾은 최댓값보다 크면 업데이트
                    MAX = lst.copy()

    print(f"#{tc} {int(''.join(map(str, MIN)))} {int(''.join(map(str, MAX)))}")
