create table bestellung
(
    id            integer generated always as identity,
    bestelldatum  timestamp,
    bestellwert   numeric(5, 2),
    constraint bestellung_pk primary key (id)
);

create table bestellposition
(
    id            integer not null,
    bestellung_id integer not null,
    name          varchar,
    anzahl        integer,
    constraint bestellposition_pk primary key (id, bestellung_id)
);

create sequence bestellposition_id_seq as integer;

