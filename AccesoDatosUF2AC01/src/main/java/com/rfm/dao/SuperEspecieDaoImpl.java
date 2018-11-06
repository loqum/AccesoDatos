package com.rfm.dao;

import com.rfm.dto.SuperEspecieDto;
import com.rfm.utils.ConnectionDataBase;
import com.rfm.utils.Literales;
import com.rfm.utils.Validaciones;
import com.rfm.view.Consola;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class SuperEspecieDaoImpl implements SuperEspecieDao {

  private static Scanner scanner = new Scanner(System.in);
  private static final Logger LOGGER = 
      Logger.getLogger(com.rfm.dao.SuperEspecieDaoImpl.class.getName());
  private static PreparedStatement preparedStatement = null;
  private static Statement statement = null;
  private static ResultSet resultSet = null;
  private static List<String> listaIdSuperEspecie = new ArrayList<>();

  @Override
  public synchronized void createSuperEspecie(SuperEspecieDto superEspecie) throws SQLException {
    Connection connection = null;
    System.out.println(Literales.getIntroduceNombreEspecie());
    superEspecie.setNombre(scanner.nextLine());

    try {
      connection = ConnectionDataBase.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(Literales.getInsertSuperEspecie());
      preparedStatement.setString(1, Consola.getSuperEspecie().getNombre());

      if (preparedStatement.executeUpdate() > 0) {
        LOGGER.debug(Literales.getRegistroExitoInsert());
        System.out.println(Literales.getRegistroExitoInsert());

      } else {
        LOGGER.debug(Literales.getRegistroErrorInsert());
      }

    } catch (SQLException e) {
      LOGGER.error(Literales.getRegistroErrorInsert(), e);
      System.out.println(Literales.getRegistroErrorInsert());

    } finally {

      if (preparedStatement != null) {
        preparedStatement.close();
      }

    }

    System.out.println(Literales.getBienvenidaPrograma());

  }

  @Override
  public synchronized void readSuperEspecie(SuperEspecieDto superEspecie) throws SQLException {
    Connection connection = null;
    long idSuperEspecie = 0;
    String nombre = null;
    String output = null;

    try {
      connection = ConnectionDataBase.getInstance().getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(Literales.getSelectSuperespecie());

      if (!Validaciones.ifExists(Literales.getSelectSuperespecie())) {
        System.out.println(Literales.getErrorNoSuperespecie());
        Consola.init();
      }

      while (resultSet.next()) {
        idSuperEspecie = resultSet.getLong(Literales.getIdSuperespecie());
        nombre = resultSet.getString(Literales.getNombre());

        output = Literales.getOutputFormatSuperespecie();
        listaIdSuperEspecie.add(String.valueOf(idSuperEspecie));

        if (!listaIdSuperEspecie.isEmpty()) {
          System.out.println(String.format(output, idSuperEspecie, nombre));
        } else {
          System.out.println(Literales.getErrorNoSuperGuerrero());
        }
      }

    } catch (SQLException e) {
      LOGGER.error(Literales.getRegistroErrorSelect(), e);
      System.out.println(Literales.getRegistroErrorSelect());

    }

  }

  @Override
  public synchronized void deleteSuperEspecie(SuperEspecieDto superEspecie) throws SQLException {
    Connection connection = null;
    long idSuperEspecie = 0;
    String nombre = null;
    String output = null;
    String id = null;

    try {
      connection = ConnectionDataBase.getInstance().getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(Literales.getSelectSuperespecie());

      if (!Validaciones.ifExists(Literales.getSelectSuperespecie())) {
        System.out.println(Literales.getErrorNoSuperespecie());
        Consola.init();
      } else {
        System.out.println(Literales.getIntroduceIdSuperespecie());
      }

      while (resultSet.next()) {
        idSuperEspecie = resultSet.getLong(Literales.getIdSuperespecie());
        nombre = resultSet.getString(Literales.getNombre());

        output = Literales.getOutputFormatSuperespecie();
        listaIdSuperEspecie.add(String.valueOf(idSuperEspecie));
        if (!listaIdSuperEspecie.isEmpty()) {
          System.out.println(String.format(output, idSuperEspecie, nombre));
        }
      }

      id = scanner.nextLine();

      while (!Validaciones.isValidNumber(String.valueOf(id))
          || !Validaciones.isValidId(String.valueOf(id), listaIdSuperEspecie)) {
        System.out.println(Literales.getIntroduceIdError());
        id = scanner.nextLine();
      }

      preparedStatement = connection.prepareStatement(Literales.getDeleteSuperEspecie());
      preparedStatement.setLong(1, Long.parseLong(id));

      if (preparedStatement.executeUpdate() > 0) {
        LOGGER.debug(Literales.getRegistroExitoDelete());
        System.out.println(Literales.getRegistroExitoDelete());

      } else {
        LOGGER.debug(Literales.getRegistroErrorDelete());
        System.out.println(Literales.getRegistroErrorDelete());
      }

    } catch (SQLException e) {

      LOGGER.error(Literales.getRegistroErrorDelete(), e);
      System.out.println(Literales.getRegistroErrorDelete());
    }
  }

}
