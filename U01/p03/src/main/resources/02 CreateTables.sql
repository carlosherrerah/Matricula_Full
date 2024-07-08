-- Base de datos: full
use FULL;

CREATE TABLE employees (
  id_employee int(10) AUTO_INCREMENT PRIMARY KEY,
  last_name varchar(20) NOT NULL,
  first_name varchar(10),
  birth_date date,
  hire_date datetime,
  celular varchar(10),
  active  boolean
);

CREATE TABLE orders (
  id_order int(10) AUTO_INCREMENT PRIMARY KEY,
  id_employee int(10),
  order_date date,
  CONSTRAINT Emp_Ord FOREIGN KEY (id_employee) 
            REFERENCES employees (id_employee)
);

CREATE TABLE products (
  id_product int(10) AUTO_INCREMENT PRIMARY KEY,
  product_name varchar(40),
  unit_price decimal(12,4) check(unit_price > 0)
);

CREATE TABLE orderDetails (
  id_order int(10),
  id_product int(10),
  unit_price decimal(12,4),
  quantity smallint(5),
  discount double,
  CONSTRAINT PRIMARY_KEY PRIMARY KEY(id_order, id_product),
  CONSTRAINT ord_det FOREIGN KEY (id_order)   REFERENCES orders (id_order),
  CONSTRAINT det_pro FOREIGN KEY (id_product) REFERENCES products (id_product)
  );
