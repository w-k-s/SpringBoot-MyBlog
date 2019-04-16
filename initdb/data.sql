CREATE TABLE blogs(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(128) NOT NULL,
    slug VARCHAR(128) NOT NULL,
    preview VARCHAR(255),
    body TEXT NOT NULL,
    created_date DATE NOT NULL,
    last_modified_date DATE NOT NULL
);

INSERT INTO blogs (
    id,
    title,
    slug,
    preview,
    body,
    created_date,
    last_modified_date
) VALUES (
    DEFAULT,
    'First Post!',
    'first_post',
    'First Post!',
    'This is the first post that is in this blog',
    now(),
    now()
);