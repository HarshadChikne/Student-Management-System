CREATE TABLE users (
    user_id NUMBER PRIMARY KEY,
    username VARCHAR2(50) UNIQUE NOT NULL,
    password VARCHAR2(100) NOT NULL,
    email VARCHAR2(100)
);

CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER user_trigger
BEFORE INSERT ON users
FOR EACH ROW
WHEN (new.user_id IS NULL)
BEGIN
  SELECT user_seq.NEXTVAL INTO :new.user_id FROM dual;
END;
/




CREATE TABLE students (
    student_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER(3),
    course VARCHAR2(50),
    email VARCHAR2(100),
    created_at DATE DEFAULT SYSDATE
);

CREATE SEQUENCE student_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER student_trigger
BEFORE INSERT ON students
FOR EACH ROW
WHEN (new.student_id IS NULL)
BEGIN
  SELECT student_seq.NEXTVAL INTO :new.student_id FROM dual;
END;
/