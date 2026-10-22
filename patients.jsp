<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="db.jsp" %>
<%
    request.setCharacterEncoding("UTF-8");
    String msg = request.getParameter("msg");
    String err = null;
    String[] editRow = null;
    List<String[]> rows = new ArrayList<>();
    String[] statuses = {"Admitted", "Under Treatment", "Recovering", "Recovered", "Discharged"};

    try (Connection con = getConn()) {

        // ---------- CREATE / UPDATE / DELETE ----------
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String action  = request.getParameter("action");
            String name    = request.getParameter("name");
            String age     = request.getParameter("age");
            String disease = request.getParameter("disease");
            String status  = request.getParameter("treatment_status");
            String id      = request.getParameter("patient_id");
            String result = null;
            try {
                if ("add".equals(action)) {
                    try (PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO patient(name,age,disease,treatment_status) VALUES(?,?,?,?)")) {
                        ps.setString(1, name.trim()); ps.setInt(2, Integer.parseInt(age.trim()));
                        ps.setString(3, disease.trim()); ps.setString(4, status);
                        ps.executeUpdate();
                    }
                    result = "Patient record added successfully.";
                } else if ("update".equals(action)) {
                    try (PreparedStatement ps = con.prepareStatement(
                        "UPDATE patient SET name=?,age=?,disease=?,treatment_status=? WHERE patient_id=?")) {
                        ps.setString(1, name.trim()); ps.setInt(2, Integer.parseInt(age.trim()));
                        ps.setString(3, disease.trim()); ps.setString(4, status);
                        ps.setInt(5, Integer.parseInt(id));
                        ps.executeUpdate();
                    }
                    result = "Patient record updated successfully.";
                } else if ("delete".equals(action)) {
                    try (PreparedStatement ps = con.prepareStatement("DELETE FROM patient WHERE patient_id=?")) {
                        ps.setInt(1, Integer.parseInt(id));
                        ps.executeUpdate();
                    }
                    result = "Patient record deleted.";
                }
            } catch (NumberFormatException | NullPointerException e) {
                err = "Invalid input. Please check all fields.";
            }
            if (err == null && result != null) {
                response.sendRedirect("patients.jsp?msg=" + java.net.URLEncoder.encode(result, "UTF-8"));
                return;
            }
        }

        // ---------- load row to edit ----------
        String editId = request.getParameter("edit");
        if (editId != null) {
            try (PreparedStatement ps = con.prepareStatement("SELECT * FROM patient WHERE patient_id=?")) {
                ps.setInt(1, Integer.parseInt(editId));
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) editRow = new String[]{rs.getString("patient_id"), rs.getString("name"),
                        rs.getString("age"), rs.getString("disease"), rs.getString("treatment_status")};
                }
            } catch (NumberFormatException e) { /* ignore bad id */ }
        }

        // ---------- READ ----------
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM patient ORDER BY patient_id")) {
            while (rs.next()) {
                rows.add(new String[]{rs.getString("patient_id"), rs.getString("name"),
                    rs.getString("age"), rs.getString("disease"), rs.getString("treatment_status")});
            }
        }
    } catch (Exception e) {
        err = "Database error: " + e.getMessage();
    }
    boolean editing = (editRow != null);
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Patient Records</title>
<link rel="stylesheet" href="style.css"></head>
<body>
<div class="card">
    <h2><%= editing ? "Update Patient" : "Add Patient" %></h2>
    <% if (msg != null && !msg.isEmpty()) { %><p class="ok"><%= esc(msg) %></p><% } %>
    <% if (err != null) { %><p class="err"><%= esc(err) %></p><% } %>

    <form method="post" action="patients.jsp">
        <input type="hidden" name="action" value="<%= editing ? "update" : "add" %>">
        <% if (editing) { %><input type="hidden" name="patient_id" value="<%= esc(editRow[0]) %>"><% } %>
        <div class="row">
            <div><label>Name</label>
                <input type="text" name="name" required value="<%= editing ? esc(editRow[1]) : "" %>"></div>
            <div><label>Age</label>
                <input type="number" name="age" min="0" max="150" required value="<%= editing ? esc(editRow[2]) : "" %>"></div>
            <div><label>Disease</label>
                <input type="text" name="disease" required value="<%= editing ? esc(editRow[3]) : "" %>"></div>
            <div><label>Treatment Status</label>
                <select name="treatment_status">
                <% for (String s : statuses) { %>
                    <option value="<%= s %>" <%= (editing && s.equals(editRow[4])) ? "selected" : "" %>><%= s %></option>
                <% } %>
                </select></div>
        </div>
        <p><button type="submit"><%= editing ? "Update" : "Add" %></button>
        <% if (editing) { %><a class="btn grey" href="patients.jsp">Cancel</a><% } %></p>
    </form>
</div>

<div class="card">
    <h2>Patient Records</h2>
    <table>
        <tr><th>Patient ID</th><th>Name</th><th>Age</th><th>Disease</th><th>Treatment Status</th><th>Actions</th></tr>
        <% if (rows.isEmpty()) { %>
            <tr><td colspan="6">No patient records found.</td></tr>
        <% } else { for (String[] r : rows) { %>
            <tr>
                <td><%= esc(r[0]) %></td><td><%= esc(r[1]) %></td><td><%= esc(r[2]) %></td>
                <td><%= esc(r[3]) %></td><td><%= esc(r[4]) %></td>
                <td>
                    <a class="btn edit" href="patients.jsp?edit=<%= esc(r[0]) %>">Edit</a>
                    <form class="inline" method="post" action="patients.jsp"
                          onsubmit="return confirm('Delete this patient record?');">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="patient_id" value="<%= esc(r[0]) %>">
                        <button class="del" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        <% } } %>
    </table>
    <p><a href="index.jsp">&larr; Home</a></p>
</div>
</body></html>
