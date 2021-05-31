package com.ufps.web.kevintoro.EleccionesElectronicas.controller;

import com.ufps.web.kevintoro.EleccionesElectronicas.DAO.EstamentoDAO;
import com.ufps.web.kevintoro.EleccionesElectronicas.DAO.TipoDocumentoDAO;
import com.ufps.web.kevintoro.EleccionesElectronicas.DAO.VotanteDAO;
import com.ufps.web.kevintoro.EleccionesElectronicas.model.Estamento;
import com.ufps.web.kevintoro.EleccionesElectronicas.model.TipoDocumento;
import com.ufps.web.kevintoro.EleccionesElectronicas.model.Votante;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VotanteServlet", urlPatterns = {"/"})
public class VotanteServlet extends HttpServlet {
  VotanteDAO votanteDAO;
  EstamentoDAO estamentoDAO;
  TipoDocumentoDAO tipoDocumentoDAO;
  @Override
  public void init() throws ServletException {
    super.init();
    votanteDAO = new VotanteDAO();
    estamentoDAO = new EstamentoDAO();
    tipoDocumentoDAO = new TipoDocumentoDAO();
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getServletPath();
    switch (action) {
      case "/add":
        mostrarFormularioAgregar(request, response);
        break;
      case "/delete":
        eliminarVotante(request, response);
        break;
      case "/edit":
        editarVotante(request, response);
        break;
      case "/insert":
        agregarVotante(request, response);
        break;
      default:
        listarVotantes(request, response);
        break;
    }
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  
  public void agregarVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
  
  private void listarVotantes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Votante> votantes = votanteDAO.listarVotantes();
    request.setAttribute("votantes", votantes);
    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
  }
  
  private void eliminarVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
  
  private void editarVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
  
  private void mostrarFormularioAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Estamento> estamentos = estamentoDAO.listarEstamentos();
    List<TipoDocumento> tipoDocumentos = tipoDocumentoDAO.listarTipoDocumento();
    request.setAttribute("estamentos", estamentos);
    request.setAttribute("tipoDocumentos", tipoDocumentos);
    RequestDispatcher rd = request.getRequestDispatcher("add-votante.jsp");
    rd.forward(request, response);
  }
}
