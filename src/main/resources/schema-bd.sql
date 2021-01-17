DROP TABLE IF EXISTS customer;

CREATE TABLE customer  (
    id Bigserial PRIMARY KEY NOT NULL,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);

CREATE TABLE pricequote  (
    id Bigserial PRIMARY KEY NOT NULL,
    tube_assembly_id VARCHAR,
    supplier VARCHAR,
    quote_date DATE,
    annual_usage VARCHAR,
    min_order_quantity VARCHAR,
    bracket_pricing VARCHAR,
    quantity VARCHAR,
    cost VARCHAR
);