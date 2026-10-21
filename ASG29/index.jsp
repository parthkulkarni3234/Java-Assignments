<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%!
    // JSP DECLARATION: becomes a member of the generated servlet class
    private int visitCount = 0;
    private String greeting(int hour) {
        if (hour < 12) return "Good Morning";
        else if (hour < 17) return "Good Afternoon";
        return "Good Evening";
    }
%>
<%
    // JSP SCRIPTLET: plain Java inside _jspService()
    visitCount++;
    Date now = new Date();
    int hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Assignment 29 - JSP Basics</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="card">
    <h2>Assignment 29 : JSP Basics</h2>
    <p><%= greeting(hour) %>! Current server time: <b><%= now %></b></p>
    <p>This page has been visited <b><%= visitCount %></b> time(s) since server start.</p>

    <h3>Implicit objects demo</h3>
    <table>
        <tr><th>request.getMethod()</th><td><%= request.getMethod() %></td></tr>
        <tr><th>request.getRequestURI()</th><td><%= request.getRequestURI() %></td></tr>
        <tr><th>request.getRemoteAddr()</th><td><%= request.getRemoteAddr() %></td></tr>
        <tr><th>session.getId()</th><td><%= session.getId() %></td></tr>
        <tr><th>application.getServerInfo()</th><td><%= application.getServerInfo() %></td></tr>
    </table>

    <h3>Exercises</h3>
    <ul>
        <li><a href="studentForm.jsp">Exercise 1 : Student Information</a></li>
        <li><a href="register.jsp">Exercise 2 : User Registration</a></li>
    </ul>
</div>
</body>
</html>
