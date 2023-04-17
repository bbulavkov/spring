ALTER TABLE java_lessons.users
    ADD COLUMN email    VARCHAR(100) UNIQUE,
    ADD COLUMN password VARCHAR(100);