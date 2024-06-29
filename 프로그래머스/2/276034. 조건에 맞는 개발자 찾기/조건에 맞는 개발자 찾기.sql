SELECT
    D.ID,
    D.EMAIL,
    D.FIRST_NAME,
    D.LAST_NAME
FROM
    DEVELOPERS D
JOIN
    SKILLCODES S1 ON S1.NAME = 'Python' OR S1.NAME = 'C#'
WHERE
    (D.SKILL_CODE & S1.CODE) != 0
GROUP BY
    D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
ORDER BY
    D.ID;
