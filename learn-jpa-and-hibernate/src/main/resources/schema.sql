CREATE TABLE TBL_COURSE
(
    id          bigint auto_increment not null,
    title       varchar(255) not null,
    description varchar(255) not null,
    primary key (id)
);

INSERT INTO TBL_COURSE (title, description) VALUES ('Spring', '10 Steps');
INSERT INTO TBL_COURSE (title, description) VALUES ('Spring MVC', '10 Examples');
INSERT INTO TBL_COURSE (title, description) VALUES ('Spring Boot', '6K Students');