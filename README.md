# 🏥 Hospital Management System (Java + MySQL Console)

A simple console-based Hospital Management System developed using Java and MySQL. This application allows you to add, view, and check doctor and patient details via the command line.

---

## 🚀 Features

- Add Doctor (Name, Age, Gender, Specialization)
- View All Doctors
- Check Doctor by ID
- Add Patient (Name, Age, Gender, Disease)
- View All Patients
- Check Patient by ID

---

## 🛠️ Technologies Used

- Java (Console-based)
- MySQL (for data storage)
- JDBC (for Java-MySQL connection)
  
---

##⚙️ How to Run

javac -cp ".;lib/mysql-connector-j-9.3.0.jar" *.java
java -cp ".;lib/mysql-connector-j-9.3.0.jar" Main

---

##📌 Note

> Make sure MySQL server is running locally.
> Database credentials are located in DBConnection.java. Update if needed:
DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "your_password");

## MySQL Database Setup

```sql
CREATE DATABASE hospital;

USE hospital;

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    specialization VARCHAR(100)
);

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    disease VARCHAR(100)
);

---

========= Hospital Management System =========
1. Add Doctor
2. View Doctors
3. Check Doctor
4. Add Patient
5. View Patients
6. Check Patient
7. Exit
Enter your choice:




