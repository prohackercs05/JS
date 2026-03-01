# PostgreSQL Setup for Slip 10

1. **Login & Create Database:**

```bash
sudo -i -u postgres
createdb testdb
psql testdb
```

2. **Set Password & Create Table:**

```sql
ALTER USER postgres WITH PASSWORD 'root';

CREATE TABLE student (
    rno INT PRIMARY KEY,
    sname VARCHAR(50),
    percentage DOUBLE PRECISION
);
```
