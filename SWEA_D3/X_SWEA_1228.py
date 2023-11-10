import sys
sys.stdin = open('input.txt','r')
'''
노션에 정리했음..문제 너무 복잡하게 생각하지말자
첫번째 풀이 - 11월 11일 새벽
'''
T=10
for tc in range(1,T+1):
    a = int(input())  # 원본 암호문의 길이를 입력받습니다.
    b = list(map(int, input().split()))  # 원본 암호문을 공백을 기준으로 나누어 리스트로 변환합니다.
    c = int(input())  # 명령어의 개수를 입력받습니다.
    d = list(input().split())  # 명령어를 공백을 기준으로 나누어 리스트로 변환합니다.

    for i in range(len(d)):

        if d[i] == 'I':  # 명령어가 'I'인 경우

            idx = int(d[i + 1])  # 삽입할 위치(x)를 가져옵니다.
            nums = int(d[i + 2])  # 삽입할 숫자의 개수(y)를 가져옵니다.

            for j in range(nums):
                # 암호문의 idx 위치부터 y개의 숫자를 명령어에서 가져와 b 리스트에 삽입합니다.
                b.insert(idx + j , int(d[ i + 3 + j ])) # j를 증가시키며 x부터 x+y까지 삽입 , 형변환 -> 덧 붙일 문자열 index 3부터 3+j까지 가져와서 그만큼 삽입.
        else:  # 명령어가 'I'가 아닌 경우
            continue  # 다음 명령어를 처리하지 않고 계속합니다.

    # 결과를 출력합니다. 코드 리스트의 처음 10개 숫자를 출력합니다.
    print('#{} {}'.format( tc, ' '.join(map(str, b[:10]))))
