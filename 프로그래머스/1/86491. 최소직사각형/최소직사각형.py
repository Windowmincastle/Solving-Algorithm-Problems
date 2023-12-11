def solution(sizes):
    max_w = 0
    max_h = 0

    for card in sizes:
        w, h = card
        max_w = max(max_w, max(w, h))  # 회전하지 않은 경우
        max_h = max(max_h, min(w, h))  # 회전한 경우

    answer = max_w * max_h
    return answer