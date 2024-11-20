CREATE DATABASE madrid_payment_db;

USE madrid_payment_db;

CREATE TABLE payment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    reference VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255),
    email VARCHAR(255),
    amount DECIMAL(10, 2)
);

