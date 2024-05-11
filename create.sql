create sequence weather_seq start with 1 increment by 50;
create table weather (temperature integer not null, id bigint not null, city varchar(255), unit varchar(255), primary key (id));
create sequence weather_seq start with 1 increment by 50;
create table weather (temperature integer not null, id bigint not null, city varchar(255), unit varchar(255), primary key (id));
