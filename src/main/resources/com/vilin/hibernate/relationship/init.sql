drop table if exists emp;
drop table if exists dept;

create table dept(
    id int primary key auto_increment,
    name varchar(50)
)engine=Innodb default charset=utf8;

create table emp(
    id int primary key auto_increment,
    name varchar(50),
    dept_id int,
    foreign key(dept_id) references dept(id)
)engine=Innodb default charset=utf8;


insert into dept(name) value('d1'),('d2'),('d3');

insert into emp(name, dept_id) value ('e1', 1);
insert into emp(name, dept_id) value ('e2', 2);
insert into emp(name, dept_id) value ('e3', 3);
insert into emp(name, dept_id) value ('e4', 1);
insert into emp(name, dept_id) value ('e5', 2);
insert into emp(name, dept_id) value ('e6', 3);
insert into emp(name, dept_id) value ('e7', 1);
insert into emp(name, dept_id) value ('e8', 3);

drop table if exists class;
drop table if exists student;

create table class(
    id int primary key auto_increment,
    name varchar(50)
)engine=Innodb default charset=utf8;

create table student(
    id int primary key auto_increment,
    name varchar(50),
    class_id int,
    foreign key(class_id) references class(id)
)engine=Innodb default charset=utf8;

insert into class(name) value('cls1'),('cls2'),('cls3');

insert into student(name, dept_id) value ('s1', 1);
insert into student(name, dept_id) value ('s1', 2);
insert into student(name, dept_id) value ('s1', 3);
insert into student(name, dept_id) value ('s1', 1);
insert into student(name, dept_id) value ('s1', 3);
insert into student(name, dept_id) value ('s1', 3);
insert into student(name, dept_id) value ('s1', 2);
insert into student(name, dept_id) value ('s1', 1);
