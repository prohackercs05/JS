# PostgreSQL Setup for Slip 7

1. **Login & Create Database:**

```bash
sudo -i -u postgres
createdb testdb
psql testdb
```

2. **Set Password & Create Table:**

```sql
ALTER USER postgres WITH PASSWORD 'root';

CREATE TABLE Product (
    pid INT PRIMARY KEY,
    pname VARCHAR(50),
    price DOUBLE PRECISION
);

-- Sample Data
INSERT INTO Product VALUES (1, 'Laptop', 55000);
INSERT INTO Product VALUES (2, 'Mobile', 15000);
```
