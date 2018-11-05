drop table if exists product;
drop table if exists type;

create table type (
   id serial primary key,
   name varchar(100)
);

create table product (
   id serial primary key,
   name varchar(100),
   type_id int references type(id),
   expired_date date,
   price money,
   p_count int
);

insert into type (name) values ('milk'),('cheese'),('bread'),('water'),('ice_cream');
insert into product (name,type_id,expired_date,price,p_count) values ('domik_v_derevne',1,'2018-11-10 12:00:00','59',15);
insert into product (name,type_id,expired_date,price,p_count) values ('yadrin',1,'2018-11-06 12:00:00','58',4);
insert into product (name,type_id,expired_date,price,p_count) values ('molochnay_strana',1,'2018-11-07 6:00:00','49',15);
insert into product (name,type_id,expired_date,price,p_count) values ('chedder',2,'2019-06-01 12:00:00','1100',15);
insert into product (name,type_id,expired_date,price,p_count) values ('rossiyskiy',2,'2019-04-01 12:00:00','700',6);
insert into product (name,type_id,expired_date,price,p_count) values ('gauda',2,'2018-12-01 12:00:00','900',15);
insert into product (name,type_id,expired_date,price,p_count) values ('karavay',3,'2018-11-06 12:00:00','30',15);
insert into product (name,type_id,expired_date,price,p_count) values ('ya',4,'2018-12-01 12:00:00','25',15);
insert into product (name,type_id,expired_date,price,p_count) values ('korovka_iz_corenovki',5,'2019-12-01 12:00:00','50',15);
insert into product (name,type_id,expired_date,price,p_count) values ('ice_cream_from_ussr',5,'2019-12-01 12:00:00','50',1);
--1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product where type_id = (select id from type where name = 'cheese')
-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product as i where i.name like '%ice_cream%'
--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product as p where (EXTRACT(month from p.expired_date) = EXTRACT(month from CURRENT_DATE + interval '1 month' ))
-- 4. Написать запрос, который выводит самый дорогой продукт.
select MAX(price) from product
-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
select count(*) from product where type_id = (select id from type where name = 'milk')
-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product as p inner join type as t on p.type_id = t.id where (t.name = 'milk' or t.name = 'cheese');
-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select * from product as p where p.p_count < 10
-- 8. Вывести все продукты и их тип.
select p.name,t.name from product as p inner join type as t on p.type_id = t.id