DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT,
    first_name VARCHAR(256),
    last_name VARCHAR(256),
    username VARCHAR(256),
    auth0_id VARCHAR(24),
    active SMALLINT(1),
    PRIMARY KEY (id)
);