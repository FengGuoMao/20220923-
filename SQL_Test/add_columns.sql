create table  if not exists test5(
  id int(10) unsigned not null auto_increment ,-- 创建自增列 auto_increment
  name char(20) not null default '',
  primary key (id) -- 自增配合使用唯一主键 primary key ()
);
insert into test5 (name,id) VALUES('',26) where id = 25;
SELECT * from test5;
ALTER TABLE test5 ADD COLUMN goods VARCHAR(15) -- 指定列名，字段属性
DROP Table test5