/**This file is implementing the database connectivity and quering functionality.
 * We are both selecting and inserting functionlity into MySQL database
 */
package oopd;
import java.io.*;
import java.sql.*;
public class DBConnection {

    Connection conn = null;

    //This function helps to connect to DB and perfroming the SELECT query    
    public String connectDB() {
        String dboutput = "";

        try {
            //connecting to the database  
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopd?characterEncoding=latin1", "root", "jatin");

            //fetching output from the database
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select inputfile from Graph ");

            while (rs.next()) {
                dboutput += (String.valueOf(rs.getString(1))) + "   ";
            }
        } catch (Exception e) {

        }
        return dboutput;
    }

    //This function performing the UPDATE query into the database
    public void insertToDB(String value1, String value2) throws FileNotFoundException {

        try {
            String sql = "update graph set outputfile = ? where inputfile=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, value1);
            statement.setString(2, value2);
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("output file path for file "+value2+" inserted into db");
            }
        } catch (SQLException s) {}
    }




}