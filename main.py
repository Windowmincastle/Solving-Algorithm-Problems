def psw(data):
    while True:
        for i in range(1, 6):  # 1~5 5번 1사이클
            n = data.pop(0)  # 리스트의 start를 pop하고 저장.
            data.append(n - i)  # n을 i만큼 빼고, 리스트의 end에 삽입

            # 0이 나오면?
            if data[-1] <= 0:  # 리스트의 end가 값이 0보다 작거나 같으면
                data[-1] = 0   # 음수 대비  0 변환
                return data

T = 10
for _ in range(1, T+1):

    tc = int(input())
    data = list(map(int, input().split())) # 공백을 기준으로 데이터 입력
    result = psw(data) # result에 psw return value 저장
    print('#{}'.format(tc), *result) # 리스트 변수 앞에 *을 붙여서 출력하면 괄호없이 공백 구분으로 나온다.

'''
이 문제를 보자마자 딱 봐도 큐 자료구조를 활용해서 풀어야한다는 생각을 해야한다.
pop() 메서드를 잘 쓰지않아서 미숙했다. 이참에 REPL에서 여러가지 pop의 활용을 해보자
아이디어 자체는 내가 생각한 것과 같은 것 같다. 그러나 나는 remove함수로 하려고 했는데 remove 함수는 중복 값이 있으면 문제가 생길
여지가 있는 것 같다. 

배운점 
.format() 형태로 출력하면
리스트 변수 앞에 *을 붙이면 괄호없이 공백을 구분으로 출력해준다.
f"{}"로 해봣는데 안되더라

문제를 봤을 때 이 문제의 자료구조나 무슨 알고리즘이 쓰였을까?라고도
생각을 좀 해봐야한다
그저 무식하게 문제만 이해하고 구현하려고 생각하지말자



'''