USE northwind;

-- Show categories in products table
SELECT category
FROM products;

-- Show products that are made by Dell
SELECT *
FROM products
WHERE product_name LIKE '%Dell%';

-- Show all orders that have been shipped to Pennsylvania
SELECT *
FROM orders
WHERE ship_state = 'Pennsylvania';

-- Show the first and last names of employees that has a last name that starts with a W
SELECT first_name, last_name
FROM employees
WHERE last_name LIKE 'W%';

-- Show all customers from zip codes that start with 55
SELECT *
FROM customers
WHERE postal_code LIKE '55%';

-- Show all customers from zip codes that end with a 0
SELECT * 
FROM customers
WHERE postal_code LIKE '%0';

-- Show the first, last name and email for all customers who have .org as an email address
SELECT first_name, last_name, email
FROM customers
WHERE email LIKE '%.org';

-- Show the first, last name and phone number for all customers with a 202 area code
SELECT first_name, last_name, phone
FROM customers
WHERE phone LIKE '%(202)%';

-- Show the first, last name and phone number for all customers with a 202 area code
-- Ordering by last name and first name
SELECT first_name, last_name, phone
FROM customers
WHERE phone LIKE '%(202)%'
ORDER BY last_name, first_name;