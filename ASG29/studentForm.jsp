<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="card">
    <h2>Student Information</h2>
    <form action="studentResult.jsp" method="post">
        <label for="roll">Roll No</label>
        <input type="number" id="roll" name="roll" required>

        <label for="name">Name</label>
        <input type="text" id="name" name="name" required>

        <label for="course">Course / Class</label>
        <input type="text" id="course" name="course" required>

        <label for="marks">Marks (out of 100)</label>
        <input type="number" id="marks" name="marks" min="0" max="100" required>

        <button type="submit">Submit</button>
    </form>
    <p><a href="index.jsp">&larr; Home</a></p>
</div>
</body>
</html>
