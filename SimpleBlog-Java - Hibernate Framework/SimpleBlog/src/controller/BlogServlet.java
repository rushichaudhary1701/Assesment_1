import javax.servlet.*; import javax.servlet.http.*; import java.io.*;
public class BlogServlet extends HttpServlet{
protected void doPost(HttpServletRequest r,HttpServletResponse s)throws IOException{
    int uid=(int)r.getSession().getAttribute("uid");
    new BlogDAO().add(new Blog(
    r.getParameter("title"),
    r.getParameter("content"),
    r.getParameter("tags"),uid));
    s.sendRedirect("viewBlogs.jsp");
}}