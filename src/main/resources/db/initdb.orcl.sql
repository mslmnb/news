-- connect sys as sysdba
-- alter session set "_ORACLE_SCRIPT"=true;
-- create user newsuser identified by password;
-- GRANT ALL PRIVILEGES to newsuser;

-- drop sequence global_seq;

CREATE SEQUENCE global_seq
 START WITH 100000
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

create table news
(
    id          NUMBER DEFAULT global_seq.NEXTVAL,
    datetime    TIMESTAMP(6) DEFAULT SYSDATE,
    title       VARCHAR2(100)  not null,
    brief       VARCHAR2(1000) not null,
    checked     CHAR(1) DEFAULT 'F' check (CHECKED in ('F', 'T'))
);