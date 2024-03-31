-- 코드를 작성해주세요
select ID, (select count(*) from ECOLI_DATA as B where A.ID = B.PARENT_ID) as CHILD_COUNT
from ECOLI_DATA as A
order by ID
;