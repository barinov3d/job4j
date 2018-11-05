--create database script

CREATE DATABASE myDataBase;

--delete previouse table if exists
drop table if exists it_comments;
drop table if exists it_attaches;
drop table if exists item;
drop table if exists it_category;
drop table if exists users;
drop table if exists roles_rules;
drop table if exists roles; 
drop table if exists rules; 
drop table if exists it_state;

--create tables script
create table roles (
   id serial primary key,
   name varchar(100)
);
create table users (
   id serial primary key,
   name varchar(100),
   roles_id int references roles(id)
);

create table rules (
   id serial primary key,
   name varchar(100)
);

create table roles_rules (
   id serial primary key,
   roles_id int references roles(id),
   rules_id int references rules(id)
);


create table it_category (
   id serial primary key,
   name varchar(100)
);

create table it_state (
   id serial primary key,
   name varchar(100)
);

create table item (
   id serial primary key,
   name varchar(100) unique,
   belong_to_user int references users(id) unique,
   it_category_ids int references it_category(id),
   it_state_ids int references it_state(id)
);

create table it_comments (
   id serial primary key,
   name varchar(100),
   item_id int references item(id)
);

create table it_attaches (
   id serial primary key,
   name varchar(100),
   item_id int references item(id)
);

--insert information into tables script
insert into roles (name) values ('administrator'),('moderator'),('user'),('guest');
insert into users (name,roles_id) values ('user1',1),('user2',2),('user3',2);
insert into rules (name) values ('read'),('write');
insert into roles_rules (roles_id, rules_id) values (1,1),(1,2),(2,1),(2,2),(3,1),(4,1);
insert into it_comments (name) values ('comment1'),('comment2');
insert into it_attaches (name) values ('attach1'),('attach2');
insert into it_category (name) values ('category1'),('category2'),('category3');
insert into it_state (name) values ('not_started'),('in_progress'),('solved');
insert into item (name, belong_to_user,it_category_ids,it_state_ids)
 values ('item438',1,1,2),('item453',2,1,3),('item445',3,3,2);

select * from item;