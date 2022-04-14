<%@page import="com.bway.webdemo.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 
</head>
<body>

<table width="100%" border="1">
		<thead bgcolor:red>
			<tr>
			    <td>id</td>
				<td>name</td>
				<td>email</td>
				<td>password</td>
				<td>gender</td>
				<td>DOB</td>
				<td>message</td>
				<td>city</td>
				<td>state</td>
				<td>country</td>
				<td>phone</td>
				<td>for aprove</td>
				<td>for delete</td>
			</tr>
		</thead>
		<tbody>
			<%
			List<Student> list = (List<Student>) request.getAttribute("list1");
			for (Student s : list) {
			%>
			<tr>
			     <td><%= s.getId() %></td>
				<td><%=s.getName()%></td>
				<td><%= s.getEmail() %></td>
				<td><%= s.getPassword() %></td>
				<td><%= s.getGender() %></td>
				<td><%= s.getDob() %></td>
				<td><%= s.getTextarea() %></td>
				<td><%= s.getCity() %></td>
				<td><%= s.getState() %></td>
				<td><%= s.getCountry() %></td>
				<td><%= s.getPhone() %></td>
<td><form action="AproveServlet" method="post"><input type= "hidden" name= "id" value="<%= s.getId() %>"><input type="submit"  name="submit" value="Aprove" onclick="alert('Hello\nHow are you?')">></form></td>'


				<td>delete</td>

			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>