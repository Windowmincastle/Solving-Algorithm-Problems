-- 코드를 입력하세요
# CAR_RENTAL_COMPANY_RENTAL_HISTORY
# 자동차 대여 기록 id
# 자동차 id
# 대여시작일
# 대여 종료일

SELECT
    CAR_ID,
    CASE
        WHEN SUM(CASE
                    WHEN '2022-10-16' BETWEEN START_DATE AND END_DATE THEN 1
                    ELSE 0
                 END) > 0
        THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;
