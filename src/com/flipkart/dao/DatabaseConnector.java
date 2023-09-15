package com.flipkart.dao;

import com.flipkart.dao.GymOwnerDaoInterface;
import com.flipkart.dao.GymOwnerDAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Create a new connection if it doesn't exist or is closed
            String url = "jdbc:mysql://localhost/flipfit";;
            String username = "root";
            String password = "Fk!_197981";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}

//
//
//public class DatabaseConnector {
//
//
//
//    GymOwnerDaoInterface gymOwnerService = new GymOwnerDAOImplementation();
//    pu
//
//    public static void main(String[] args) {
//        // JDBC database URL, username, and password of the database
//        String jdbcUrl = "jdbc:mysql://localhost/flipfit"; // Replace with your actual database URL
//        String jdbcUsername = "root"; // Replace with your database username
//        String jdbcPassword = "Fk!_197981"; // Replace with your database password
//
//        // Initialize connection, statement, and result set
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            // 1. Register the JDBC driver (if you haven't already)
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // 2. Connect to the database
//            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
//
//            // 3. Create a SQL statement
//            statement = connection.createStatement();
//
//            // 4. Execute the SQL query to retrieve all data
//            String sqlQuery = "SELECT * FROM gym_owner";
//            resultSet = statement.executeQuery(sqlQuery);
//
//            // 5. Process the results and print them
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String email = resultSet.getString("email");
//                String name = resultSet.getString("name");
//                String password = resultSet.getString("password");
//                String phoneNumber = resultSet.getString("phone_number");
//                String pancard = resultSet.getString("pancard");
//                String aadhar = resultSet.getString("aadhar");
//                String gst = resultSet.getString("gst");
//
//                // Print the data or perform any other operations you need
//                System.out.println("ID: " + id);
//                System.out.println("Email: " + email);
//                System.out.println("Name: " + name);
//                System.out.println("Password: " + password);
//                System.out.println("Phone Number: " + phoneNumber);
//                System.out.println("Pancard: " + pancard);
//                System.out.println("Aadhar: " + aadhar);
//                System.out.println("GST: " + gst);
//                System.out.println("---------------------------------");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // 6. Close the resources
//            try {
//                if (resultSet != null) resultSet.close();
//                if (statement != null) statement.close();
//                if (connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class DatabaseConnector {
//
//    // Step 1
//    // JDBC driver name and database URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost/test";
//
//    //  Database credentials
//    static final String USER = "root";
//    static final String PASS = "Fk!_197981";
//
//
//
//    public static void main(String[] args) {
//
//        // Step 2
//        // Declare the Coneection or prepaidstatement variable here
//        Connection conn = null;
//        PreparedStatement stmt = null;
//
//        try{
//
//            // Step 3 Regiater Driver here and create connection
//
//            Class.forName("com.mysql.jdbc.Driver");
//
//            // Step 4 make/open  a connection
//
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
//            String sql="insert into employee values(?,?,?,?)";
//            //String sql = "UPDATE Employees set age=? WHERE id=?";
//            // String sql1="delete from employee where id=?";
//            // stmt.setInt(1, 101);
//            stmt = conn.prepareStatement(sql);
//
//            // Hard coded data
//
//            int id=627;
//            String name="Vabhav";
//            String address="Delhi";
//            String location="india";
//            //Bind values into the parameters.
//            stmt.setInt(1, id);  // This would set age
//            stmt.setString(2,name);
//            stmt.setString(3, address);
//            stmt.setString(4, location);
//            stmt.executeUpdate();
//
//
//			   /*
//
//			   // Let us update age of the record with ID = 102;
//			      int rows = stmt.executeUpdate();
//			      System.out.println("Rows impacted : " + rows );
//
//			      // Let us select all the records and display them.
//			      sql = "SELECT id, name ,address, location FROM employeefc";
//			      ResultSet rs = stmt.executeQuery(sql);
//
//			      //STEP 5: Extract data from result set
//			      while(rs.next()){
//			         //Retrieve by column name
//			         int eid  = rs.getInt("id");
//			         String name1 = rs.getString("name");
//			         String address1 = rs.getString("address");
//			         String location1 = rs.getString("location");
//
//			         //Display values
//			         System.out.print("ID: " + eid);
//			         System.out.print(", Age: " + name1);
//			         System.out.print(", First: " + address1);
//			         System.out.println(", Last: " + location1);
//			      }*/
//            //STEP 6: Clean-up environment
//            // rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            //Handle errors for JDBC
//            se.printStackTrace();
//        }catch(Exception e){
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        }finally{
//            //finally block used to close resources
//            try{
//                if(stmt!=null)
//                    stmt.close();
//            }catch(SQLException se2){
//            }// nothing we can do
//            try{
//                if(conn!=null)
//                    conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }//end finally try
//        }//end try
//        System.out.println("Goodbye!");
//    }//end main
//
//
//
//
//}


