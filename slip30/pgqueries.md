# PostgreSQL Setup for Slip 30

1. **Login & Create Database:**

```bash
sudo -i -u postgres
createdb testdb
psql testdb
```

2. **Set Password & Create Table:**

```sql
ALTER USER postgres WITH PASSWORD 'root';

CREATE TABLE Teacher (
    TNo INT PRIMARY KEY,
    TName VARCHAR(50),
    Subject VARCHAR(50)
);
```
