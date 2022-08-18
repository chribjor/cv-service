CREATE TABLE education (school varchar(255), userId varchar(255), focus varchar(255), city varchar(255), startDate DATE, endDate DATE, degree varchar(255), id uniqueidentifier DEFAULT NEWSEQUENTIALID());

INSERT INTO educations (id, school, focus, city, start_date, end_date, degree) VALUES ('DACFC78B-10F6-EC11-B061-BC8385D2990C', 'Karlstads universitet', 'IT-Design - Systemdesign', 'Karlstad', '2017-08-23', '2022-05-15', 'kandidatexamen');

CREATE TABLE experience (title varchar(255), description varchar(255), employer varchar(255), city varchar(255), techniquesAndMethods varchar(255), userId varchar(255), id uniqueidentifier DEFAULT NEWSEQUENTIALID());

INSERT INTO experience (title, description, employer, city, techniquesAndMethods, userId) VALUES ('Webdesigner', 'webhantering', 'AFRY', 'Karlstad', 'Angular 7', 'CB');

CREATE TABLE technic (id uniqueidentifier DEFAULT NEWSEQUENTIALID(), technic_area varchar(255), PRIMARY KEY (id));

INSERT INTO technic(technic_area) VALUES ('Microsoft 365');

CREATE TABLE person (id uniqueidentifier DEFAULT NEWSEQUENTIALID(), username varchar(50), firstname varchar(50), lastname varchar(255), PRIMARY KEY (id));

INSERT INTO person(username, firstname, lastname) VALUES ('CB', 'Christine', 'Björemo');

CREATE TABLE person_technic (person_id uniqueidentifier NOT NULL, technic_id uniqueidentifier NOT NULL, PRIMARY KEY (person_id, technic_id), CONSTRAINT person_technic_fk1 FOREIGN KEY (technic_id) REFERENCES technic (id), CONSTRAINT person_technic_fk2 FOREIGN KEY (person_id) REFERENCES person (id));

SELECT id FROM person WHERE username='CB'

SELECT * FROM technic WHERE id='EC840362-26F6-EC11-B061-BC8385D2990C'

CREATE TABLE process (id uniqueidentifier DEFAULT NEWSEQUENTIALID(), process_type varchar(255), PRIMARY KEY (id));

Insert INTO process(process_type) VALUES ('SCRUM');

CREATE TABLE person_process(person_id uniqueidentifier NOT NULL, process_id uniqueidentifier NOT NULL, PRIMARY KEY (person_id, process_id), CONSTRAINT person_process_fk1 FOREIGN KEY (process_id) REFERENCES process (id), CONSTRAINT person_process_fk2 FOREIGN KEY (person_id) REFERENCES person (id));

INSERT INTO person_process (person_id, process_id) VALUES ('01D61314-24F6-EC11-B061-BC8385D2990C', 'CD0D8DC5-28F6-EC11-B061-BC8385D2990C');

CREATE TABLE trustee (id uniqueidentifier DEFAULT NEWSEQUENTIALID(), title varchar(100), start_date DATE, end_date DATE, association varchar(255), city varchar(50), PRIMARY KEY (id));

INSERT INTO trustee(title, start_date, end_date, association, city) VALUES ('Styrelsesuppleant', '2020-05-02', '2023-05-02', 'Styrelseuppdrag', 'Karlstad');

CREATE TABLE person_trustee (person_id uniqueidentifier NOT NULL, trustee_id uniqueidentifier NOT NULL, PRIMARY KEY (person_id, trustee_id), CONSTRAINT person_trustee_fk1 FOREIGN KEY (person_id) REFERENCES person (id), CONSTRAINT person_trustee_fk2 FOREIGN KEY (trustee_id) REFERENCES trustee (id));

INSERT INTO person_trustee(person_id, trustee_id) VALUES ('01D61314-24F6-EC11-B061-BC8385D2990C', 'E19E3F38-BFF6-EC11-B061-BC8385D2990C');