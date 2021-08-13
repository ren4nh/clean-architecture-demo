CREATE KEYSPACE IF NOT EXISTS ca_products WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE ca_products;

create table if not exists products(id UUID, name VARCHAR, sku VARCHAR, price DECIMAL, color VARCHAR, primary key(
sku));