<%--
  Created by IntelliJ IDEA.
  User: iamcy
  Date: 5/28/2025
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Error</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/errorPage.css">
</head>
<body>
<div class="error-container">
    <div class="error-icon">⚠️</div>
    <h1>Oops! Something went wrong.</h1>
    <p class="error-message">
        We're sorry, an unexpected error has occurred.<br>
        Please try again later or contact support if the problem persists.
    </p>
    <a href="<%= request.getContextPath() %>/index.jsp" class="error-btn">Back to Home</a>
</div>
</body>
</html>

