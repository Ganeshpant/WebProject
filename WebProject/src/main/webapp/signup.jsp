<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> signup form</h1>
<p style ="color:red">${message}</p>
  <form action="SignupServlet" method="post"> 
   <input type="text" name="name" id="name" placeholder="Enter name"><br> <br>
   <input type="email" name="email" id="email" placeholder="Enter email"><br> <br>
   <input type="password" name="password" id="password" placeholder="Enter password"><br> <br>
   gender:
   <input type="radio" name="gender" value ="male"> male
   <input type="radio" name="gender"  value ="female"> female<br> <br>
    dob:<input type="date" name="date" id="date"><br>
   Address Line : <textarea name="textarea" id="" cols="30" rows="10"></textarea><br> <br>
   city: <input type="text" name="city" id="city" placeholder="enter your city"><br> <br>
   state: <input type="text" name="state" id="state" placeholder="Enter state" ><br> <br>
   Country:   <select name="country" id="country">
    <option > nepal</option>
    <option > india</option>
    <option > japan</option>
   </select><br> <br>
  Phone:<input type="number" name="phone" id="phone" placeholder="phone no"><br> <br>
 <button type="submit" name="register">Register</button>
  <input type="reset" name = "" value="Clear" >
  </form>
</body>
</html>