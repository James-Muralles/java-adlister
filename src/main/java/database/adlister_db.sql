
drop database if exists adlister_db;

create database adlister_db;

use adlister_db;

CREATE TABLE users (
      id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
      username VARCHAR(50),
      email VARCHAR(50),
      password VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS ads
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO users (username, email, password)
VALUES ('LtSurge', 'thunderBadge@something.com', 'raichu');

INSERT INTO ads (user_id, title, description)
VALUES ('1', 'Pikachu', 'Very angry');