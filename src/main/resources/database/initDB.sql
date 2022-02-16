CREATE TABLE IF NOT EXISTS coffee
(
    id             SERIAL PRIMARY KEY,
    typeofcoffee   VARCHAR(8) NOT NULL,
    waterquantity  VARCHAR(3)  NOT NULL,
    coffeequantity VARCHAR(2)  NOT NULL
);
-- DROP TABLE IF EXISTS coffee