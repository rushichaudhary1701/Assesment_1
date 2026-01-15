import javax.servlet.*; import javax.servlet.http.*; import java.io.*;
public class SearchServlet extends HttpServlet{
protected void doGet(HttpServletRequest r,HttpServletResponse s)throws IOException,ServletException{
    r.setAttribute("blogs",new BlogDAO().search(r.getParameter("q")));
    r.getRequestDispatcher("viewBlogs.jsp").forward(r,s);
}}