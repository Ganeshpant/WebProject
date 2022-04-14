<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
 background-image: url("image.img");
}
</style>
</head>
<body>
 <form action="LoginServlet" method="post">
 <h1>Login form</h1>
 <p style="color:red">${message }</p>
 <p style=" color:green"> ${message1 } ${name } ${message2 }</p>
<input type="text" name="name" id="name" placeholder="Enter your name"><br>
<input type="password" name="password" id="password" placeholder="Enter password"><br><br>
<input type="submit" value="login"><br><br>
<a href="SignupServlet">signup</a>



    </form>
</body>
</html>