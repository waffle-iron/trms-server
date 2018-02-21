CREATE TABLE IF NOT EXISTS roles (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
  id                   SERIAL PRIMARY KEY,
  first_name           VARCHAR(255)        NOT NULL,
  last_name            VARCHAR(255)        NOT NULL,
  job_title            VARCHAR(255),
  email                VARCHAR(255) UNIQUE NOT NULL,
  role_id              INTEGER REFERENCES roles (id),
  password             VARCHAR(255)        NOT NULL,
  direct_supervisor_id INTEGER REFERENCES users (id),
  department_head_id   INTEGER REFERENCES users (id),
  created_on           DATE                NOT NULL,
  updated_on           DATE                NOT NULL
);

CREATE TABLE IF NOT EXISTS event_types (
  id         SERIAL PRIMARY KEY,
  name       VARCHAR(255),
  percentage INTEGER CHECK (percentage > 0 AND percentage <= 100)
);

CREATE TYPE GRADING_FORMAT AS ENUM (
  'GPA',
  'Letter',
  '100',
  'PassFail',
  'Presentation'
);

CREATE TABLE IF NOT EXISTS grading_formats (
  id          SERIAL PRIMARY KEY,
  format      GRADING_FORMAT NOT NULL,
  description TEXT
);

CREATE TYPE EVENT_STATUS AS ENUM (
  'Applied',
  'Supervisor Approved',
  'Department Head Approved',
  'Approved',
  'In Progress',
  'Pass',
  'Fail',
  'BenCo Approved'
);

CREATE TABLE IF NOT EXISTS events (
  id                   SERIAL PRIMARY KEY,
  event_type_id        INTEGER REFERENCES event_types (id),
  datetime             TIMESTAMP     NOT NULL,
  location             VARCHAR(255)  NOT NULL,
  description          TEXT,
  justification        TEXT          NOT NULL,
  cost                 DECIMAL(6, 2) NOT NULL,
  grading_format       INTEGER REFERENCES grading_formats (id),
  passing_grade_cutoff VARCHAR(255)  NOT NULL,
  completed_on         DATE,
  status               EVENT_STATUS,
  attachment           BYTEA
);

CREATE TABLE IF NOT EXISTS reimbursements (
  id                              SERIAL PRIMARY KEY,
  employee_id                     INTEGER REFERENCES users (id),
  event_id                        INTEGER REFERENCES events (id),
  created_on                      TIMESTAMP NOT NULL,
  update_on                       TIMESTAMP NOT NULL,
  direct_supervisor_approved_on   TIMESTAMP,
  direct_supervisor_auto_approved BOOLEAN,
  department_head_approved_on     TIMESTAMP,
  department_head_auto_approved   BOOLEAN,
  benco_approved_on               TIMESTAMP,
  denied_on                       TIMESTAMP,
  denied_reason                   TEXT
);