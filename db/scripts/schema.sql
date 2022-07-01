create table if not exists posts
(
    id          serial primary key,
    name        varchar(2000)
);

create table if not exists candidates
(
    id          serial primary key,
    name        varchar(2000),
    city        varchar(2000)
);

create table if not exists users
(
    id          serial primary key,
    name        varchar(2000),
    email        varchar(2000),
    password        varchar(2000)
);

create table if not exists cities
(
    id          serial primary key,
    name        varchar(2000)
);