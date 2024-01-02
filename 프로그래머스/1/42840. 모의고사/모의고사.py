def solution(answers):
    answer = []
    person = [0] * 3 # 3명의 수포자가 맞춘 개수를 넣을 리스트
    first = [1, 2, 3, 4, 5] # 1번째 수포자의 답을 넣은 리스트
    second = [2, 1, 2, 3, 2, 4, 2, 5] # 2번째 수포자의 답을 넣은 리스트
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] # 3번째 수포자의 답을 넣은 리스트

    # 맞춘 개수를 확인하는 코드
    for i in range(len(answers)):
        # 1번째 수포자는 5개의 답이 반복되므로 [i%5] 해줌
        if answers[i] == first[i % len(first)]:
            person[0] += 1
        
        # 2번째 수포자는 8개의 답이 반복되므로 [i%5] 해줌
        if answers[i] == second[i% len(second)]:
            person[1] += 1

        # 3번째 수포자는 10개의 답이 반복되므로 [i%5] 해줌
        if answers[i] == third[i % len(third)]:
            person[2] += 1

    winner = max(person) # 가장 많이 맞춘 사람의 개수를 넣는 변수

    # 가장 많이 맞춘 사람을 넣는 코드 (공동 1등이 나올 수 있으므로)
    for i in range(len(person)):
        if person[i] == winner:
            answer.append(i+1)

    return answer