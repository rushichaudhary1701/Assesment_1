import javax.servlet.*; import javax.servlet.http.*; import java.io.*;
public class LogoutServlet extends HttpServlet{
protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{
    r.getSession().invalidate();
    s.sendRedirect("login.jsp");
}}