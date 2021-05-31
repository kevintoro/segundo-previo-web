package com.ufps.web.kevintoro.EleccionesElectronicas.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class ConnectionDB {
  private Connection connection = null;
  private PreparedStatement preparedStatement = null;
  private static ConnectionDB connectionDB;
  private static final String url = "jdbc:postgresql://queenie.db.elephantsql.com:5432/";
  private static final String dbName = "mnjgxshj";
  private static final String driver = "org.postgresql.Driver";
  private static final String username = "mnjgxshj";
  private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
  
  
  public ConnectionDB() {
    try {
      Class.forName(driver).getDeclaredConstructor().newInstance();
      connection = DriverManager.getConnection(url + dbName, username, password);
    } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
      System.out.println("Error: " + e);
    }
  }
  
  public void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {
      System.out.println("Error cerrando: " + e);
    }
  }
  
  public ResultSet executeQuery() throws SQLException {
    return preparedStatement.executeQuery();
  }
  
  public int executeStatement() throws SQLException {
    return preparedStatement.executeUpdate();
  }
  
  public static ConnectionDB getConnection() {
    if (connectionDB == null) {
      connectionDB = new ConnectionDB();
    }
    return connectionDB;
  }
  
  public PreparedStatement setPreparedStatement(String sql) throws SQLException {
    this.preparedStatement = connection.prepareStatement(sql);
    return preparedStatement;
  }
}