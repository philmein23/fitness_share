drop table if exists muscle;
drop table if exists exercise;
drop table if exists exercise_program;

create table exercise_program (
    program_id SERIAL primary key,
    program_name text
);

create table exercise
(
    exercise_id SERIAL primary key,
    exercise_program integer references exercise_program(program_id),
    exercise_program_key integer,
    exercise_name varchar(255),
    description text,
    difficulty integer
);

create table muscle
(
    muscle_id SERIAL primary key,
    muscle_name varchar(50),
    exercise integer references exercise(exercise_id),
    exercise_key integer
);
