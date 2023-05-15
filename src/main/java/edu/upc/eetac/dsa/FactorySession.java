package edu.upc.eetac.dsa;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FactorySession {
    public static Session openSession() {


        Connection conn = getConnection();

        Session session = new SessionImpl(conn);

        return session;
    }


    private static Connection getConnection() {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mariadb://localhost:3306/dsadb?" +
                            "user=root&password=29041986");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
      /*con.createStatement().execute("INSERT INTO user (id,name) VALUES(8,'Nil' ) ");
        con.createStatement().execute("INSERT INTO user (id,name) VALUES(9,'Jose' ) ");*/
        /*ResultSet rs = con.createStatement().executeQuery("SELECT * FROM user");
        System.out.println(rs);
        while (rs.next()){
            System.out.println(rs.getObject(1)+ " " +  rs.getObject(2) + " " +  rs.getObject(3) + " " +  rs.getObject(4));
        }*/
    con.createStatement().execute("DELETE FROM user");
    }

}
