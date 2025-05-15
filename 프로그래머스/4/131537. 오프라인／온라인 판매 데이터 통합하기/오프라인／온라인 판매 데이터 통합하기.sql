-- 코드를 입력하세요

# ONLINE_SALE 온라인 상품 판매 정보 테이블
# OFFLINE_SALE 오프라인 상품 판매 정보 테이블


# 온라인 테이블과 오프라인 테이블에서
# 2022년 3월의 오프라인/온라인 상품 판매 데이터의 판매날짜,상품id,유저id,판매량을 출력
# 오프라인 테이블의 판매데이터의 userid 값은 null로 표시
# 판매일을 기준으로 오름차순 정렬 같다면 상품 id를 기준으로 오름차순 상품 id도 같다면 유저 id를 기준 오름차순
# SELECT
#     SALES_DATE,
#     PRODUCT_ID,
#     USER_ID,
#     SALES_AMOUNT
# FROM ONLINE_SALE
# WHERE SALES_DATE LIKE "%2022-03"
# UNION ALL
# SELECT
#     SALES_DATE,
#     PRODUCT_ID IS NULL ,
#     USER_ID,
#     SALES_AMOUNT
# FROM OFFLINE_SALE
# WHERE SALES_DATE LIKE "%2022-03"

SELECT
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
FROM ONLINE_SALE
WHERE SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'

UNION ALL

SELECT
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
    PRODUCT_ID,
    NULL AS USER_ID,
    SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'

ORDER BY
    SALES_DATE ASC,
    PRODUCT_ID ASC,
    USER_ID ASC;


    