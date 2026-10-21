<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="card">
    <h2>User Registration</h2>
    <form action="result.jsp" method="post">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>

        <label for="phone">Phone Number</label>
        <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" title="Enter a 10 digit number" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" minlength="6" required>

        <button type="submit">Register</button>
    </form>
    <p><a href="index.jsp">&larr; Home</a></p>
</div>
</body>
</html>
