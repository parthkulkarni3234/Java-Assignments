<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%!
    // escape HTML so user input cannot inject markup (XSS)
    private String esc(String s) {
        if (s == null) return "";
        return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;")
                .replace("\"","&quot;").replace("'","&#39;");
    }
%>
<%
    request.setCharacterEncoding("UTF-8");
    String roll   = request.getParameter("roll");
    String name   = request.getParameter("name");
    String course = request.getParameter("course");
    String marksStr = request.getParameter("marks");

    int marks = 0;
    boolean valid = (name != null && marksStr != null);
    if (valid) {
        try { marks = Integer.parseInt(marksStr.trim()); }
        catch (NumberFormatException e) { valid = false; }
    }
    String grade = "";
    if (valid) {
        if (marks >= 75) grade = "Distinction";
        else if (marks >= 60) grade = "First Class";
        else if (marks >= 50) grade = "Second Class";
        else if (marks >= 40) grade = "Pass";
        else grade = "Fail";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Result</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="card">
    <h2>Student Details</h2>
    <% if (valid) { %>
        <table>
            <tr><th>Roll No</th><td><%= esc(roll) %></td></tr>
            <tr><th>Name</th><td><%= esc(name) %></td></tr>
            <tr><th>Course</th><td><%= esc(course) %></td></tr>
            <tr><th>Marks</th><td><%= marks %> / 100</td></tr>
            <tr><th>Result</th><td><%= grade %></td></tr>
        </table>
    <% } else { %>
        <p class="err">No valid data received. Please fill the form first.</p>
    <% } %>
    <p><a href="studentForm.jsp">&larr; Back to form</a> | <a href="index.jsp">Home</a></p>
</div>
</body>
</html>
