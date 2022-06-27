<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
     <%@ page import="modelo.Ciudad" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<nav>
<a href="#">Ciudades</a>
</nav>
</div>
<h1>Lista De Ciudades</h1>
<%! List<Ciudad> listaCiudades; %>
<%
try{
	listaCiudades=(List<Ciudad>) request.getAttribute("ciudades");
	Iterator<Ciudad> item=listaCiudades.iterator();
%>
<div>
<table>
<thead>
<th>id</th>
<th>Nombre</th>
<th>Codigo</th>
</thead>
<tbody>
<% while(item.hasNext()){
	Ciudad ciudad=item.next();%>

<tr>
<td><%=ciudad.getId() %></td>
<td><%=ciudad.getNombre_ciudad() %></td>
<td><%=ciudad.getCodigo_ciudad() %></td>
</tr>
</tbody>
<%}%>
</table>
</div>
<%}catch(Exception e) {
	
}%>
</body>
</html>