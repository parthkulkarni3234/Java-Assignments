<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%!
    private String esc(String s) {
        if (s == null) return "";
        return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;")
                .replace("\"","&quot;").replace("'","&#39;");
    }
%>
<%
    request.setCharacterEncoding("UTF-8");
    String name     = request.getParameter("name");
    String email    = request.getParameter("email");
    String phone    = request.getParameter("phone");
    String password = request.getParameter("password");
    boolean ok = name != null && email != null && phone != null && password != null;

    // never echo a real password; show masked form
    String masked = ok ? "*".repeat(password.length()) : "";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Result</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="card">
    <h2>Registration Successful</h2>
    <% if (ok) { %>
        <table>
            <tr><th>Name</th><td><%= esc(name) %></td></tr>
            <tr><th>Email</th><td><%= esc(email) %></td></tr>
            <tr><th>Phone</th><td><%= esc(phone) %></td></tr>
            <tr><th>Password</th><td><%= masked %> (<%= password.length() %> characters)</td></tr>
        </table>
    <% } else { %>
        <p class="err">No registration data received. Please use the form.</p>
    <% } %>
    <p><a href="register.jsp">&larr; Back to form</a> | <a href="index.jsp">Home</a></p>
</div>
</body>
</html>
