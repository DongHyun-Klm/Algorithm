-- 코드를 작성해주세요
select ITEM_ID,	ITEM_NAME,	RARITY
from ITEM_INFO
where ITEM_ID IN (
    select ITEM_ID from ITEM_TREE where ITEM_ID NOT IN (
        select distinct PARENT_ITEM_ID from ITEM_TREE where PARENT_ITEM_ID IS NOT NULL))
order by ITEM_ID desc;