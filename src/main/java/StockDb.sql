Create database if not exists StockMarket;
use StockMarket;
CREATE TABLE if not exists stocks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    price varchar(30)
);
INSERT INTO stocks (name, price) VALUES ('TCS', 3825.50);
INSERT INTO stocks (name, price) VALUES ('INFY', 1532.25);
INSERT INTO stocks (name, price) VALUES ('HDFC', 2810.00);
INSERT INTO stocks (name, price) VALUES ('RELI', 2850.75);
INSERT INTO stocks (name, price) VALUES ('WIPRO', 460.10);
INSERT INTO stocks (name, price) VALUES ('SBIN', 650.35);
INSERT INTO stocks (name, price) VALUES ('ITC', 440.85);
INSERT INTO stocks (name, price) VALUES ('HINDUNILVR', 2650.40);
INSERT INTO stocks (name, price) VALUES ('BAJFINANCE', 7200.00);
INSERT INTO stocks (name, price) VALUES ('ASIANPAINT', 3250.60);
INSERT INTO stocks (name, price) VALUES ('MARUTI', 11240.30);
INSERT INTO stocks (name, price) VALUES ('LT', 3580.90);
INSERT INTO stocks (name, price) VALUES ('AXISBANK', 1125.55);
INSERT INTO stocks (name, price) VALUES ('ICICIBANK', 1050.75);
INSERT INTO stocks (name, price) VALUES ('KOTAKBANK', 1725.10);
INSERT INTO stocks (name, price) VALUES ('HCLTECH', 1465.20);
INSERT INTO stocks (name, price) VALUES ('TECHM', 1330.00);
INSERT INTO stocks (name, price) VALUES ('ULTRACEMCO', 9220.40);
INSERT INTO stocks (name, price) VALUES ('ADANIPORTS', 1325.60);
INSERT INTO stocks (name, price) VALUES ('ADANIENT', 2775.30);
INSERT INTO stocks (name, price) VALUES ('BHARTIARTL', 1010.15);
INSERT INTO stocks (name, price) VALUES ('TITAN', 3755.75);
INSERT INTO stocks (name, price) VALUES ('POWERGRID', 285.60);
INSERT INTO stocks (name, price) VALUES ('JSWSTEEL', 935.20);
INSERT INTO stocks (name, price) VALUES ('BPCL', 580.45);
INSERT INTO stocks (name, price) VALUES ('IOC', 165.85);
INSERT INTO stocks (name, price) VALUES ('COALINDIA', 455.70);
INSERT INTO stocks (name, price) VALUES ('ONGC', 205.25);
INSERT INTO stocks (name, price) VALUES ('NTPC', 320.90);
INSERT INTO stocks (name, price) VALUES ('DRREDDY', 5640.55);
INSERT INTO stocks (name, price) VALUES ('CIPLA', 1285.75);
INSERT INTO stocks (name, price) VALUES ('SUNPHARMA', 1230.40);
INSERT INTO stocks (name, price) VALUES ('DIVISLAB', 4370.10);
INSERT INTO stocks (name, price) VALUES ('BRITANNIA', 5350.65);
INSERT INTO stocks (name, price) VALUES ('NESTLEIND', 23650.90);
INSERT INTO stocks (name, price) VALUES ('BAJAJ-AUTO', 9600.35);
INSERT INTO stocks (name, price) VALUES ('HEROMOTOCO', 3950.15);
INSERT INTO stocks (name, price) VALUES ('EICHERMOT', 4115.60);
INSERT INTO stocks (name, price) VALUES ('HINDALCO', 665.45);
INSERT INTO stocks (name, price) VALUES ('TATASTEEL', 172.80);
INSERT INTO stocks (name, price) VALUES ('SHREECEM', 27400.75);
INSERT INTO stocks (name, price) VALUES ('GRASIM', 2200.40);
INSERT INTO stocks (name, price) VALUES ('BAJAJFINSV', 1735.30);
INSERT INTO stocks (name, price) VALUES ('INDUSINDBK', 1485.95);
INSERT INTO stocks (name, price) VALUES ('SBILIFE', 1440.20);
INSERT INTO stocks (name, price) VALUES ('HDFCLIFE', 680.55);
INSERT INTO stocks (name, price) VALUES ('M&M', 1635.10);
INSERT INTO stocks (name, price) VALUES ('TATAMOTORS', 980.45);
INSERT INTO stocks (name, price) VALUES ('UPL', 645.35);
INSERT INTO stocks (name, price) VALUES ('APOLLOHOSP', 6450.85);
select * from stocks;


create table users (
 username varchar(100) PRIMARY Key,
uname varchar(100),
Email varchar(100),
gender varchar(15),
pass varchar (100),
money varchar(30) DEFAULT "0" 
);

select * from users;
show tables;


create table MyStocks (
username varchar(100),
Stockid int primary key,
price varchar(100),
quantity varchar (100),
FOREIGN KEY (username) REFERENCES users(username),
FOREIGN KEY (Stockid) REFERENCES stocks(id)

);
SELECT 
    users.username,
    mystocks.stockid,
    mystocks.price AS buy_price,
    mystocks.quantity,
    stocks.name AS stock_name,
    stocks.price AS market_price
FROM users
JOIN mystocks ON mystocks.username = users.username
JOIN stocks ON mystocks.stockid = stocks.id
WHERE users.username = "jagan";

create Table history (
username varchar(100)
,hist varchar(500)

);
Select hist from history where username="jagan";
        