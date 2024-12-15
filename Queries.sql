
# All queries for creating the database and tables of sharebite project

create database sharebite_db;

use sharebite_db;


# ~~~~~~~~~~~~~~~~~~~~~~~~ create countries table ~~~~~~~~~~~~~~~~~~~~~
create table countries(
    country_id int primary key auto_increment,
    name char(50) not null unique
);


# ~~~~~~~~~~~~~~~~~~~~~~~~ create states table ~~~~~~~~~~~~~~~~~~~~~
create table states(
    state_id int primary key auto_increment,
    country_id int not null,
    name char(50) not null,
    constraint states_country_fk foreign key (country_id) references countries(country_id)
);


# ~~~~~~~~~~~~~~~~~~~~~~~~ create cities table ~~~~~~~~~~~~~~~~~~~~~
create table cities(
    city_id int primary key auto_increment,
    state_id int not null,
    name char(50) not null,
    constraint cities_state_fk foreign key (state_id) references states(state_id)
);


# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ create table pincodes ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
create table pincodes(
    pincode_id int primary key auto_increment,
    city_id int not null,
    pincode char(6) not null unique,
    constraint pincodes_city_fk foreign key (city_id) references cities(city_id)
);


# ~~~~~~~~~~~~~~~~~~~~~~~~~ create table addresses ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
create table addresses(
    address_id int primary key auto_increment,
    city_id int not null,
    pincode_id int not null,
    address varchar(255) not null,
    constraint addresses_city_fk foreign key (city_id) references cities(city_id),
    constraint addresses_pincode_fk foreign key (pincode_id) references pincodes(pincode_id)
);


# ~~~~~~~~~~~~~~~~~~~~ create table certificate_types ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
create table certificate_types(
    certificate_type_id int primary key auto_increment,
    name char(80) not null unique
);


# ~~~~~~~~~~~~~~~~~~~~~ create table certificates ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
create table certificates(
    certificate_id int primary key auto_increment,
    certificate_path varchar(255) not null unique,
    certificate_type_id int not null,
    constraint certificates_certificate_type_fk foreign key (certificate_type_id) references certificate_types(certificate_type_id)
);


# ~~~~~~~~~~~~~~~~~~~~~~~ create table user_types ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
create table user_types(
    user_type_id int primary key auto_increment,
    name char(80) not null unique
);
insert into user_types values ("contributor"), ("volunter"), ("event organiser"), ("manager"), ("beneficiary");


# ~~~~~~~~~~~~~~~~~~~~ create table users ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
create table users(
    user_id int primary key auto_increment,
    name char(50) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    address_id int not null,
    user_type_id int not null,
    phone_no char(10) not null,
    alternate_phone_no char(10),
    constraint users_address_fk foreign key (address_id) references addresses(address_id),
    constraint users_user_type_fk foreign key (user_type_id) references user_types(user_type_id)
);


# ~~~~~~~~~~~~~~~~~~~~~ create table user certificates ~~~~~~~~~~~~~~~~~~~~~~~~
create table user_certificates(
    user_certificate_id int primary key auto_increment,
    user_id int not null,
    certificate_id int not null,
    constraint user_certificates_user_fk foreign key (user_id) references users(user_id),
    constraint user_certificates_certificate_fk foreign key (certificate_id) references certificates(certificate_id)
);


# ~~~~~~~~~~~~~~~~~~~~~~~ create table available foods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
create table available_foods(
    available_food_id int primary key auto_increment,
    user_id int not null,
    amt_in_plates int not null,
    contribution_date date not null,
    contribution_time time not null,
    constraint available_foods_user_fk foreign key (user_id) references users(user_id)
);


# ~~~~~~~~~~~~~~~~~~~~~~~~ create table food assignment ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
create table food_assignments(
    fa_id int primary key auto_increment,
    beneficiary_id int not null,
    available_food_id int not null,
    assignment_date date not null,
    assignment_time time not null,
    delivery_status boolean default false,
    constraint food_assignments_user_fk foreign key (beneficiary_id) references users(user_id),
    constraint food_assignments_food_fk foreign key (available_food_id) references available_foods(available_food_id)
);


show tables;


INSERT INTO pincodes (city_id, pincode) VALUES
(64, 482001),
(64, 482002),
(64, 482003),
(64, 482004),
(64, 482005),
(64, 482007),
(64, 482008),
(64, 482009),
(64, 482010),
(64, 482011),
(64, 482020),
(64, 482021),
(64, 482051),
(64, 482056),
(64, 483001),
(64, 483050),
(64, 483053),
(64, 483105),
(64, 483110),
(64, 483113),
(64, 483119),
(64, 483220),
(64, 483222),
(64, 483225),
(64, 483334),
(64, 483336),
(64, 483880);



