import java.sql.*;

public class App {
  public static void main(String[] args) throws Exception {
    readData();
  }

  public static void readData() throws Exception {
    String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String Password = "SQUL123@";
    String query = "select * from employee";
    Connection con = DriverManager.getConnection(url, username, Password);

    Statement st = con.createStatement();
    ResultSet rt = st.executeQuery(query);

    rt.next();
    System.out.println("ID: " + rt.getInt(1));
    System.out.println("Name: " + rt.getString(2));
    System.out.println("Salary: " + rt.getInt(3));

    con.close();
  }

  public static void insertData() throws Exception {
    String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String Password = "SQUL123@";

    String query = "insert into employee values(7,'RAHUL',10000000)";

    Connection con = DriverManager.getConnection(url, username, Password);

    Statement st = con.createStatement();
    int row = st.executeUpdate(query);

    System.out.println("Number of the rows affected" + row);
  }

  public static void insertVar() throws Exception {

    String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String Password = "SQUL123@";

    int id = 6;

    String name = "IoT";

    int Salary = 15000;

    // String query="insert into employee values("+id+",'"+name+"',"+Salary+")";
    String query = "insert into employee values (?,?,?) ";

    Connection con = DriverManager.getConnection(url, username, Password);

    // int row = st.executeUpdate(query);

    PreparedStatement pst = con.prepareStatement(query);

    pst.setInt(1, id);
    pst.setString(2, name);
    pst.setInt(3, Salary);

    int row = pst.executeUpdate();

    System.out.println("Number of rows affected " + row);
  }

  public static void update() throws Exception {
    String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String query = "update employee set enam=? where epm_id=?";
    String Password = "SQUL123@";

    int id = 5;
    String name = "Jon";

    Connection con = DriverManager.getConnection(url, username, Password);
    // Statement st = con.createStatement();

    PreparedStatement pst = con.prepareStatement(query);
    pst.setString(1, name);
    pst.setInt(2, id);

    int row = pst.executeUpdate();

    System.out.println(row);
  }

  public static void delete() throws Exception {
    String url = "jdbc:mysql://localhost:3306/jdbcdemo";
    String username = "root";
    String query = "delete from employee where epm_id = ?";
    String Password = "SQUL123@";

    int id = 1;

    Connection con = DriverManager.getConnection(url, username, Password);
    PreparedStatement pst = con.prepareStatement(query);
    pst.setInt(1, id);
    int row = pst.executeUpdate();
    System.out.println(row);
  }
}
