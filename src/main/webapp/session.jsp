<%-- 
    Document   : session
    Created on : 2018/12/17, 下午 03:43:06
    Author     : user
--%>

<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
             DataSource ds = (DataSource)application.getAttribute("cp");
             Connection conn  =ds.getConnection();
             Statement stmt=conn.createStatement();
             ResultSet rs=stmt.executeQuery("Select * from LOGIN");
             while(rs.next()){
                 out.println(rs.getString("ID")+"<br/>");
             }
        %>
    </body>
</html>
