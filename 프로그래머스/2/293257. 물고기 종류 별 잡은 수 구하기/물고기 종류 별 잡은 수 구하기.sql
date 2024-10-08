select 
    COUNT(*) AS FISH_COUNT,
    FISH_NAME
  from FISH_INFO A
  join FISH_NAME_INFO B
    on A.FISH_TYPE = B.FISH_TYPE
GROUP BY FISH_NAME
ORDER BY FISH_COUNT DESC