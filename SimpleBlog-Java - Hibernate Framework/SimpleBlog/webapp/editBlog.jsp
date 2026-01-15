<%@ page import="dao.BlogDAO,model.Blog" %>
<%
Blog b = new BlogDAO().getById(Integer.parseInt(request.getParameter("id")));
%>
<form action="updateBlog?id=<%=b.getId()%>" method="post">
Title:<input name="title" value="<%=b.getTitle()%>"><br>
Content:<textarea name="content"><%=b.getContent()%></textarea><br>
Tags:<input name="tags" value="<%=b.getTags()%>"><br>
<button>Update</button>
</form>
