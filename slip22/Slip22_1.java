import java.sql.*;
import java.util.Scanner;

public class Slip22_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;

        try {
<<<<<<< HEAD
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");
=======
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "postgres", "root");
>>>>>>> 546047a5172bffb33a481f342c8a0341ce213838

            while (true) {
                System.out.println("\n--- Employee Management Menu ---");
                System.out.println("1. Insert Record");
                System.out.println("2. Update Record");
                System.out.println("3. Display All Records");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ENo: ");
                        int eno = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter EName: ");
                        String ename = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double sal = sc.nextDouble();

                        PreparedStatement pstIns = con
                                .prepareStatement("INSERT INTO employee (eno, ename, salary) VALUES (?, ?, ?)");
                        pstIns.setInt(1, eno);
                        pstIns.setString(2, ename);
                        pstIns.setDouble(3, sal);
                        pstIns.executeUpdate();
                        System.out.println("Inserted successfully.");
                        break;

                    case 2:
                        System.out.print("Enter ENo to update: ");
                        int uEno = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New EName: ");
                        String uName = sc.nextLine();
                        System.out.print("Enter New Salary: ");
                        double uSal = sc.nextDouble();

                        PreparedStatement pstUpd = con
                                .prepareStatement("UPDATE employee SET ename = ?, salary = ? WHERE eno = ?");
                        pstUpd.setString(1, uName);
                        pstUpd.setDouble(2, uSal);
                        pstUpd.setInt(3, uEno);
                        int rows = pstUpd.executeUpdate();
                        if (rows > 0)
                            System.out.println("Updated successfully.");
                        else
                            System.out.println("Employee not found.");
                        break;

                    case 3:
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM employee");
                        System.out.println("\nENo\tEName\tSalary");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
                        }
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        con.close();
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

/*
 * Explanation:
 * This program is a menu-driven application for database operations using JDBC.
 * 1. Switch Case: Handles different operations (Insert, Update, Display, Exit)
 * based on user input.
 * 2. PreparedStatement: Used for Insert and Update queries to safely handle
 * user input.
 * 3. SQL logic:
 * - INSERT adds a new row.
 * - UPDATE modifies existing data based on the primary key (ENo).
 * - SELECT retrieves and prints all records currently stored in the table.
 * 4. Error Handling: Uses try-catch to manage database connection and SQL
 * errors.
 */
