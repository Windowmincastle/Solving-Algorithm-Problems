-- FIRST_HALF 테이블
-- ICECREAM_INFO

-- 출하 번호(PK), 아이스크림 맛, 상반기 아이스크림 총 주문량

-- ICECREAM_INFO 테이블 구조
-- 아이스크림 맛 (FK)
-- 아이스크림의 성분 타입

-- 아이스크림 주 성분이 과일이다 -> fruit_based
-- 상반기 아이스크림 총 주문량이 3,000보다 높다
-- 총 주문량이 큰 순서 DESC

SELECT
    FIRST_HALF.FLAVOR
FROM
    FIRST_HALF
INNER JOIN
    ICECREAM_INFO
ON
    FIRST_HALF.FLAVOR = ICECREAM_INFO.FLAVOR
WHERE
    FIRST_HALF.TOTAL_ORDER > 3000
    AND ICECREAM_INFO.INGREDIENT_TYPE = 'fruit_based'
ORDER BY
    FIRST_HALF.TOTAL_ORDER DESC;
