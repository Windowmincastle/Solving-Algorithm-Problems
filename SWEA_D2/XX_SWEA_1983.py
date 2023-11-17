'''
11월 10일 금요일 2번째 풀이한 날, 노션에 기록함.

'''

grade = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']

T = int(input())
for tc in range(1, T + 1) :

    n, k = map(int, input().split())
    data = []

    for _ in range(n) : #이런 형태로 리스트를 추가 입력 받는것도 기억해두자
        mid , final , hwk = map(int, input().split()) # 변수 3개 한번에 좀 입력하는 습관 들이자
        total = (mid * 0.35) + (final * 0.45) + (hwk * 0.2)
        data.append(total)
        '''
        data 리스트에 각 입력되는 중간,기말,과제 점수를 비율별로 평가해서 sum_value에 담고 data 리스트에 append하면 들어온
        순서대로 총점이 추가된다.
        '''
    k_student_score = data[k-1] # 찾고자하는 k번째 학생의 점수를 저장해둔다. k-1하는 이유는 리스트가 0번째 부터이기 때문이다.
    data.sort(reverse=True)

    value = n // 10 #만약 n이 100이라면 ? 10명에게 동일한 비율 90은 9명 80명은 8명 ~~~ 왜냐? 항상 n은 10의 배수니까
    result = data.index(k_student_score) // value

    '''
    index 메서드는 해당 리스트의 value를 넣으면 그 value의 index 위치가 어딘지
    알려준다. 그러니까 동일한 비율을 줄수있는 value로 k학생의 index를 나누면? 등급이 10개니까 항상 1,2,3,4,5,6,7,8,9,10 의
    결과가 나온다 // 연산을 하면 소수점은 나오지 않기 때문이다. 만약 k 학생의 index가 85라면 등수가 85라는 말 이고
    85를 // value를 하면 8이 나온다 점수 리스트에서 8번째 index는 C0이다
    '''
    print("#%d %s" % (tc, grade[result]))