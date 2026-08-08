# Hibernate Learning Repository

A hands-on repository for learning and practicing **Hibernate ORM with Java**.

This project contains practical examples and exercises covering the core concepts of Hibernate, from basic configuration and CRUD operations to entity relationships, HQL, JPQL, transactions, and database integration.

## 📚 About

**Hibernate** is a popular Object-Relational Mapping (ORM) framework for Java applications. It simplifies database interaction by allowing Java objects to be mapped to database tables.

The purpose of this repository is to understand Hibernate concepts through practical examples rather than only theoretical learning.

## 🎯 Learning Objectives

* Understand the fundamentals of Hibernate ORM
* Configure Hibernate with a Java application
* Connect Java applications with relational databases
* Perform CRUD operations using Hibernate
* Understand entity mapping
* Work with primary keys and generated IDs
* Understand Hibernate sessions and session factories
* Learn Hibernate Query Language (HQL)
* Learn Java Persistence Query Language (JPQL)
* Implement entity relationships
* Understand transactions
* Explore lazy and eager loading
* Understand the Hibernate persistence lifecycle

## 🛠️ Technologies

* **Java**
* **Hibernate ORM**
* **JPA / Jakarta Persistence**
* **JDBC**
* **MySQL**
* **Maven**
* **IntelliJ IDEA / Eclipse**

## 📂 Topics Covered

### 1. Hibernate Basics

* Hibernate introduction
* ORM concepts
* Hibernate architecture
* Hibernate configuration
* SessionFactory
* Session
* Transaction

### 2. Entity Mapping

* `@Entity`
* `@Table`
* `@Id`
* `@GeneratedValue`
* `@Column`
* Primary key mapping
* Database table mapping

### 3. CRUD Operations

* Create
* Read
* Update
* Delete
* Persisting Java objects
* Retrieving entities

### 4. Relationships

* One-to-One
* One-to-Many
* Many-to-One
* Many-to-Many
* Foreign key mapping
* Join tables

### 5. Querying

* HQL
* JPQL
* Query parameters
* Filtering
* Sorting
* Joins

### 6. Transactions

* Transaction management
* Commit
* Rollback
* Transaction boundaries

### 7. Fetching & Performance

* Lazy loading
* Eager loading
* Fetch strategies
* N+1 query problem

## 🏗️ Project Structure

```text
hibernate-learning/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── ...
│   │
│   └── resources/
│       └── ...
│
├── pom.xml
└── README.md
```

> The structure may evolve as new Hibernate concepts and examples are added.

## ⚙️ Prerequisites

Make sure you have the following installed:

* Java JDK
* Maven
* MySQL
* An IDE such as IntelliJ IDEA or Eclipse

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/hibernate-learning.git
```

### 2. Navigate to the Project

```bash
cd hibernate-learning
```

### 3. Configure the Database

Create a MySQL database and update the Hibernate/database configuration with your credentials.

Example:

```properties
hibernate.connection.url=jdbc:mysql://localhost:3306/hibernate_db
hibernate.connection.username=root
hibernate.connection.password=your_password
```

### 4. Build the Project

```bash
mvn clean install
```

### 5. Run the Examples

Run the relevant Java classes from your IDE or using Maven.

## 🧠 Key Concepts

The repository focuses on understanding how this:

```text
Java Object
     ↓
Hibernate ORM
     ↓
SQL
     ↓
Relational Database
```

works in practice.

For example:

```java
Student student = new Student();

student.setName("John");
student.setAge(22);

session.persist(student);
```

Hibernate handles the conversion between the Java object and the corresponding database record.

## 📈 Learning Progress

* [x] Hibernate fundamentals
* [x] Hibernate configuration
* [x] Entity mapping
* [x] CRUD operations
* [ ] Entity relationships
* [ ] HQL
* [ ] JPQL
* [ ] Transactions
* [ ] Lazy & eager loading
* [ ] Hibernate caching
* [ ] Advanced mappings
* [ ] Performance optimization

## 🔮 Future Learning

This repository may be expanded with:

* Spring Data JPA
* Spring Boot + Hibernate
* Advanced JPA mappings
* Criteria API
* Hibernate caching
* Query optimization
* Database performance
* Hibernate with REST APIs

## 📖 Purpose

This repository is created as part of my journey to strengthen my **Java backend development and ORM fundamentals** through practical implementation.

Each example is intended to build a stronger understanding of how Java applications communicate with relational databases using Hibernate.

---

⭐ If you find this repository useful, feel free to explore the examples and learn along with me.
