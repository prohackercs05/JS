# Java Slips Completion Summary

This document provides an overview of all 30 Java Slips completed. All files are located in:  
`c:\Tomcat\apache-tomcat-9.0.115-windows-x64\apache-tomcat-9.0.115\webapps\JavaSlips\`

## Database Configuration

All database-related programs use the following credentials:

- **DB Name:** `testdb`
- **Username:** `postgres`
- **Password:** `root`
- **Driver:** `org.postgresql.Driver` (PostgreSQL JDBC Driver)

---

## Slip Index

| Slip   | Q1: Core / CLI / Collections | File                    | Q2: Swing / JDBC / Web            | File                    |
| :----- | :--------------------------- | :---------------------- | :-------------------------------- | :---------------------- |
| **1**  | Alphabet delay (A-Z)         | `Slip1_1.java`          | Employee Database Entry           | `Slip1_2.java`          |
| **2**  | HashSet friend names         | `Slip2_1.java`          | Request/Server Info Servlet       | `Slip2_2.java`          |
| **3**  | Patient details JSP          | `Slip3_1.jsp`           | LinkedList operations             | `Slip3_2.java`          |
| **4**  | Blinking text Thread         | `Slip4_1.java`          | City STD codes HashMap            | `Slip4_2.java`          |
| **5**  | Student Hashtable            | `Slip5_1.java`          | Random MCQ Quiz JSP               | `Slip5_2.jsp`           |
| **6**  | TreeSet search               | `Slip6_1.java`          | Traffic Signal Swing              | `Slip6_2.java`          |
| **7**  | Square/Cube Thread           | `Slip7_1.java`          | Product Table JDBC                | `Slip7_2.java`          |
| **8**  | Print text N times Thread    | `Slip8_1.java`          | Prime number check JSP            | `Slip8_2.jsp`           |
| **9**  | Moving Ball Swing            | `Slip9_1.java`          | Spring Message Bean               | `Slip9_2.java`          |
| **10** | Spring Date Bean             | `Slip10_1.java`         | Student Record Swing              | `Slip10_2.java`         |
| **11** | Customer Search Servlet      | `Slip11_1_Servlet.java` | Donor Table Metadata              | `Slip11_2.java`         |
| **12** | Perfect number @include      | `Slip12_1.jsp`          | Project Table JTable              | `Slip12_2.java`         |
| **13** | Database Metadata List       | `Slip13_1.java`         | Thread Lifecycle                  | `Slip13_2.java`         |
| **14** | Multi-threaded Search        | `Slip14_1.java`         | First/Last Digit Sum JSP          | `Slip14_2.jsp`          |
| **15** | Thread Name/Priority         | `Slip15_1.java`         | Visit Counter Cookie              | `Slip15_2.java`         |
| **16** | TreeSet Colors               | `Slip16_1.java`         | Teacher Table PreparedStatement   | `Slip16_2.java`         |
| **17** | Unique Sorted Integers       | `Slip17_1.java`         | Count 1-100 TextField             | `Slip17_2.java`         |
| **18** | Thread Priority Set          | `Slip18_1.java`         | Student Result Servlet            | `Slip18_2_Servlet.java` |
| **19** | Negative Ints LinkedList     | `Slip19_1.java`         | Database Login Servlet            | `Slip19_2_Servlet.java` |
| **20** | Number to Words JSP          | `Slip20_1.jsp`          | Blinking Image Swing              | `Slip20_2.java`         |
| **21** | Subjects Iterator            | `Slip21_1.java`         | Producer-Consumer Synchronization | `Slip21_2.java`         |
| **22** | Employee Menu JDBC           | `Slip22_1.java`         | Greeting Time JSP                 | `Slip22_2.jsp`          |
| **23** | Vowels delay 3s              | `Slip23_1.java`         | CLI Names ListIterator            | `Slip23_2.java`         |
| **24** | Scrolling Text Swing         | `Slip24_1.java`         | Redirect Login Logic              | `Slip24_2.jsp`          |
| **25** | Voter Eligibility JSP        | `Slip25_1.jsp`          | DDL Query Executor Swing          | `Slip25_2.java`         |
| **26** | Delete Employee CLI          | `Slip26_1.java`         | First/Last Digit Sum JSP          | `Slip26_2.jsp`          |
| **27** | Table Metadata Servlet       | `Slip27_1_Servlet.java` | Reverse LinkedList ListIterator   | `Slip27_2.java`         |
| **28** | Current Thread Name          | `Slip28_1.java`         | Multiplication Table JSP          | `Slip28_2.jsp`          |
| **29** | Table Meta Standalone        | `Slip29_1.java`         | Sum/Average LinkedList            | `Slip29_2.java`         |
| **30** | Deadlock Demonstration       | `Slip30_1.java`         | Teacher List Statement            | `Slip30_2.java`         |

---

## Execution Instructions

### 1. Core Java & Swing Programs

To compile and run standalone Java files (like `Slip13_1` or `Slip25_2`):

```cmd
javac -cp ".;postgresql-42.x.x.jar" FileName.java
java -cp ".;postgresql-42.x.x.jar" FileName
```

### 2. Servlets

1. Compile the Servlet file (`javac -cp ".;C:\path\to\servlet-api.jar" ServletName.java`).
2. Move the `.class` file to `WEB-INF/classes/`.
3. Configure the mapping in `WEB-INF/web.xml`.
4. Run Tomcat and access via: `http://localhost:8080/JavaSlips/ServletName`

### 3. JSP Pages

Simply place the `.jsp` files in the `JavaSlips` directory and access them via browser:
`http://localhost:8080/JavaSlips/SlipNumber.jsp`

### 4. Spring Programs

Ensure the Spring JARs are in the classpath during compilation and runtime. Use the corresponding `Beans.xml` files provided in the directory.

---

**Summary Completed Successfully.**
