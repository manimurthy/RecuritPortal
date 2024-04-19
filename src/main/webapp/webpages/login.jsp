<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Login</h2>
    <form action="/login" method="post">
        <label for="empemail">Email:</label><br>
        <input type="text" id="empemail" name="empemail"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Login">
    </form>
    <p th:text="${error}"></p> <!-- Display error message if login fails -->
</body>
</html>