import java.sql.*;
public class DBConnection {
    private static Connection con;
    private DBConnection(){}
    public static Connection getConnection(){
        if(con==null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/simpleblog","root","password");
            }catch(Exception e){e.printStackTrace();}
        }
        return con;
    }
}