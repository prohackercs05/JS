# PostgreSQL Setup for Slip 11

Follow these steps on your Ubuntu terminal:

1. **Login & Create Database:**

```bash
sudo -i -u postgres
createdb testdb
psql testdb
```

2. **Set Password & Create Table:**

```sql
ALTER USER postgres WITH PASSWORD 'root';

CREATE TABLE DONAR (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    blood_group VARCHAR(10),
    last_donation_date DATE
);
```

3. **Insert Sample Data:**

```sql
INSERT INTO DONAR VALUES (1, 'Alice', 'B+', '2023-12-05');
INSERT INTO DONAR VALUES (2, 'Joe', 'O+', '2023-11-20');
INSERT INTO DONAR VALUES (3, 'Bob', 'B+', '2024-01-10');
```
