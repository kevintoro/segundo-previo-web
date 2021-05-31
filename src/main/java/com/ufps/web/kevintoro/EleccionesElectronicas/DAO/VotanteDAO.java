package com.ufps.web.kevintoro.EleccionesElectronicas.DAO;

import com.ufps.web.kevintoro.EleccionesElectronicas.model.Votante;
import com.ufps.web.kevintoro.EleccionesElectronicas.util.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VotanteDAO {
  private final ConnectionDB connectionDB;
  public final static String GET_ALL_VOTANTES = "select * from votante;";
  public final static String GET_VOTANTE = "select * from votante where id = ?;";
  public final static String UPDATE_VOTANTE = "update votante set nombre = ?, documento = ?, email = ?, tipodocumento = ?, eleccion = ? where id = ?;";
  public final static String DELETE_VOTANTE = "delete from votante where id = ?;";
  public final static String INSERT_VOTANTE = "insert into votante(nombre, email, documento, tipodocumento, eleccion) values (?,?,?,?,?);";
  
  public VotanteDAO() {
    connectionDB = ConnectionDB.getConnection();
  }
  
  public void insertarVotante(Votante votante) {
    try {
      PreparedStatement statement = connectionDB.setPreparedStatement(INSERT_VOTANTE);
      statement.setString(1, votante.getNombre());
      statement.setString(2, votante.getEmail());
      statement.setString(3, votante.getDocumento());
      statement.setInt(4, votante.getTipoDocumento());
      statement.setInt(5, votante.getEleccion());
    } catch (SQLException e) {
      System.out.println("Error insertando: " + e);
    }
  }
  
  public List<Votante> listarVotantes() {
    List<Votante> votantes = new ArrayList<>();
    try {
      PreparedStatement statement = connectionDB.setPreparedStatement(GET_ALL_VOTANTES);
      ResultSet resultSet = connectionDB.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        String email = resultSet.getString("email");
        String documento = resultSet.getString("documento");
        int tipoDocumento = resultSet.getInt("tipodocumento");
        int eleccion = resultSet.getInt("eleccion");
        votantes.add(new Votante(id, nombre, email, documento, tipoDocumento, eleccion));
      }
    } catch (SQLException e) {
      System.out.println("Error listando votantes: " + e);
    }
    return votantes;
  }

  
  public void actualizarVotante(Votante votante) {
    try {
      PreparedStatement statement = connectionDB.setPreparedStatement(UPDATE_VOTANTE);
      statement.setString(1, votante.getNombre());
      statement.setString(2, votante.getDocumento());
      statement.setString(3, votante.getEmail());
      statement.setInt(4, votante.getTipoDocumento());
      statement.setInt(5, votante.getEleccion());
      statement.setInt(6, votante.getId());
    } catch (SQLException e) {
      System.out.println("Error al actualizar votante: " + e);
    }
  }
  
  public void eliminarVotante(int id) {
    try {
      PreparedStatement statement = connectionDB.setPreparedStatement(DELETE_VOTANTE);
      statement.setInt(1, id);
      connectionDB.executeStatement();
    } catch (SQLException e) {
      System.out.println("Error al eliminar votante: " + e);
    }
  }
  
  public Votante buscarVotantePorID(int id) {
    Votante votante = null;
    try {
      PreparedStatement statement = connectionDB.setPreparedStatement(GET_VOTANTE);
      statement.setInt(1, id);
      ResultSet resultSet = connectionDB.executeQuery();
      while (resultSet.next()) {
        int idFind = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        String email = resultSet.getString("email");
        String documento = resultSet.getString("documento");
        int tipoDocumento = resultSet.getInt("tipodocumento");
        int eleccion = resultSet.getInt("eleccion");
        votante = new Votante(idFind, nombre, email, documento, tipoDocumento, eleccion);
      }
    } catch (SQLException e) {
      System.out.println("Error al buscar por ID: " + e);
    }
    return votante;
  }
}
