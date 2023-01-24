CREATE DATABASE join_work(
    );
    CREATE TABLE sport_type
(
    id integer NOT NULL,
    sport character varying(50) NOT NULL,
    wage integer NOT NULL,
    PRIMARY KEY (id)
);

    CREATE TABLE public.coaches
(
    id integer NOT NULL,
    full_name character varying(50) NOT NULL,
    sport_type_id integer NOT NULL,
    phone_num character varying(50),
    "INN" character varying(50) NOT NULL,
    PRIMARY KEY (id, "INN")
);

insert into sport_type values (1, 'football', 450);
insert into sport_type values (2, 'kung Fu', 600);
insert into sport_type values (3, 'volleyball', 450);
insert into sport_type values (4, 'karate', 500);
insert into sport_type values (5, 'box', 550);

insert into coaches values (1, 'W.Oliver', 5, '0078362736', '394757394758');
insert into coaches values (2, 'R.Jack', 1, '008374762736', '837493795847');
insert into coaches values (3, 'D.Harry', 3, '0938475584', '203848574948');
insert into coaches values (4, 'V.Jacob', 4, '0384754883', '239488949495');
insert into coaches values (5, 'Bruce Lee', 2, '0393848484', '593845849539');
insert into coaches values (6, 'B.Charley', 4, '0483738484', '493944793940');
insert into coaches values (7, 'J.Thomas', 3, '0398484848', '923847484939');

alter table coaches add foreign key (sport_type_id) references sport_type (id);

select * from coaches join sport_type on coaches.sport_type_id = sport_type.id where wage > 500;

select * from coaches where full_name like '%a%';

select * from sport_type where sport like '%ball%';

select * from coaches join sport_type on coaches.sport_type_id = sport_type.id order by wage desc, full_name;

update coaches set full_name = 'Carlo Anchelotti' where id = 1;

update sport_type set wage = wage * 2;

delete from coaches where full_name = 'Bruce Lee';
