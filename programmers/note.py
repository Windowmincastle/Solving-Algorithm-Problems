def solution(sizes):

    m_w = 0
    m_h = 0
    #m_w , m_h 부터 구하기 , 회전하기 전 그대로 사용한 경우
    for i in range(len(sizes)):

        if sizes[i][0] > m_w:
            m_w = sizes[i][0]

        if sizes[i][1] > m_h:
            m_h = sizes[i][1]

    # 회전한 경우의 값을 구하기
    m_w2 = 0
    m_h2 = 0

    for i in range(len(sizes)):
        if max(sizes[i]) > m_w2:  # max를 사용하여 두 경우 중 큰 값을 찾음
            m_w2 = max(sizes[i])

        if min(sizes[i]) > m_h2:  # min을 사용하여 두 경우 중 작은 값을 찾음
            m_h2 = min(sizes[i])

    min_w = min(m_w, m_w2)
    min_h = min(m_h, m_h2)

    answer = min_w * min_h
    # print(answer)
    return answer

sizes = [[60, 50], [30, 70], [60, 30], [80, 40]]
solution(sizes)

def solution(sizes):
    max_w = 0
    max_h = 0

    for card in sizes:
        w, h = card
        max_w = max(max_w, max(w, h))  # 회전하지 않은 경우
        max_h = max(max_h, min(w, h))  # 회전한 경우

    answer = max_w * max_h
    return answer