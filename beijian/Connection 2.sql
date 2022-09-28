select warehousename--仓库名称
,nvl(inboundfinishfee,0) as hboundfinishfee--每小时入库完成金额
,CREATETIME  --将时间转换为小时
FROM DCS.HOURLYCOMPLETIONTEAM
        where TO_CHAR(CREATETIME,'yyyymmdd')=TO_CHAR(SYSDATE,'yyyymmdd')
        AND TO_CHAR(CREATETIME,'hh24')>=7
        and warehousename = '双桥总库'
        ORDER by createtime

;

select TO_CHAR(to_date('2022-09-28', 'yyyy-mm-dd') + (rownum - 1) / 24,'hh24:mi') times
from DCS.HOURLYCOMPLETIONTEAM
connect by level <= 24
order by times
;
select to_date('2022-09-28', 'yyyy-mm-dd') + (rownum - 1) / 24 times
from DCS.HOURLYCOMPLETIONTEAM
connect by level <= 24