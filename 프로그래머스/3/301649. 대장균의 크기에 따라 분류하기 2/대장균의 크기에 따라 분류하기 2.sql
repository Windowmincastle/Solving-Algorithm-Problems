SELECT ID,
       CASE NTILE_RANK
           WHEN 1 THEN 'CRITICAL'
           WHEN 2 THEN 'HIGH'
           WHEN 3 THEN 'MEDIUM'
           WHEN 4 THEN 'LOW'
       END AS COLONY_NAME
FROM (
    SELECT ID,
           NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS NTILE_RANK
    FROM ECOLI_DATA
) AS RANKED
ORDER BY ID

# OVER 절
# 윈도우 함수의 범위를 지정하는 절
# 형식: OVER (PARTITION BY ... ORDER BY ...)
# PARTITION BY: 그룹 나누기 (생략 가능)
# ORDER BY: 정렬 기준 지정

# NTILE(n)
# 데이터를 정렬된 순서대로 n개의 동일한 크기의 구간으로 나눔
# 각 행에 1부터 n까지 번호를 부여
# 예: NTILE(4) → 상위 25%는 1, 하위 25%는 4