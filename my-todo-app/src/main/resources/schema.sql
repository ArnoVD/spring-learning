CREATE TABLE IF NOT EXISTS task
(
    id           INT     NOT NULL,
    user_name    VARCHAR(255),
    description  VARCHAR(255),
    target_date  date,
    task_is_done BOOLEAN NOT NULL,
    CONSTRAINT pk_task PRIMARY KEY (id)
);