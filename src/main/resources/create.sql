create table if not exists roles (id serial primary key, name varchar(255) not null, created_on timestamp not null, updated_on timestamp); create table if not exists users (id serial primary key, first_name varchar(255) not null, last_name varchar(255) not null, job_title varchar(255), email varchar(255) unique not null, role_id integer references roles(id), password varchar(255) not null, direct_supervisor_id integer references users(id), department_head_id integer references users(id), created_on timestamp not null, updated_on timestamp);
create table if not exists event_types (id serial primary key, name varchar(255), percentage integer check (percentage > 0 and percentage <= 100), created_on timestamp not null, updated_on timestamp);
create table if not exists grading_formats (id serial primary key, format varchar(255) not null, description text, created_on timestamp not null, updated_on timestamp);
create table if not exists statuses (id serial primary key, status varchar(255), description text, created_on timestamp not null, updated_on timestamp);
create table if not exists events (id serial primary key, event_type_id integer references event_types(id), datetime integer not null, location varchar(255) not null, description text, justification text not null, cost integer not null, grading_format integer references grading_formats(id), passing_grade_cutoff varchar(255) not null, completed_on timestamp, status_id integer references statuses(id), attachment bytea, created_on timestamp not null, updated_on timestamp);
create table if not exists reimbursements (id serial primary key, employee_id integer references users(id), event_id integer references events(id), direct_supervisor_approved_on timestamp, direct_supervisor_auto_approved boolean, department_head_approved_on timestamp, department_head_auto_approved boolean, benco_approved_on timestamp, denied_on timestamp, denied_reason text, created_on timestamp not null, updated_on timestamp);
insert into grading_formats (format, description, created_on, updated_on) values ('GPA', 'A scale from 0 to 4', now(), now()), ('Letter', 'Can be A, B, C, D, F', now(), now()), ('100', 'A score from 0 to 100', now(), now()), ('Pass/Fail', 'A student either passes or fails', now(), now()), ('Presentation', 'A presentation will determine satisfactory knowledge', now(), now());
insert into roles (name, created_on, updated_on) values ('Benefits Coordinator', now(), now()), ('Employee', now(), now()), ('Supervisor', now(), now()), ('Department Head', now(), now()), ('Officer', now(), now());
insert into event_types (name, percentage, created_on, updated_on) values ('University Course', 80, now(), now()), ('Seminar', 60, now(), now()), ('Certification Preparation', 75, now(), now()), ('Certification', 100, now(), now()), ('Technical Training', 90, now(), now()), ('Other', 30, now(), now());
insert into statuses (status, created_on, updated_on) values ('Applied',  now(), now()), ('Supervisor Approved', now(), now()), ('Department Head Approved', now(), now()), ('Approved', now(), now()), ('In Progress', now(), now()), ('Pass', now(), now()), ('Fail', now(), now()), ('BenCo Approved', now(), now()), ('Denied', now(), now());