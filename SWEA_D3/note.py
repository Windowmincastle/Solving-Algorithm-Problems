import sys
sys.stdin = open('input.txt','r')

T=10
for tc in range(1,T+1):
    n = int(input())  # 원본 암호문의 길이를 입력받습니다.
    code = list(map(int, input().split()))  # 원본 암호문을 공백을 기준으로 나누어 리스트로 변환합니다.
    m = int(input())  # 명령어의 개수를 입력받습니다.
    commands = list(input().split())  # 명령어를 공백을 기준으로 나누어 리스트로 변환합니다.
    i = 0  # 명령어 리스트를 순회하기 위한 인덱스를 초기화합니다.
    while i < len(commands):
        if commands[i] == 'I':  # 명령어가 'I'인 경우
            x, y = map(int, (commands[i+1], commands[i+2]))  # 삽입할 위치(x)와 숫자 개수(y)를 가져옵니다.
            s_numbers = list(map(int, commands[i+3:i+3+y]))  # 숫자들을 가져와 리스트로 변환합니다.
            code[x:x] = s_numbers  # 원본 암호문의 x 위치에 y 개의 숫자를 삽입합니다.
            i += 3 + y  # 명령어 인덱스를 갱신합니다.
        else:
            i += 1  # 'I' 명령어가 아닌 경우 다음 명령어로 이동합니다.

    result = ' '.join(map(str, code[:10]))  # 결과를 출력할 형식으로 변환합니다.
    print(f'#{tc} {result}')