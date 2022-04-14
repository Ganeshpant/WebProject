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
<p>${name} ${message}</p>
	<table width="100%" border="1">
		<thead bgcolor:red>
			<tr>
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
			</tr>
		</thead>
		<tbody>
			<%
			List<Student> list = (List<Student>) request.getAttribute("list");
			for (Student s : list) {
			%>
			<tr>
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

			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>