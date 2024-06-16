
import java.sql.*;

public class DataBase {
    public void create()throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/std";
        String username = "root";
        String pass="SQUL123@";
        String query = "create table student( std_reg int primary key,std_name varchar(200),std_email varchar(200),dep varchar(100),phone long);";
        Connection con = DriverManager.getConnection(url, username, pass);

        Statement st = con.createStatement();

       int row =  st.executeUpdate(query);

       System.out.println(row);


    }
    public void read()throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/std";
        String username = "root";
        String pass="SQUL123@";
        String query="select * from student;";
        Connection con = DriverManager.getConnection(url, username, pass);

        Statement st = con.createStatement();
        ResultSet rt = st.executeQuery(query);

        while (rt.next()) {
            
            System.out.println("REGISTER_NUM: "+rt.getInt(1));
            System.out.println("STUDENT_NAME: "+rt.getInt(2));
            System.out.println("STUDENT_EMAIL: "+rt.getInt(3));
            System.out.println("DEPARTMENT: "+rt.getInt(4));
            System.out.println("STUDENT_PHONENUM: "+rt.getInt(5));
        }

        con.close();
        
    }
    public void insert()throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/std";
        String username = "root";
        String pass="SQUL123@";
        String query="insert into student values(?,?,?,?,?);";

        Connection con = DriverManager.getConnection(url, username, pass);

        PreparedStatement pst = con.prepareStatement(query);

        int reg = 1;
        String name="rahul";
        String email ="rahul@gmail.com";
        String dept="cse-iot";
        long ph= 6374992789L;
        pst.setInt(1, reg);
        pst.setString(2, name);
        pst.setString(3, email);
        pst.setString(4, dept);
        pst.setLong(5,ph);

        int row =  pst.executeUpdate();

        System.out.println("Number of rows affected"+row);
    }

    public void insertdata() throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/std";
        String username = "root";
        String pass="SQUL123@";
        String query="INSERT INTO student(std_reg, std_name,std_email, dep, phone) VALUES (2, 'Jane Smith', 'jane@example.com', 'HR', 9876543210), (3, 'Alice Johnson', 'alice@example.com', 'Finance', 5555555555), (4, 'Bob Williams', 'bob@example.com', 'Marketing', 9999999999), (5, 'Emily Brown', 'emily@example.com', 'Sales', 7777777777), (6, 'Michael Davis', 'michael@example.com', 'Operations', 8888888888)";
        Connection con = DriverManager.getConnection(url, username, pass);

        Statement st = con.createStatement();
        int row = st.executeUpdate(query);
        System.out.println(row);
    }
    public void update()throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/std";
        String username = "root";
        String pass="SQUL123@";
        String query="update student set std_name=?,dept=? where std_reg=? ;";
        

        int id = 1;
        String name="R rahul";

        String dept="CSE-IOT";

        Connection con = DriverManager.getConnection(url, username, pass);

        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, name);
        pst.setString(2, dept);
        pst.setInt(3, id);

        int row = pst.executeUpdate();

        System.out.println(row);
    }
    public void delete()throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/std";
        String username = "root";
        String pass="SQUL123@";
        String query="delete from student where std_reg=?";
        

        int id = 1;
        String name="R rahul";

        String dept="CSE-IOT";

        Connection con = DriverManager.getConnection(url, username, pass);

        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, name);
        pst.setString(2, dept);
        pst.setInt(3, id);

        int row = pst.executeUpdate();

        System.out.println(row);
    }


}
