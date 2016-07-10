create table abc
(
oid number(2) primary key,
region varchar(2) ,
total number(5,2)
)
drop table abc;
insert into abc
select 1,'a',100.00 from dual 
union all select 2,'b',80 from dual
union all select 3,'c',130 from dual;

insert into abc
select 4,'c',90.00 from dual 
union all select 5,'b',110 from dual
union all select 6,'a',100 from dual
union all select 7,'a',90 from dual
union all select 8,'a',80 from dual
union all select 9,'b',120 from dual
union all select 10,'c',110 from dual
union all select 11,'c',115 from dual;

commit
select * from abc;

select oid,region,total, avg(total) over(partition by region) from abc;

select a.oid,a.region ,a.total,avgtotal from abc  a
join (select region,avg(total)  avgtotal from abc group by region)  ab
on ab.region=a.region where  a.total >ab.avgtotal

查询出销售表中，销售额大于本地区平均水平的记录 

