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
      case "/update":
        actualizarVotante(request, response);
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
    int estamento = Integer.parseInt(request.getParameter("estamento"));
    int tipoDocumento = Integer.parseInt(request.getParameter("tipo-documento"));
    String documento = request.getParameter("documento");
    String nombre = request.getParameter("nombre");
    String email = request.getParameter("email");
    String proceso = request.getParameter("proceso");
    Estamento es = estamentoDAO.estamentoPorID(estamento);
    Votante votante = new Votante(nombre, email, documento, tipoDocumento, es.getEleccion());
    votanteDAO.insertarVotante(votante);
    response.sendRedirect("list");
  }
  
  private void listarVotantes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Votante> votantes = votanteDAO.listarVotantes();
    request.setAttribute("votantes", votantes);
    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
  }
  
  private void eliminarVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int votanteId = Integer.parseInt(request.getParameter("votante_id"));
    votanteDAO.eliminarVotante(votanteId);
    response.sendRedirect("list");
  }
  
  private void editarVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Estamento> estamentos = estamentoDAO.listarEstamentos();
    List<TipoDocumento> tipoDocumentos = tipoDocumentoDAO.listarTipoDocumento();
    request.setAttribute("estamentos", estamentos);
    request.setAttribute("tipoDocumentos", tipoDocumentos);
    int votanteId = Integer.parseInt(request.getParameter("votante_id"));
    Votante votante = votanteDAO.buscarVotantePorID(votanteId);
    request.setAttribute("votante", votante);
    RequestDispatcher rd = request.getRequestDispatcher("add-votante.jsp");
    rd.forward(request, response);
  }
  
  private void mostrarFormularioAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Estamento> estamentos = estamentoDAO.listarEstamentos();
    List<TipoDocumento> tipoDocumentos = tipoDocumentoDAO.listarTipoDocumento();
    request.setAttribute("estamentos", estamentos);
    request.setAttribute("tipoDocumentos", tipoDocumentos);
    RequestDispatcher rd = request.getRequestDispatcher("add-votante.jsp");
    rd.forward(request, response);
  }
  
  private void actualizarVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int estamento = Integer.parseInt(request.getParameter("estamento"));
    int votanteId = Integer.parseInt(request.getParameter("votante_id"));
    int tipoDocumento = Integer.parseInt(request.getParameter("tipo-documento"));
    String documento = request.getParameter("documento");
    String nombre = request.getParameter("nombre");
    String email = request.getParameter("email");
    String proceso = request.getParameter("proceso");
    Estamento es = estamentoDAO.estamentoPorID(estamento);
    Votante votante = new Votante(votanteId, nombre, email, documento, tipoDocumento, es.getEleccion());
    votanteDAO.actualizarVotante(votante);
    response.sendRedirect("list");
  }
}
