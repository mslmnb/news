-- connect sys as sysdba
-- alter session set "_ORACLE_SCRIPT"=true;
-- create user newsuser identified by password;
-- GRANT ALL PRIVILEGES to newsuser;

-- drop sequence GLOBAL_SEQ;

CREATE SEQUENCE global_seq
 START WITH 100000
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

create table news
(
    ID      NUMBER DEFAULT GLOBAL_SEQ.NEXTVAL,
    "date"  TIMESTAMP(6) DEFAULT SYSDATE,
    TITLE   VARCHAR2(100)  not null,
    BRIEF   VARCHAR2(1000) not null,
    CHECKED CHAR(1) DEFAULT 'F' check (CHECKED in ('F', 'T'))
);