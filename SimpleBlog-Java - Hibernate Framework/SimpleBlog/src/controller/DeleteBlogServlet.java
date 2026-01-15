import javax.servlet.*; import javax.servlet.http.*; import java.io.*;
public class DeleteBlogServlet extends HttpServlet{
protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException{
    new BlogDAO().delete(Integer.parseInt(r.getParameter("id")),
    (int)r.getSession().getAttribute("uid"));
    s.sendRedirect("viewBlogs.jsp");
}}