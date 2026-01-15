<%@ page import="java.util.*,model.Blog,dao.BlogDAO" %>
<%
List<Blog> blogs = (List<Blog>)request.getAttribute("blogs");
if(blogs==null){
    blogs = new BlogDAO().getAll();
}
for(Blog b: blogs){
%>
<h3><a href="viewBlog.jsp?id=<%=b.getId()%>"><%=b.getTitle()%></a></h3>
<p><%=b.getTags()%></p>
<a href="deleteBlog?id=<%=b.getId()%>">Delete</a>
<hr>
<% } %>
