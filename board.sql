-- 2023-08-31

create table board(
bno int auto_increment,
title varchar(200),
writer varchar(100) not null,
content text,
regdate datetime default now(),
moddate datetime default now(),
readcount int default 0,
primary key(bno)
);