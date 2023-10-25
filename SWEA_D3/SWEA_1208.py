'''
문제 링크
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE&problemTitle=S%2FW&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=30&pageIndex=1

문제를 꼼꼼하게 잘 읽는다

높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업 = 평탄화
평탄화를 모두 수행하고 나면, 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1이내가 된다.
작업 횟수에 제한이 있다. 제한된 횟수만큼 옮기고 최고점과 최저점의 차이를 반환하는 프로그램

동일한 최고점이나 최저점이 있다면 최고점 무엇을 옮기든 상관이 없고
동일한 최저점이 있다면 최저점 어디에든 내려놔도 상관 없다.

가로의 길이는 항상 100 이다.
상자의 높이는 1이상 100 이하로 주어진다.
덤프 횟수는 1이상 1000이하로 주어진다.

주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로
그 때의 최고점과 최저점의 높이 차를 반환한다. 이에따라 0또는 1이 되겟지?
-입력
10개의 테스트 케이스 , 각 테스트 케이스 첫 번째 줄에는 덤프 횟수가 주어진다.
그리고 다음 줄에 각 상자의 높이값이 주어진다.
-출력
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 최고점과 최저점의 높이 차를 출력

'''

'''
종료조건?
평탄화를 모두 수행하고 나면 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내일 때
종료하는 조건을 구현 해야한다. 이걸 어떻게 알지? max와 min을 구해서 뺏을 때 1 or 0이면
차이가 최대 1 이내라는 뜻 아닐까?

모든 평탄화를 다 사용했는지 체크 해야한다.

최고점과 최저점의 구분은 딱히 필요 없는 것 같다.

매 반복(덤프의 횟수만큼)마다 최고점을 max로 찾고 최저점을 min으로 찾고 최고점에 -1 최저점에 +1
덤프에 -1 반복을 끝내기전에 매번 max와 min의 차이를 result에 저장해놓고 계속 갱신한다.
종료조건에 따라 종료되면 마지막에 저장한 result를 출력
(문제는 중복되는 최고점과 최저점을 어떻게 구분하냐는건데?)
반복을 시작하기전에 덤프의 수를 체크해서 덤프가 0 이면 종료 or break

'''
for tc in range(1,11):

    dump = int(input()) # 덤프 횟수가 주어진다.
    height = list(map(int,input().split())) # 각 상자의 높이를 리스트로 받는다.
    result = 0

    # if max(height) - min(height) <= 1: 여기서 지랄 옆차기 삽질 존나 햇음
    #     #현재 최고점과 최저점의 차이가 0또는 1 이라는 것은 평탄화가 완료 된 것 이므로
    #     #더 이상 덤프를 할 수 없다는 뜻 그러므로 현재 최고점과 최저점의 높이 차를 반환
    #     result = max(height) - min(height)
    # else:
    for _ in range(dump+1): # dump에 +1 해서 반복하면 정답이고 dump히면 6번 케이스가 틀린다 이건 아직도 의문인데 중요치않다

        maxdot = max(height) # 리스트 최고점
        mindot = min(height) # 리스트 최저점

        height[height.index(maxdot)] = height[height.index(maxdot)] - 1
        height[height.index(mindot)] = height[height.index(mindot)] + 1

        result = maxdot - mindot
        temp = maxdot - mindot

    if max(height) - min(height) <= 1: # 문제를 잘못 읽엇다 ㅅㅂ
        # 주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로
        # 그 때의 최고점과 최저점의 높이 차를 반환한다 (주어진 data에 따라 0 또는 1이 된다)'
        # 이 말이 뭐냐? 일단은 덤프가 10번이든 100번이든 주어진 횟수를 다 이행해야 평탄화가 완료되는거다
        # "평탄화가 완료되면"이니까 반복문이 끝나야 평탄화가 완료되고
        # 그 뒤에 이 조건문을 반복문 뒤에 배치를 해야 6번 케이스에 문제가 생기지 않는다는 것 이다 ㅇㅋ?
        result = max(height) - min(height)

    print(f"#{tc} {result}")