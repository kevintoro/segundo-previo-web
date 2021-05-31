<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Agregar Votante</title>
  <style><%@include file="styles/bootstrap.min.css"%></style>
</head>
<body class="container mt-5">
<div class="col-11 col-sm-9 col-md-7 col-lg-6 mx-auto">
  <div class="card">
    <div class="card-body">
      <h3 class="card-title">Registro de población electoral</h3>
      <form action="insert" method="post">
        <div class="form-group">
          <label for="estamento">Estamento: </label>
          <select name="estamento" id="estamento" class="form-control">
            <option value="default">Seleccione una opcion</option>
            <c:forEach var="estamento" items="${estamentos}">
              <option value="${estamento.id}">
                <c:out value="${estamento.descripcion}" />
              </option>
            </c:forEach>
          </select>
        </div>
        <div class="form-group">
          <label for="tipo-documento">Tipo de documento:</label>
          <select name="tipo-documento" id="tipo-documento" class="form-control">
            <option value="default">Seleccione una opcion</option>
            <c:forEach var="tipoDocumento" items="${tipoDocumentos}">
              <option value="${tipoDocumento.id}">
                <c:out value="${tipoDocumento.descripcion}" />
              </option>
            </c:forEach>
          </select>
        </div>
        <div class="form-group">
          <label for="documento">Documento:</label>
          <input type="number" class="form-control" required id="documento" name="documento">
        </div>
        <div class="form-group">
          <label for="nombre">Nombre:</label>
          <input type="text" class="form-control" required id="nombre" name="nombre">
        </div>
        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" class="form-control" required id="email" name="email">
        </div>
        <div class="form-group"></div>
      </form>
      <div class="d-grid">
        <button type="submit" class="btn btn-danger btn-lg">Registrar Votante</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
