<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="db.jsp" %>
<%
    request.setCharacterEncoding("UTF-8");
    String msg = request.getParameter("msg");
    String err = null;
    String[] editRow = null;                       // row being edited (if any)
    List<String[]> rows = new ArrayList<>();

    try (Connection con = getConn()) {

        // ---------- CREATE / UPDATE / DELETE (POST only) ----------
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String action = request.getParameter("action");
            String name   = request.getParameter("name");
            String dept   = request.getParameter("department");
            String desig  = request.getParameter("designation");
            String salary = request.getParameter("salary");
            String id     = request.getParameter("emp_id");
            String result = null;
            try {
                if ("add".equals(action)) {
                    try (PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO employee(name,department,designation,salary) VALUES(?,?,?,?)")) {
                        ps.setString(1, name.trim()); ps.setString(2, dept.trim());
                        ps.setString(3, desig.trim());
                        ps.setBigDecimal(4, new java.math.BigDecimal(salary.trim()));
                        ps.executeUpdate();
                    }
                    result = "Employee added successfully.";
                } else if ("update".equals(action)) {
                    try (PreparedStatement ps = con.prepareStatement(
                        "UPDATE employee SET name=?,department=?,designation=?,salary=? WHERE emp_id=?")) {
                        ps.setString(1, name.trim()); ps.setString(2, dept.trim());
                        ps.setString(3, desig.trim());
                        ps.setBigDecimal(4, new java.math.BigDecimal(salary.trim()));
                        ps.setInt(5, Integer.parseInt(id));
                        ps.executeUpdate();
                    }
                    result = "Employee updated successfully.";
                } else if ("delete".equals(action)) {
                    try (PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE emp_id=?")) {
                        ps.setInt(1, Integer.parseInt(id));
                        ps.executeUpdate();
                    }
                    result = "Employee deleted.";
                }
            } catch (NumberFormatException | NullPointerException e) {
                err = "Invalid input. Please check all fields.";
            }
            if (err == null && result != null) {
                // Post/Redirect/Get: avoids re-submitting the form on refresh
                response.sendRedirect("employees.jsp?msg=" + java.net.URLEncoder.encode(result, "UTF-8"));
                return;
            }
        }

        // ---------- load row to edit ----------
        String editId = request.getParameter("edit");
        if (editId != null) {
            try (PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE emp_id=?")) {
                ps.setInt(1, Integer.parseInt(editId));
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) editRow = new String[]{rs.getString("emp_id"), rs.getString("name"),
                        rs.getString("department"), rs.getString("designation"), rs.getString("salary")};
                }
            } catch (NumberFormatException e) { /* ignore bad id */ }
        }

        // ---------- READ ----------
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM employee ORDER BY emp_id")) {
            while (rs.next()) {
                rows.add(new String[]{rs.getString("emp_id"), rs.getString("name"),
                    rs.getString("department"), rs.getString("designation"), rs.getString("salary")});
            }
        }
    } catch (Exception e) {
        err = "Database error: " + e.getMessage();
    }
    boolean editing = (editRow != null);
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Employee Management</title>
<link rel="stylesheet" href="style.css"></head>
<body>
<div class="card">
    <h2><%= editing ? "Update Employee" : "Add Employee" %></h2>
    <% if (msg != null && !msg.isEmpty()) { %><p class="ok"><%= esc(msg) %></p><% } %>
    <% if (err != null) { %><p class="err"><%= esc(err) %></p><% } %>

    <form method="post" action="employees.jsp">
        <input type="hidden" name="action" value="<%= editing ? "update" : "add" %>">
        <% if (editing) { %><input type="hidden" name="emp_id" value="<%= esc(editRow[0]) %>"><% } %>
        <div class="row">
            <div><label>Name</label>
                <input type="text" name="name" required value="<%= editing ? esc(editRow[1]) : "" %>"></div>
            <div><label>Department</label>
                <input type="text" name="department" required value="<%= editing ? esc(editRow[2]) : "" %>"></div>
            <div><label>Designation</label>
                <input type="text" name="designation" required value="<%= editing ? esc(editRow[3]) : "" %>"></div>
            <div><label>Salary</label>
                <input type="number" step="0.01" min="0" name="salary" required value="<%= editing ? esc(editRow[4]) : "" %>"></div>
        </div>
        <p><button type="submit"><%= editing ? "Update" : "Add" %></button>
        <% if (editing) { %><a class="btn grey" href="employees.jsp">Cancel</a><% } %></p>
    </form>
</div>

<div class="card">
    <h2>Employee List</h2>
    <table>
        <tr><th>ID</th><th>Name</th><th>Department</th><th>Designation</th><th>Salary</th><th>Actions</th></tr>
        <% if (rows.isEmpty()) { %>
            <tr><td colspan="6">No employees found.</td></tr>
        <% } else { for (String[] r : rows) { %>
            <tr>
                <td><%= esc(r[0]) %></td><td><%= esc(r[1]) %></td><td><%= esc(r[2]) %></td>
                <td><%= esc(r[3]) %></td><td><%= esc(r[4]) %></td>
                <td>
                    <a class="btn edit" href="employees.jsp?edit=<%= esc(r[0]) %>">Edit</a>
                    <form class="inline" method="post" action="employees.jsp"
                          onsubmit="return confirm('Delete this employee?');">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="emp_id" value="<%= esc(r[0]) %>">
                        <button class="del" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        <% } } %>
    </table>
    <p><a href="index.jsp">&larr; Home</a></p>
</div>
</body></html>
