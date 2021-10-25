create table categories (id bigserial primary key, category_name varchar(255));
insert into categories (category_name) values
('Fruit'),
('Vegetable'),
('Berry');

create table products (id bigserial primary key,
                       title varchar(255),
                       cost int,
                       category_id bigint references categories(id));
insert into products (title, cost, category_id) values
('Apple', 100, 1),
('Potato',4, 2),
('Tomato',5, 2),
('Sweet Potato',6, 2),
('Cucumber',7, 2),
('Radish',8, 2),
('Pepper',9, 2),
('Pepper Bell',10, 2),
('Horse Radish',1, 2),
('Zucchini',2, 2),
('Pumpkin',3, 2);

create table user_roles (id bigserial primary key, role varchar(255));
insert into user_roles (role) values
('ADMIN'),
('USER');

create table users (id bigserial primary key not null,
                    username varchar not null,
                    password varchar(80) not null,
                    email varchar not null,
                    role_id bigint references user_roles(id));
insert into users (username, password, email, role_id)
values
('admin', '$2y$12$uDTMf9F2Djwflqi5U8fwtenibQqqKRcIYqlhT8BSWqXwANBffFQQ.', 'user@gmail.com', 1),
('user', '$2y$12$uDTMf9F2Djwflqi5U8fwtenibQqqKRcIYqlhT8BSWqXwANBffFQQ.', 'user1@gmail.com', 2);