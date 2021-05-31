package com.ufps.web.kevintoro.EleccionesElectronicas.DAO;

import com.ufps.web.kevintoro.EleccionesElectronicas.model.TipoDocumento;
import com.ufps.web.kevintoro.EleccionesElectronicas.util.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDocumentoDAO {
  private final ConnectionDB connectionDB;
  public final static String GET_TIPO_DOCUMENTOS = "select * from tipodocumento;";
  public TipoDocumentoDAO() {
    connectionDB = ConnectionDB.getConnection();
  }
  
  public List<TipoDocumento> listarTipoDocumento() {
    List<TipoDocumento> tipoDocumentos = new ArrayList<>();
    try {
      PreparedStatement statement = connectionDB.setPreparedStatement(GET_TIPO_DOCUMENTOS);
      ResultSet resultSet = connectionDB.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String descripcion = resultSet.getString("descripcion");
        tipoDocumentos.add(new TipoDocumento(id, descripcion));
      }
    } catch (SQLException e) {
      System.out.println("Error al listar tipos de documentos: " + e);
    }
    return tipoDocumentos;
  }
}
