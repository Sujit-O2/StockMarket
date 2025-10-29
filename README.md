# 📊 Stock Market – Java Swing Trading Simulator

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=java)](https://www.oracle.com/java/)
[![GUI](https://img.shields.io/badge/GUI-Swing-blue?style=flat-square)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![Database](https://img.shields.io/badge/Database-MySQL-green?style=flat-square&logo=mysql)](https://www.mysql.com/)
[![License: MIT](https://img.shields.io/github/license/Sujit-O2/StockMarket?style=flat-square)](LICENSE)
[![Repo Size](https://img.shields.io/github/repo-size/Sujit-O2/StockMarket?style=flat-square)](https://github.com/Sujit-O2/StockMarket)
[![Last Commit](https://img.shields.io/github/last-commit/Sujit-O2/StockMarket?style=flat-square)](https://github.com/Sujit-O2/StockMarket/commits/main)
[![Stars](https://img.shields.io/github/stars/Sujit-O2/StockMarket?style=flat-square)](https://github.com/Sujit-O2/StockMarket/stargazers)
[![Forks](https://img.shields.io/github/forks/Sujit-O2/StockMarket?style=flat-square)](https://github.com/Sujit-O2/StockMarket/network/members)

A **modern, GUI-based stock trading simulator** built with **Java Swing** and **MySQL**.  
Manage accounts, view market prices, execute trades, track your portfolio, and review transaction history — all from an interactive interface.

---

## ✨ Features :


- 🔐 **User Authentication** – Sign up & log in securely  
- 📈 **Market Overview** – View simulated stock prices with live updates  
- 💹 **Buy & Sell** – Execute trades at current prices  
- 📂 **Portfolio Tracking** – View your holdings and profits/losses  
- 🕘 **Transaction History** – Review all past trades  
- 🗄 **Database Support** – Persistent storage with MySQL & JDBC  

---

## 🛠 Tech Stack

| Component     | Technology |
|---------------|------------|
| **Language**  | Java (Core + OOP) |
| **GUI**       | Swing (javax.swing) |
| **Database**  | MySQL + JDBC |
| **Architecture** | MVC-based modular design |

---

## 📂 Project Structure

.
├── Login.java # User login handling
├── signUp.java # User registration
├── Market.java # Displays stock market data
├── SQLStocks.java # MySQL database operations
├── Stock.java # Stock model class
├── StockBuyed.java # Purchased stock representation
├── yourStocks.java # Displays user's owned stocks
├── history.java # Transaction history view
└── User.java # User model class

yaml
Copy
Edit

---

## ⚙️ Setup & Run

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Sujit-O2/StockMarket.git
cd StockMarket
2️⃣ Configure MySQL Database
sql
Copy
Edit
CREATE DATABASE stockdb;
USE stockdb;
-- Create necessary tables for users, stocks, and transactions
Update credentials in SQLStocks.java:

java
Copy
Edit
String url = "jdbc:mysql://localhost:3306/stockdb";
String username = "root";
String password = "yourpassword";
3️⃣ Compile & Run
bash
Copy
Edit
javac *.java
java Login
📈 Example Workflow
🆕 Sign Up → Create a new account

🔑 Login → Access your trading dashboard

📊 View Market → Check live stock prices

💹 Buy/Sell → Execute trades

📂 Your Stocks → Monitor portfolio performance

🕘 History → Review trade logs

🧠 OOP Principles Used
Encapsulation – Secure field access with getters/setters

Abstraction – Hide DB logic behind service classes

Polymorphism – Flexible trade handling

Modularity – Separate UI, logic, and data layers

🚀 Future Enhancements
🔄 Real-time market data from APIs

📊 Charts & graphs for portfolio visualization

🔐 Encrypted password storage

💾 Offline mode with file-based persistence

📜 License
This project is licensed under the MIT License – free to use and modify.

Made with ❤️ by Sujit-O2
