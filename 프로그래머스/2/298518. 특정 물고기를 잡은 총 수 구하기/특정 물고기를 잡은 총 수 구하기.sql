# -- 코드를 작성해주세요
# select count(*) as FISH_COUNT
# FROM FISH_INFO FI
# JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
# WHERE FNI.FISH_NAME IN ('BASS','SNAPPER');


-- fish_info 테이블의 fish_Type과 fish_name_info 테이블의 fish_type이 일치하는 경우만 조인한다
-- 위 결과를 바탕으로 fish_name이 bass 또는 snapper인 물고기를 필터링
-- 필터링 된 결과의 count함수로 행 수를 세어 fish_count 컬럼으로 출력.
# SELECT COUNT(*) AS FISH_COUNT
# FROM FISH_INFO FI
# JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE 
# WHERE FNI.FISH_NAME IN ('BASS','SNAPPER');

select count(*) as fish_count
from fish_info fi
join fish_name_info fni on fi.fish_type = fni.fish_type
where fni.fish_name in ('bass','snapper');
