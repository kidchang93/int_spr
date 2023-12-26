DROP INDEX  if exists ix_auth_username;
DROP TABLE  if exists authorities;
DROP TABLE  if exists users;


CREATE TABLE users(
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    enabled char(1) DEFAULT '1'
);

CREATE TABLE authorities(
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users
        FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

INSERT INTO users (username, password) values('user00', 'pw00');
INSERT INTO users (username, password) values('member00', 'pw00');
INSERT INTO users (username, password) values('admin00', 'pw00');

INSERT INTO authorities (username, authority) values('user00', 'ROLE_USER');
INSERT INTO authorities (username, authority) values('member00', 'ROLE_USER');
INSERT INTO authorities (username, authority) values('admin00', 'ROLE_MANAGER');
INSERT INTO authorities (username, authority) values('admin00', 'ROLE_ADMIN');

SELECT * FROM users;
//------------------------------------------------------------------------------
drop table tbl_member_auth;
drop table tbl_member;

create table tbl_member(
                           userid varchar(50) not null primary key,
                           userpw varchar(100) not null,
                           username varchar(100) not null,
                           regdate date default CURRENT_DATE,
                           updatedate date default CURRENT_DATE,
                           enabled char(1) default '1');

create table tbl_member_auth (
                                 userid varchar(50) not null,
                                 auth varchar(50) not null,
                                 constraint fk_member_auth foreign key(userid) references tbl_member(userid)
);

select * from tbl_member;
select * from tbl_member_auth;
//------------------------------------------------------------------------------
CREATE TABLE presistent_logins(
      username VARCHAR(64) NOT NULL,
      series VARCHAR(64) PRIMARY KEY,
      token VARCHAR(64) NOT NULL,
      last_used TIMESTAMP  NOT NULL
);


SELECT * from presistent_logins;
