package com.rfm.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Validaciones {

  private static final Logger LOGGER = 
      Logger.getLogger(com.rfm.dao.SuperEspecieDaoImpl.class.getName());

  private Validaciones() {
    throw new IllegalStateException("Utility class");
  }

  private static final String AGUA = "agua";
  private static final String FUEGO = "fuego";
  private static final String VIENTO = "viento";

  /**
   * Comprueba si el valor obtenido por pantalla es un valor numerico.
   * @param eleccion
   *  Resultado obtenido por consola por parte del usuario.
   * @return 
   *  Boolean.
   */
  
  public static boolean isValidNumber(String eleccion) {
    String regex = "\\d+";
    Pattern pattern = Pattern.compile(regex);
    boolean validNumber;

    validNumber = (pattern.matcher(eleccion.trim()).matches());
    return validNumber;

  }

  /**
   * Comprueba si el valor obtenido por pantalla es un valor 
   * que coincide con las instrucciones (Agua, Fuego, Viento).
   * @param poder 
   *  Resultado obtenido por consola por parte del usuario.
   * @return 
   *  Boolean.
   */
  
  public static boolean isValidPower(String poder) {
    boolean validPower;
    validPower = (poder.trim().equalsIgnoreCase(AGUA) || poder.trim().equalsIgnoreCase(FUEGO)
        || poder.trim().equalsIgnoreCase(VIENTO));
    return validPower;
  }

  /**
   * Comprueba si el valor obtenido por pantalla es un valor
   * que coincide con las instrucciones (1-5).
   * @param nivel
   *  Resultado obtenido por consola por parte del usuario.
   * @return 
   *  Boolean.
   */
  
  public static boolean isValidLevel(int nivel) {
    boolean validLevel;
    validLevel = (nivel >= 1 && nivel <= 5);
    return validLevel;
  }

  /**
   * Comprueba si el valor obtenido por pantalla es un valor
   * que coincide con el ID de cualquier registro de la BD.
   * @param primerId 
   *  ID que desea comprobar si existe paralelo en la BD.
   * @param segundoId
   *  Lista de ID's que existen en la BD.
   * @return
   *  Boolean.
   */
  
  public static boolean isValidId(String primerId, List<String> segundoId) {
    for (String resultadosSegundoId : segundoId) {
      if (primerId.trim().equals(resultadosSegundoId)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Comprueba si existe cualquier registro en la BD.
   * @param query
   *  Query del tipo SELECT definida por el usuario.
   * @return
   *  Boolean.
   * @throws SQLException
   *  Puede devolver una excepcion como resultado de una incorrecta conexion con la BD.
   */
  public static boolean ifExists(String query) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = ConnectionDataBase.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(query);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        return resultSet.next();
      }

    } catch (SQLException e) {
      LOGGER.error(Literales.getConexionError(), e);

    } finally {

      if (preparedStatement != null) {
        preparedStatement.close();
      }

    }

    return false;

  }

}
