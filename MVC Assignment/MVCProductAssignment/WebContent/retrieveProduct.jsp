<%@page import="java.util.Iterator"%>
<%@page import="com.bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<br/><br/><br/><br/><br/>
<div align="center">
<table border="1">
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Price</th>
	<th>StoreDate</th>
	
</tr>
<%
Object obj = session.getAttribute("prodInfo");
List<Product> listOfProd = (List<Product>)obj;
Iterator<Product> li = listOfProd.iterator();
while(li.hasNext()){
	Product prod = li.next();
	%>
		<tr>
			<td><%=prod.getId() %></td>
			<td><%=prod.getName() %></td>
			<td><%=prod.getPrice() %></td>
			<td><%=prod.getStoredate() %></td>
		</tr>
	<% 
}
%>
</table>
</div>
</body>
</html>