<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Agregar Votante</title>
  <style>
    <%@include file="styles/bootstrap.min.css" %>
  </style>
</head>
<body class="container mt-5">
<div class="col-11 col-sm-9 col-md-7 col-lg-6 mx-auto">
  <div class="card">
    <div class="card-body">
      <c:if test="${votante != null}">
        <h3 class="card-title">Actualizar información de votante</h3>
      </c:if>
      <c:if test="${votante == null}">
        <h3 class="card-title">Registro de población electoral</h3>
      </c:if>
      <c:if test="${votante != null}">
      <form action="update" method="post">
        </c:if>
        <c:if test="${votante == null}">
        <form action="insert" method="post">
          </c:if>
          <div class="form-group">
            <label for="estamento">Estamento: </label>
            <select name="estamento" id="estamento" class="form-control" required>
              <c:forEach var="estamento" items="${estamentos}">
                <option value="${estamento.id}">
                  <c:out value="${estamento.descripcion}"/>
                </option>
              </c:forEach>
            </select>
          </div>
          <div class="form-group">
            <label for="tipo-documento">Tipo de documento:</label>
            <select name="tipo-documento" id="tipo-documento" class="form-control" required>
              <c:forEach var="tipoDocumento" items="${tipoDocumentos}">
                <option value="${tipoDocumento.id}">
                  <c:out value="${tipoDocumento.descripcion}"/>
                </option>
              </c:forEach>
            </select>
          </div>
          <div class="form-group">
            <label for="documento">Documento:</label>
            <c:if test="${votante != null}">
              <input type="number" class="form-control" required id="documento" name="documento"
                     value="<c:out value="${votante.documento}"/>">
            </c:if>
            <c:if test="${votante == null}">
              <input type="number" class="form-control" required id="documento" name="documento">
            </c:if>
          </div>
          <div class="form-group">
            <label for="nombre">Nombre:</label>
            <c:if test="${votante != null}">
              <input type="text" class="form-control" required id="nombre" name="nombre"
                     value="<c:out value='${votante.nombre}'/>">
            </c:if>
            <c:if test="${votante == null}">
              <input type="text" class="form-control" required id="nombre" name="nombre">
            </c:if>
          
          </div>
          <div class="form-group">
            <label for="email">Email:</label>
            <c:if test="${votante != null}">
              <input type="email" class="form-control" required id="email" name="email"
                     value="<c:out value="${votante.email}"/>">
            </c:if>
            <c:if test="${votante == null}">
              <input type="email" class="form-control" required id="email" name="email">
            </c:if>
          
          </div>
          <div class="form-group">
            <label for="proceso">Proceso:</label>
            <select name="proceso" id="proceso" class="form-control" required>
              <option value="1">Rectoria 2021 - 2025</option>
            </select>
          </div>
          <div class="d-grid mt-3">
            <c:if test="${votante != null}">
              <button type="submit" class="btn btn-danger btn-lg">Actualizar Votante</button>
            </c:if>
            <c:if test="${votante == null}">
              <button type="submit" class="btn btn-danger btn-lg">Registrar Votante</button>
            </c:if>
          </div>
          <c:if test="${votante != null}">
            <input type="hidden" name="votante_id" value="<c:out value='${votante.id}' />"/>
          </c:if>
        </form>
    </div>
  </div>
</div>
</body>
</html>
