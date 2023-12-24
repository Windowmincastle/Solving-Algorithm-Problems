'''
첫 풀이 : 12월 25일 월요일 크리스마스

'''
import sys
from itertools import combinations
sys.stdin=open('input.txt','r')

N,M = map(int,input().split())
K = list(map(int,input().split()))
dic = {}
cnt = 0

for i in range(1,N+1):
    dic[i] = K[i-1]

for combo in combinations(dic.keys(),2):

    key1,key2 = combo
    v1,v2 = dic[key1],dic[key2]

    if v1 == v2:
        continue
    else:
        cnt += 1

print(cnt)