CREATE DATABASE IF NOT EXISTS FULL;

-- drop user 'full'@'localhost';     sensible a Mayusculas
-- SET PASSWORD FOR  'full'@'localhost' = PASSWORD ('full')

CREATE USER 'full'@'localhost' IDENTIFIED BY 'full';

GRANT ALL PRIVILEGES ON FULL.* TO 'full'@'localhost' [identified by 'full'];

flush privileges;


