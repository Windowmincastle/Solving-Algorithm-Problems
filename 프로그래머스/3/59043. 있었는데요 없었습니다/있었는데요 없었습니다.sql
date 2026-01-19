-- 코드를 입력하세요
-- ANIMAL_INS 
-- ANIMAL_OUTS 
select
    i.ANIMAL_ID,
    o.NAME
from ANIMAL_INS as i
join ANIMAL_OUTS as o on i.ANIMAL_ID = o.ANIMAL_ID
where o.DATETIME < i.DATETIME
order by i.DATETIME ASC
