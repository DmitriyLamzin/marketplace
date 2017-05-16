create table marketplace.Person (
	email varchar(45) not null,
    firstname varchar(50) not null,
    lastname varchar(100) not null,
    password varchar(100) null,
    primary key (email), 
    unique index SQL_PERSON_EMAIL_INDEX (EMAIL ASC)
);

create table marketplace.Groups (
	id int not null auto_increment,
    name varchar(50) not null,
	primary key (id)
);

create table marketplace.Person_Groups (
	groups_id int not null,
    email varchar(45) not null,
	index sql_persongroups_email_index (email ASC),
    index sql_persongroups_id_index (groups_id ASC),
    constraint fx_person_groups_person
    foreign key (email) references marketplace.Person (email),
    constraint fx_person_groups_groups
    foreign key (groups_id) references marketplace.Groups (id)
)