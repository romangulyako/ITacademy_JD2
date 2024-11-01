create table shelters
(
    shelter_id   int auto_increment
        primary key,
    shelter_name varchar(255) null,
    location     varchar(255) null
)
    auto_increment = 0;

create table animals
(
    animal_id   int auto_increment
        primary key,
    animal_name varchar(255) null,
    species     varchar(255) null,
    shelter_id  int          null,
    constraint animals___fk
        foreign key (shelter_id) references shelters (shelter_id)
);

create table adoptions
(
    adoption_id   int auto_increment
        primary key,
    animal_id     int          null,
    adopter_name  varchar(255) null,
    adoption_date date         null,
    constraint adoptions_animals_animal_id_fk
        foreign key (animal_id) references animals (animal_id)
);

