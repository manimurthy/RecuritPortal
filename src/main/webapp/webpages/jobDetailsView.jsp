<!-- jobDetailsView.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Job Details</title>
</head>
<body>
    <h1>Job Details</h1>
    <%-- Check if jobPost is not null before displaying --%>
    <c:if test="${not empty jobPost}">
        <table border="1">
            <tr>
                <th>Job ID</th>
                <th>Job Description</th>
                <th>Title</th>
                <th>Other Fields</th>
            </tr>
            <tr>
                <td>${jobPost.jobId}</td>
                <td>${jobPost.jobDesc}</td>
                <td>${jobPost.title}</td>
                <td>${jobPost.otherField}</td>
            </tr>
        </table>
    </c:if>
</body>
</html>
