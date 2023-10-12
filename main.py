T = int(input())

for test_case in range(1,T+1):

    P,Q,R,S,W = map(int,input().split())

    A_Pay = P * W
    B_Pay = Q
    result = 0

    if W > R :
        B_Pay = Q + (W-R) * S
        if A_Pay > B_Pay:
            result = B_Pay
        else:
            result = A_Pay
    else:
        B_Pay = Q
        if A_Pay > B_Pay:
            result = B_Pay
        else:
            result = A_Pay

    print("#{} {}".format(test_case,result))
