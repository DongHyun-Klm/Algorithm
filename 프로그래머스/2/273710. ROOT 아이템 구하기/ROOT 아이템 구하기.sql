-- 코드를 작성해주세요
select ITEM_ID,	ITEM_NAME
from ITEM_INFO
where ITEM_ID IN (select ITEM_ID from ITEM_TREE where PARENT_ITEM_ID IS NULL);
