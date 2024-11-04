# Jefe-Hijo DB4o Management System

This Java project demonstrates an object-oriented approach to managing data for "jefes" (bosses) and their associated "hijos" (children) using **DB4o** (Database for Objects). The program includes database operations such as creating, querying, updating, and deleting records, showcasing DB4o’s capabilities for handling object-oriented data.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Class Structure](#class-structure)
- [Database Operations](#database-operations)
- [Example Usage](#example-usage)

---

## Overview

The program stores records of `Jefe` objects, each representing a boss with attributes like name, age, tenure, and an optional associated child (`Hijo`). Using DB4o as the backend, this project demonstrates basic CRUD (Create, Read, Update, Delete) operations and enables object-based querying and updates within a local database file.

## Features

- **DB4o Database Integration**:
  - Uses DB4o to store `Jefe` and `Hijo` objects in an embedded database.
- **CRUD Operations**:
  - Creates new records, modifies specific entries, retrieves records by conditions, and deletes records.
- **Object-Oriented Queries**:
  - Retrieves bosses by attributes like age and tenure, showcasing DB4o’s object-oriented querying system.
- **Object Relationships**:
  - Demonstrates handling of one-to-one relationships, as each `Jefe` may have an associated `Hijo`.

## Class Structure

- **`Main`**:
  - Contains the main logic for initializing and interacting with the database.
  - Manages CRUD operations and retrieves specific sets of data based on requirements.
- **`Jefe`**:
  - Represents a boss with attributes like name, tenure (antiguedad), age, and an optional child.
  - Includes getter and setter methods for each attribute, along with `toString`, `equals`, and `hashCode` methods.
- **`Hijo`**:
  - Represents a child with attributes for name and age.
  - Contains basic methods to access and modify child data, with `toString`, `equals`, and `hashCode` methods.

## Database Operations

1. **Create Records**:
   - Initializes several `Jefe` objects, some with associated `Hijo` objects, and stores them in the DB4o database.

2. **Query Bosses Over 55**:
   - Retrieves and displays all bosses older than 55.

3. **Update Boss Age**:
   - Finds a boss named "Miguel" and increments his age by one year.

4. **Delete Bosses with Over 6 Years of Tenure**:
   - Deletes bosses with a tenure greater than 6 years from the database.

5. **Display All Records**:
   - Retrieves and displays all remaining `Jefe` objects in the database, including associated children, if any.

## Example Usage

The following is an example of how the program’s output might appear:

```plaintext
(Bosses older than 55 years)
----------------------------
Nombre: Dolores, antiguedad: 5, edad: 63, hijo: Sergio, edad: 7
Nombre: Fátima, antiguedad: 5, edad: 63, hijo: Lidia, edad: 27

Age of Miguel has been updated
------------------------------
Nombre: Miguel, antiguedad: 20, edad: 46, hijo: Paula, edad: 3

Proceeding to delete the following records:
-------------------------------------------
Nombre: Ángel, antiguedad: 5, edad: 53, hijo: Gustavo, edad: 7
Nombre: Fátima, antiguedad: 5, edad: 63, hijo: Lidia, edad: 27
...

Current bosses in the database:
--------------------------------
Nombre: Nieves, antiguedad: 3, edad: 45, hijo: Iván, edad: 3
Nombre: Jesús, antiguedad: 3, edad: 5, hijo: Noelia, edad: 3
Nombre: Vicki, antiguedad: 3, edad: 5, hijo: No tiene hijos.
...
```

This example showcases:
- Retrieval of bosses over 55 years old.
- Age update for a specific boss.
- Deletion of bosses with more than 6 years of tenure.
- Display of all remaining bosses and their children, if present.