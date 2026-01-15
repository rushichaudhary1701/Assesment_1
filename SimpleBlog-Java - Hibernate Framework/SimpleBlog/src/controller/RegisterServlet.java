import javax.servlet.*; import javax.servlet.http.*; import java.io.*;
public class RegisterServlet extends HttpServlet{
protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{
    new UserDAO().register(new User(
    r.getParameter("name"),
    r.getParameter("email"),
    r.getParameter("password")));
    s.sendRedirect("login.jsp");
}}