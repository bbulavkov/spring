CREATE TABLE IF NOT EXISTS java_lessons.users
(

    id         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    age        INT
);


