package com.ufps.web.kevintoro.EleccionesElectronicas.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VotanteServlet", value = "/VotanteServlet")
public class VotanteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getServletPath();
    switch (action) {
      case "/add":
        agregarVotante(request, response);
        break;
      case "/delete":
        eliminarVotante(request, response);
        break;
      case "/editar":
        editarVotante(request, response);
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
  }
  
  private void eliminarVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
  
  private void editarVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
}
