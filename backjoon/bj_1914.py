'''
백준 1914 하노이탑 문제
2023년 11월 27일 리뷰
-틀렷다 다시 풀자
'''
def hanoi_f(one, three, n):
    if n == 1:
        print(one,three)
        return

    hanoi_f(one, 6-one-three, n-1) # 1단계 (1->2)
    print(one, three) # 2단계 (마지막원반 1->3)
    hanoi_f(6-one-three, three, n-1) # 3단계 (2->3)

#메인
n = int(input())
print(2**n-1) # 여기서 이렇게 출력하는 이유?
if n <= 20:
    hanoi_f(1,3,n)