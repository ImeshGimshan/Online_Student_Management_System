<%--
  Created by IntelliJ IDEA.
  User: iamcy
  Date: 5/28/2025
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Unauthorized Access</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/unauthorized.css">
</head>
<body>
<div class="unauth-container">
    <div class="unauth-icon">🚫</div>
    <h1>Unauthorized Access</h1>
    <p class="unauth-message">
        Sorry, you do not have permission to view this page.<br>
        Please check your credentials or contact the system administrator if you think this is a mistake.
    </p>
    <a href="<%= request.getContextPath() %>/index.jsp" class="unauth-btn">Go to Home</a>
    <a href="<%= request.getContextPath() %>/jsp/Login.jsp" class="unauth-btn secondary">Admin Login</a>
</div>
</body>
</html>

