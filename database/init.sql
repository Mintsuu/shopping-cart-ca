-- Delete any existing tables (to reset the database from scratch)
DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS shoppingcart_item;
DROP TABLE IF EXISTS shoppingcart;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS users;

-- Create ShoppingCart table
CREATE TABLE shoppingcart (
  id INT AUTO_INCREMENT PRIMARY KEY,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create User table
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  shopping_cart_id INT UNIQUE NOT NULL,
  handphone_no VARCHAR(20),
  address VARCHAR(255),
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50),
  FOREIGN KEY (shopping_cart_id) REFERENCES shoppingcart(id)
);
-- Create Product table
CREATE TABLE product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  image VARCHAR(500), 
  unit_price FLOAT NOT NULL,
  category VARCHAR(100),
  stock INT NOT NULL
);
-- Create Order table
CREATE TABLE orders (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  fulfilment_date DATE,
  status VARCHAR(50),
  payment_method VARCHAR(50),
  total_amount FLOAT NOT NULL, 
  create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);
-- Create OrderItem table (junction table for Order and Product)
CREATE TABLE order_item (
  id INT AUTO_INCREMENT PRIMARY KEY,
  order_id INT,
  product_id INT,
  quantity INT NOT NULL,
  transacted_unit_price FLOAT NOT NULL, -- Store price at the time of order
  FOREIGN KEY (order_id) REFERENCES orders(id),
  FOREIGN KEY (product_id) REFERENCES product(id)
);
-- Create ShoppingCartItems table (junction table for ShoppingCart and Product)
CREATE TABLE shoppingcart_item (
  id INT AUTO_INCREMENT PRIMARY KEY,
  product_id INT,
  shopping_cart_id INT,
  quantity INT NOT NULL,
  FOREIGN KEY (shopping_cart_id) REFERENCES shoppingcart(id),
  FOREIGN KEY (product_id) REFERENCES product(id)
);

-- =============================================
-- product Table (50 entries)
-- =============================================
INSERT INTO product (id, name, unit_price, category, stock) VALUES
(1, 'Laptop Pro X1', 1499.99, 'Electronics', 50),
(2, 'Wireless Optical Mouse', 24.50, 'Electronics', 200),
(3, 'Mechanical Keyboard RGB', 89.90, 'Electronics', 150),
(4, '4K Ultra HD Monitor 27 inch', 349.00, 'Electronics', 75),
(5, 'USB-C Hub Adapter', 35.00, 'Electronics', 300),
(6, 'Organic Whole Bean Coffee 1kg', 18.75, 'Groceries', 500),
(7, 'Artisan Sourdough Bread', 6.50, 'Groceries', 100),
(8, 'Fresh Orange Juice 1L', 4.20, 'Groceries', 250),
(9, 'Imported Cheddar Cheese 200g', 7.80, 'Groceries', 180),
(10, 'Natural Spring Water 6x1.5L', 5.99, 'Groceries', 400),
(11, 'Mens Cotton T-Shirt - Blue', 19.95, 'Clothing', 300),
(12, 'Womens Running Shoes - Size 7', 75.00, 'Clothing', 120),
(13, 'Classic Denim Jeans - W32 L32', 55.00, 'Clothing', 160),
(14, 'Silk Scarf - Floral Pattern', 29.50, 'Clothing', 90),
(15, 'Leather Belt - Brown', 40.00, 'Clothing', 200),
(16, 'The Midnight Library Novel', 15.99, 'Books', 250),
(17, 'Introduction to Python Programming', 45.50, 'Books', 100),
(18, 'World Atlas Geographic', 32.00, 'Books', 80),
(19, 'Cookbook: Quick Weeknight Meals', 22.80, 'Books', 150),
(20, 'Childrens Picture Book: The Lost Star', 12.99, 'Books', 300),
(21, 'Stainless Steel Cookware Set', 199.00, 'Home Goods', 60),
(22, 'Memory Foam Pillow', 49.99, 'Home Goods', 180),
(23, 'Bamboo Bath Towel Set - Grey', 38.50, 'Home Goods', 220),
(24, 'LED Desk Lamp with USB Port', 28.00, 'Home Goods', 140),
(25, 'Aroma Therapy Diffuser', 33.25, 'Home Goods', 190),
(26, 'Smartphone Holder for Car', 14.99, 'Accessories', 400),
(27, 'Portable Bluetooth Speaker', 65.00, 'Electronics', 110),
(28, 'Gaming Headset with Mic', 79.95, 'Electronics', 95),
(29, 'Webcam Full HD 1080p', 55.00, 'Electronics', 130),
(30, 'External SSD 1TB', 120.00, 'Electronics', 85),
(31, 'Gluten-Free Pasta 500g', 3.90, 'Groceries', 350),
(32, 'Organic Mixed Nuts 250g', 9.50, 'Groceries', 280),
(33, 'Extra Virgin Olive Oil 500ml', 12.75, 'Groceries', 210),
(34, 'Dark Chocolate Bar 70%', 4.50, 'Groceries', 600),
(35, 'Herbal Tea Selection Box', 8.99, 'Groceries', 320),
(36, 'Mens Wool Sweater - Grey', 85.00, 'Clothing', 100),
(37, 'Womens Yoga Pants - Black M', 39.99, 'Clothing', 170),
(38, 'Kids Rain Jacket - Yellow Age 5', 30.00, 'Clothing', 130),
(39, 'Sports Socks - 3 Pack', 12.50, 'Clothing', 400),
(40, 'Canvas Tote Bag - Natural', 9.90, 'Accessories', 500),
(41, 'Sci-Fi Anthology: Distant Suns', 18.50, 'Books', 110),
(42, 'History of Ancient Rome', 38.00, 'Books', 70),
(43, 'Gardening for Beginners Guide', 21.00, 'Books', 160),
(44, 'Mindfulness and Meditation Handbook', 16.75, 'Books', 200),
(45, 'Graphic Novel: Cyber City', 25.00, 'Books', 90),
(46, 'Non-Stick Frying Pan 10 inch', 29.95, 'Home Goods', 150),
(47, 'Electric Kettle 1.7L', 42.00, 'Home Goods', 120),
(48, 'Wall Clock Modern Design', 35.50, 'Home Goods', 100),
(49, 'Set of 4 Ceramic Mugs', 26.00, 'Home Goods', 250),
(50, 'Plush Throw Blanket - Cream', 31.80, 'Home Goods', 180);