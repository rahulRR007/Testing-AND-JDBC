
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.*;

public class Database {
    public void createtable() throws Exception {
        String url = "jdbc:mysql://localhost:3306/model";
        String usernmae = "root";
        String pass = "SQUL123@";
        String query = "create table vehicle( id int primary key, cname varchar(100), year int);";

        Connection con = DriverManager.getConnection(url, usernmae, pass);
        Statement st = con.createStatement();

        int row = st.executeUpdate(query);

        System.out.println(row);
    }

    public void read() throws Exception {
        String url = "jdbc:mysql://localhost:3306/model";
        String username = "root";
        String pass = "SQUL123@";
        String query = "select * from vehicle;";
        Connection con = DriverManager.getConnection(url, username, pass);

        Statement st = con.createStatement();
        ResultSet rt = st.executeQuery(query);

        while (rt.next()) {

            System.out.println("ID: " + rt.getInt(1));
            System.out.println("NAME: " + rt.getString(2));
            System.out.println("YEAR " + rt.getInt(3));

        }

        con.close();

    }

    public void insert(int id, String name, int year)
            throws Exception {
        String url = "jdbc:mysql://localhost:3306/model";
        String username = "root";
        String pass = "SQUL123@";
        String query = "insert into vehicle values(?,?,?);";

        Connection con = DriverManager.getConnection(url, username, pass);

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setInt(3, year);

        int row = pst.executeUpdate();

        System.out.println("Number of rows affected" + row);
    }

    public void update(int id, String name) throws Exception {
        String url = "jdbc:mysql://localhost:3306/model";
        String username = "root";
        String pass = "SQUL123@";
        String query = "update vehicle set cname=? where id=? ;";

        Connection con = DriverManager.getConnection(url, username, pass);

        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, name);
        pst.setInt(2, id);

        int row = pst.executeUpdate();

        System.out.println(row);
    }

    public void delete(int id) throws Exception {
        String url = "jdbc:mysql://localhost:3306/model";
        String username = "root";
        String pass = "SQUL123@";
        String query = "delete from vehicle where id=?";

        Connection con = DriverManager.getConnection(url, username, pass);

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, id);

        int row = pst.executeUpdate();

        System.out.println(row);
    }

}
