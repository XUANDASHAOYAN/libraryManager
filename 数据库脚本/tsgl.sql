--����tsgl���ݿ�
use master
select * from sysdatabases 
if exists(select * from sysdatabases where name = 'tsgl')
drop database tsgl
go

create database tsgl
on primary
(
  name = 'tsgl_data',
  filename = 'D:\database\tsgl_data.mdf',
  size = 5 mb,
  filegrowth = 1 mb
)
log on(
  name = 'tsgl_log',
  filename = 'D:\database\tsgl_log.ldf',
  size = 5 mb,
  filegrowth = 1 mb
)

/*������*/
--1.book��
use tsgl
go
select * from sysobjects

if exists(select * from sysobjects where name = 'book')
drop table book

create table book(
  id             varchar(32)    not null,
  name           varchar(100)   null,
  type           varchar(50)    null,
  author         varchar(50)    null,
  translator     varchar(50)    null,
  publisher      varchar(1024)  null,
  publish_time   date           null,
  stock          int            null,
  price          float          null
)
go
--��������
alter table book
add constraint pk1 primary key (id)


--2.����������Ϣ��
create table reader(
  id         varchar(32)    not null,
  name       varchar(50)    null,
  type       varchar(20)    null,
  sex        char(2)        null,
  max_num    int            null,
  days_num   int            null
)
--��������
alter table reader
add constraint pk2 primary key (id)
--����checkԼ��
alter table reader
add constraint check1 check(sex = '��'or sex = 'Ů')

--3.����������Ϣ��
create table borrow(
  id              int            identity(1,1),
  book_id         varchar(32)    null,
  reader_id       varchar(32)    null,
  borrow_date     date           null,
  back_date       date           null,
  is_back         int            null
)

--��������Լ��
alter table borrow
add constraint pk3 primary key (id)
--�������Լ��
alter table borrow
add constraint fk1 foreign key (book_id) references book(id)

alter table borrow
add constraint fk2 foreign key (reader_id) references reader(id)

--����user��
create table [user](
  id         int           identity(1,1),
  name       varchar(50)   null,
  pwd        varchar(50)   null,
  is_admin   int           null
)
--��������
alter table [user]
add constraint pk4 primary key (id)
--����Ĭ��ֵԼ��
alter table [user]
add constraint df1 default 0 for is_admin

--��ʼ������Ϊ111111
alter table [user]
add constraint df2 default 111111 for pwd

/*��user������ӹ���Ա�û�*/
insert into [user](name,pwd,is_admin)
values('������','gaomz',1)
