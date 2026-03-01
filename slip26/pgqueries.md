# PostgreSQL Setup for Slip 26

1. **Login & Create Database:**

```bash
sudo -i -u postgres
createdb testdb
psql testdb
```

2. **Set Password & Create Table:**

```sql
ALTER USER postgres WITH PASSWORD 'root';

CREATE TABLE employee (
    eno INT PRIMARY KEY,
    ename VARCHAR(50),
    salary DOUBLE PRECISION
);
```
