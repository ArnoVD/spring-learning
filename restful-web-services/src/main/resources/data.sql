INSERT INTO user_details (id, name, birth_date)
VALUES(10001, 'Arno', current_date());

INSERT INTO user_details (id, name, birth_date)
VALUES(10002, 'Anne-Sophie', current_date());

INSERT INTO user_details (id, name, birth_date)
VALUES(10003, 'Erik', current_date());

INSERT INTO post_details (id, description, user_id)
VALUES(20001, 'I want to learn AWS', 10001);

INSERT INTO post_details (id, description, user_id)
VALUES(20002, 'I want to learn Devops', 10002);

INSERT INTO post_details (id, description, user_id)
VALUES(20003, 'I want to learn JPA', 10003);