-- auto-generated definition
create table company
(
    id          bigserial           not null,
    username    varchar             not null,
    email       varchar default 100 not null,
    address     varchar default 200 not null,
    city        varchar             not null,
    country     varchar             not null,
    cif         varchar             not null,
    public_name varchar default 200 not null,
    phone       varchar,
    created_at  timestamp,
    updated_at  timestamp
);

create unique index company_cif_uindex
    on company (cif);

create unique index company_email_uindex
    on company (email);

create unique index company_id_uindex
    on company (id);

create unique index company_phone_uindex
    on company (phone);

create unique index company_public_name_uindex
    on company (public_name);

create unique index company_username_uindex
    on company (username);

-- Trade --
create table trade
(
    id         bigserial           not null,
    name       varchar default 200 not null,
    created_at timestamp,
    updated_at timestamp
);

create unique index trade_id_uindex
    on trade (id);

create unique index trade_name_uindex
    on trade (name);

alter table trade
    add constraint trade_pk
        primary key (id);

-- --
create table company_service
(
    id         bigserial not null,
    trade_id   bigint    not null,
    company_id bigint    not null,
    created_at timestamp,
    updated_at timestamp
);

-- --
create table "user"
(
    id         bigserial           not null,
    full_name  varchar default 100 not null,
    email      varchar default 100 not null,
    city       varchar             not null,
    country    varchar             not null,
    phone      varchar             not null,
    created_at timestamp,
    updated_at timestamp
);

comment on table "user" is 'user that wants to look for a service';

create unique index user_email_uindex
    on "user" (email);

create unique index user_id_uindex
    on "user" (id);

create unique index user_phone_uindex
    on "user" (phone);

alter table "user"
    add constraint user_pk
        primary key (id);

-- --
create table user_request_service
(
    id          bigserial not null,
    user_id     bigint    not null,
    handyman_id bigint    not null,
    created_at  timestamp,
    updated_at  timestamp
);

create unique index user_request_service_id_uindex
    on user_request_service (id);

alter table user_request_service
    add constraint user_request_service_pk
        primary key (id);

-- --
create table company_handy_person
(
    id         bigserial not null,
    full_name  varchar   not null,
    company_id bigint    not null,
    trade_id   bigint    not null,
    created_at timestamp,
    updated_at timestamp
);

alter table company_handy_person
    add comment varchar;

create unique index company_handy_person_id_uindex
    on company_handy_person (id);

alter table company_handy_person
    add constraint company_handy_person_pk
        primary key (id);

