import java.sql.*;
public class UserDAO {
    public void register(User u){
        try{
            Connection c=DBConnection.getConnection();
            PreparedStatement ps=c.prepareStatement(
            "INSERT INTO users(name,email,password) VALUES(?,?,?)");
            ps.setString(1,u.getName());
            ps.setString(2,u.getEmail());
            ps.setString(3,u.getPassword());
            ps.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }
    public ResultSet login(String email,String pass)throws Exception{
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement(
        "SELECT * FROM users WHERE email=? AND password=?");
        ps.setString(1,email); ps.setString(2,pass);
        return ps.executeQuery();
    }
}