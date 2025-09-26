SELECT
    CAR_ID,  -- 자동차 ID별로 결과를 출력
    CASE 
        -- 기준 날짜(2022-10-16)에 대여 중인 기록이 하나라도 있으면 '대여중'
        WHEN SUM(START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16') > 0
        THEN '대여중'
        -- 기준 날짜에 대여 중인 기록이 하나도 없으면 '대여 가능'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID  -- 자동차 ID별로 그룹화하여 하나의 결과만 남김
ORDER BY CAR_ID DESC;  -- 자동차 ID 내림차순으로 정렬
