<%@ page import="dao.BlogDao" %>
<%@ page import="dao.impl.BlogDaoImpl" %>
<%@ page import="entities.Blog" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: ankur
  Date: 28/6/17
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="body">
<%
    int y = 1;
    //ServletContext context = request.getServletContext();
    String name = (String)session.getAttribute("savesUserName");
    BlogDao blogDao = new BlogDaoImpl();
    List blogs = blogDao.getuserblogs(name);
%>
<div align="center" style="color: white;font-size: 40px;margin: 20px">

    <h1>
        Welcome
        <%=name%>
 <%--       <%=blog.getBlogdata()%>--%>
    </h1>
</div>
<div align="right">
    <form method="post" action="logout">
        <button type="submit" style="font-size: 20px;margin-right: 40px;margin-top: 0px">LogOut</button>
    </form>
</div>
<div class="container" style="width: 70%">
    <div id="division1" class="col-md-5 col-sm-5">
        <div style="padding-right: 0;">
            <div class="dynamicDiv" style="margin-bottom:15px;">
                <div class="dynamicDivHead">
                    <p class="phead">Create Blog</p>
                </div>
                <form class="form-horizontal" id="blogForm" style="padding:10px; margin-bottom: -15px" action="blog" method="post">
                    <div class="form-group" style="margin-bottom: 10px">
                        <label class="control-label col-sm-2">Text-Area:</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" placeholder="Enter your blog here" name="blog" required></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-5 pull-right">
                            <button type="submit" class="btn btn-default" style="margin: 0px" form="blogForm">create</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>

    <div id="division2" class="col-md-7 col-sm-7">
        <div style="padding-right: 0;">
            <div class="dynamicDiv" style="margin-bottom:15px;">
                <div class="dynamicDivHead">
                    <p class="phead">Your Blogs</p>
                </div>
                <div name="userprofileBlogs" style="padding: 7px">
                    <% for (int i = 0 ; i<blogs.size();i++) {%>
                    <span style="float: left;margin-right: 3px;font-weight: bold"><%=y++%></span>
                    <span style="float: left"><%=blogs.get(i)%></span>
                    <br>
                    <% }%>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
