package utilites;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DataBaseOperations {

    public float getSingleFloatValueFromDB(String DBInstanse, String sqlQuery,String columnValue) throws SQLException {

        String connectionString = "jdbc:sqlserver://"+DBInstanse+":1433;databaseName=autoTest;user=user;password=12345";
        Float val = null;

        try (Connection con = DriverManager.getConnection(connectionString); Statement stmt = con.createStatement();) {
            String SQL = sqlQuery;
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString(columnValue));
                val= rs.getFloat(columnValue);
                return val;
                }
        }
                    catch(SQLException e){
                    e.printStackTrace();
                }
        return val;
        }




}


