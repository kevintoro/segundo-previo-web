package com.ufps.web.kevintoro.EleccionesElectronicas.DAO;

import com.ufps.web.kevintoro.EleccionesElectronicas.model.Estamento;
import com.ufps.web.kevintoro.EleccionesElectronicas.util.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstamentoDAO {
  private final ConnectionDB connectionDB;
  
  public final static String GET_ALL_ESTAMENTOS = "select * from estamento";
  public final static String GET_ESTAMENTOS_BY_ID = "select * from estamento where id = ?";
  
  public EstamentoDAO() {
    connectionDB = ConnectionDB.getConnection();
  }
  
  public List<Estamento> listarEstamentos() {
    List<Estamento> estamentos = new ArrayList<>();
    try {
      PreparedStatement statement = connectionDB.setPreparedStatement(GET_ALL_ESTAMENTOS);
      ResultSet resultSet = connectionDB.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        int eleccion = resultSet.getInt("eleccion");
        String descripcion = resultSet.getString("descripcion");
        estamentos.add(new Estamento(id, eleccion, descripcion));
      }
    } catch (SQLException e) {
      System.out.println("Error al listar estamentos: " + e);
    }
    return estamentos;
  }
  
  public Estamento estamentoPorID(int id) {
    Estamento estamento = null;
    try {
      PreparedStatement statement = connectionDB.setPreparedStatement(GET_ESTAMENTOS_BY_ID);
      statement.setInt(1, id);
      ResultSet resultSet = connectionDB.executeQuery();
      while (resultSet.next()) {
        int idFind = resultSet.getInt("id");
        int eleccion = resultSet.getInt("eleccion");
        String descripcion = resultSet.getString("descripcion");
        estamento = new Estamento(idFind, eleccion, descripcion);
      }
    } catch (SQLException e) {
      System.out.println("Error al buscar estamento por ID: " + e);
    }
    return estamento;
  }
}
