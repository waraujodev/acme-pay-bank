create table  if not exists customer_service.customers(
    id serial PRIMARY KEY,
    name VARCHAR (50) not null,
    email VARCHAR(100) not null,
    phone VARCHAR(20) not null,
    document VARCHAR(20) not null,
    created_at TIMESTAMP not null,
    updated_at TIMESTAMP
);