create table bestellung
(
    id            integer generated always as identity,
    sparte        integer not null,
    bestelldatum  timestamp,
    bestellwert   numeric(5, 2),
    constraint bestellung_pk primary key (id, sparte)
);

create table bestellposition
(
    id                integer not null,
    bestellung_id     integer not null,
    bestellung_sparte integer not null,
    name              varchar,
    anzahl            integer,
    constraint bestellposition_pk primary key (id, bestellung_id, bestellung_sparte)
);

create sequence bestellposition_id_seq as integer;
