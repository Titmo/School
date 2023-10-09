create table car(
	id serial primary key,
	brend varchar(30) not null,
	model varchar(30) not null,
	price numeric(20,2)
)
create table car_ower(
	id serial primary key,
	name varchar(50) not null,
	age serial,
	has_license boolean default false,
	car_id serial references car(id)
)