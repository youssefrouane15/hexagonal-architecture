CREATE TABLE BOOK
(
    id   INTEGER  NOT NULL AUTO_INCREMENT,
    title VARCHAR(128) NOT NULL,
    description VARCHAR(128) NOT NULL,
    price FLOAT NOT NULL,
    PRIMARY KEY (id)
);