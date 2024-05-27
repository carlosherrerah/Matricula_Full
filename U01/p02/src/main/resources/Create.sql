CREATE DATABASE IF NOT EXISTS FULL;

drop user 'full'@'localhost';

CREATE USER 'full'@'localhost' IDENTIFIED BY 'full';

GRANT ALL PRIVILEGES ON FULL.* TO 'full'@'localhost';
