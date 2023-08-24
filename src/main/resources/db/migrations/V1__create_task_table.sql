create schema if not exists tasks;

create table tasks.task(
    id UUID primary key,
    title varchar(30) not null,
    description varchar(100) not null,
    date_create DATE DEFAULT now(),
    status varchar(10)
)