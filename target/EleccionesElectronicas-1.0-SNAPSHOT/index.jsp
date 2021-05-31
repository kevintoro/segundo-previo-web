<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Votantes Elecciones UFPS</title>
  <style><%@include file="styles/bootstrap.min.css"%></style>
</head>
<body class="container mt-4">
<h1>Listado de votantes</h1>
<hr>
<div class="container text-left">
  
  <a href="<%=request.getContextPath()%>/add" class="btn btn-success">
    Agregar Votante
  </a>
</div>
<br>
<table class="table table-bordered">
  <thead>
  <tr>
    <th>ID</th>
    <th>Nombre</th>
    <th>Email</th>
    <th>Documento</th>
    <th>Acciones</th>
  </tr>
  </thead>
  <tbody>
  <!--   for (Todo todo: todos) {  -->
  <c:forEach var="votante" items="${votantes}">
    <tr>
      <td>
        <c:out value="${user.user_id}"/>
      </td>
      <td>
        <c:out value="${user.user_name}"/>
      </td>
      <td>
        <c:out value="${user.user_email}"/>
      </td>
      <td>
        <c:out value="${user.user_country}"/>
      </td>
      <td><a href="edit?user_id=<c:out value='${votante.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
          href="delete?user_id=<c:out value='${votante.id}' />">Delete</a></td>
    </tr>
  </c:forEach>
  <!-- } -->
  </tbody>

</table>
</body>
</html>