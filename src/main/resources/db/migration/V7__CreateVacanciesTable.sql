CREATE TABLE vacancies(
    id SERIAL PRIMARY KEY ,
    vacancies_name VARCHAR(255) NOT NULL ,
    salary VARCHAR(100) NOT NULL ,
    answer BOOLEAN NOT NULL DEFAULT false,
    info VARCHAR(1000)
);