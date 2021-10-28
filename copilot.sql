// create users table
CREATE TABLE users (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  username TEXT,
  password TEXT,
  email TEXT,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

// create products table
CREATE TABLE products (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT,
  description TEXT,
  price INTEGER,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

// create a plsql function
CREATE OR REPLACE FUNCTION add_product(
  p_name TEXT,
  p_description TEXT,
  p_price INTEGER
) RETURNS INTEGER AS $$
DECLARE
  id INTEGER;
BEGIN
    INSERT INTO products (name, description, price)
    VALUES (p_name, p_description, p_price);
    id := last_insert_rowid();
    RETURN id;
    END;
$$ LANGUAGE plpgsql;


