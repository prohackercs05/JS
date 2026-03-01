# PostgreSQL Setup for Slip 12

1. **Login & Create Database:**

```bash
sudo -i -u postgres
createdb testdb
psql testdb
```

2. **Set Password & Create Table:**

```sql
ALTER USER postgres WITH PASSWORD 'root';

CREATE TABLE PROJECT (
    project_id INT PRIMARY KEY,
    Project_name VARCHAR(100),
    Project_description TEXT,
    Project_Status VARCHAR(20)
);
```
