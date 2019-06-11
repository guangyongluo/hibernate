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

drop table if exists student;
drop table if exists class;

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

insert into student(name, class_id) value ('s1', 1);
insert into student(name, class_id) value ('s2', 2);
insert into student(name, class_id) value ('s3', 3);
insert into student(name, class_id) value ('s4', 1);
insert into student(name, class_id) value ('s5', 3);
insert into student(name, class_id) value ('s6', 3);
insert into student(name, class_id) value ('s7', 2);
insert into student(name, class_id) value ('s8', 1);

drop table if exists stu;
drop table if exists course;
drop table if exists stu_course;

create table stu(
    id int primary key auto_increment,
    name varchar(50)
)engine=Innodb default charset=utf8;

create table course(
    id int primary key auto_increment,
    name varchar(50)
)engine=Innodb default charset=utf8;

create table stu_course(
    id int primary key auto_increment,
    stu_id int,
    course_id int,
    foreign key(stu_id) references stu(id),
    foreign key(course_id) references course(id)
)engine=Innodb default charset=utf8;

insert into course(name) value('java'),('javascript'),('go');
insert into stu(name) value('s1'),('s2'),('s3'),('s4'),('s5');
insert into stu_course(stu_id, course_id) value (1, 1);
insert into stu_course(stu_id, course_id) value (1, 3);
insert into stu_course(stu_id, course_id) value (2, 1);
insert into stu_course(stu_id, course_id) value (2, 2);
insert into stu_course(stu_id, course_id) value (3, 1);
insert into stu_course(stu_id, course_id) value (3, 3);
insert into stu_course(stu_id, course_id) value (4, 1);
insert into stu_course(stu_id, course_id) value (4, 3);

drop table if exists card;
drop table if exists person;

create table card(
    id int primary key auto_increment,
    name varchar(50)
)engine=Innodb default charset=utf8;

create table person(
    id int primary key auto_increment,
    name varchar(50),
    card_id int unique, --通过指定unique将多对一变成1对1的关系
    foreign key(card_id) references card(id)
)engine=Innodb default charset=utf8;

