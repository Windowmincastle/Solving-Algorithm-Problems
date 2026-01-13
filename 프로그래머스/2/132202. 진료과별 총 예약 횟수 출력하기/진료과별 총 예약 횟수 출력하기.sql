SELECT 
    MCDP_CD AS "진료과 코드",
    COUNT(APNT_NO) AS "5월예약건수"
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m') = '2022-05' -- m은 소문자로!
GROUP BY MCDP_CD
ORDER BY 5월예약건수 ASC, MCDP_CD ASC; -- 쉼표 추가 및 별칭/컬럼명 사용