CREATE TABLE IF NOT EXISTS java_lessons.authorities
(
    email     VARCHAR(100),
    authority VARCHAR(50),

    FOREIGN KEY (email)
        REFERENCES java_lessons.users (email)
);
