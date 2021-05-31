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
        int eleccion = resultSet.getInt("estamento");
        String descripcion = resultSet.getString("descripcion");
        estamentos.add(new Estamento(id, eleccion, descripcion));
      }
    } catch (SQLException e) {
      System.out.println("Error al listar estamentos: " + e);
    }
    return estamentos;
  }
}
