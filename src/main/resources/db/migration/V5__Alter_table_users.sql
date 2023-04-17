ALTER TABLE java_lessons.users
    ADD COLUMN password VARCHAR(50),
    ADD COLUMN email    VARCHAR(100) UNIQUE;