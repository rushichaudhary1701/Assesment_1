<%@ page import="dao.BlogDAO,model.Blog" %>
<%
Blog b = new BlogDAO().getById(Integer.parseInt(request.getParameter("id")));
%>
<h2><%=b.getTitle()%></h2>
<p><%=b.getContent()%></p>
<p>Tags: <%=b.getTags()%></p>
<a href="editBlog.jsp?id=<%=b.getId()%>">Edit</a>
