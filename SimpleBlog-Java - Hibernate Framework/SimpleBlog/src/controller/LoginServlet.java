import javax.servlet.*; import javax.servlet.http.*; import java.io.*; import java.sql.*;
public class LoginServlet extends HttpServlet{
protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{
    try{
        ResultSet rs=new UserDAO().login(
        r.getParameter("email"),r.getParameter("password"));
        if(rs.next()){
            HttpSession session=r.getSession();
            session.setAttribute("uid",rs.getInt("id"));
            s.sendRedirect("dashboard.jsp");
        }else s.sendRedirect("login.jsp");
    }catch(Exception e){e.printStackTrace();}
}}