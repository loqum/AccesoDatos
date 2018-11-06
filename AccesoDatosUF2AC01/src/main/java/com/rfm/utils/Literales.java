package com.rfm.utils;

public class Literales {

  private Literales() {
    throw new IllegalStateException("Utility class");
  }

  private static final String SALIDA_PROGRAMA = 
      "Saliendo del programa...";
  private static final String CONEXION_ESTABLECIDA = 
      "Conexion establecida...";
  private static final String CONEXION_ERROR = 
      "No se ha podido establecer la conexión: ";
  private static final String USER = 
      "root";
  private static final String PASS = 
      "fihoca";
  private static final String URL = 
      "jdbc:mysql://localhost:3306/accesodatos?useUnicode=true&useJDBCCompliantTimezoneShift="
      + "true&useLegacyDatetimeCode=false&serverTimezone=UTC";

  private static final String INTRODUCE_NOMBRE_GUERRERO = 
      "Introduce un nombre para el nuevo Super Guerrero: ";
  private static final String INTRODUCE_DESCRIPCION_GUERRERO = 
      "Introduce una descripcion para ";
  private static final String INTRODUCE_TIPOPODER_GUERRERO = 
      "Introduce un tipo de poder (Agua, Fuego, Viento) para ";
  private static final String INTRODUCE_NIVELPODER_GUERRERO = 
      "Introduce el nivel de poder (1-5) para ";
  private static final String INTRODUCE_NOMBRE_ESPECIE = 
      "Introduce un nombre para la nueva Super Especie: ";
  private static final String INTRODUCE_PODER_ERROR = 
      "Debe introducir un poder de la lista";
  private static final String INTRODUCE_TIPO_ESPECIE = 
      "¿A que Super Especie quieres que pertenezca este Super Guerrero? Introduce el Id: ";
  private static final String INTRODUCE_ID_SUPERGUERRERO = 
      "Selecciona por su número de ID el Super Guerrero que quieres borrar: ";
  private static final String INTRODUCE_ID_SUPERESPECIE = 
      "Selecciona por su número de ID la Super Especie que quieres borrar: ";
  private static final String INTRODUCE_ID_RESET_SUPERGUERRERO = 
      "Selecciona por su número de ID el Super Guerrero al que quieres resetear su poder: ";
  private static final String INTRODUCE_ID_UPDATE_SUPERGUERRERO = 
      "Selecciona por su número de ID el Super Guerrero al que quieres actualizar su poder: ";
  private static final String INTRODUCE_ID_ERROR = 
      "Debe introducir un Id que aparezca en la lista";
  private static final String REGISTRO_EXITO_INSERT = 
      "El registro se ha insertado satisfactoriamente";
  private static final String REGISTRO_EXITO_RESET = 
      "El registro se ha reseteado satisfactoriamente";
  private static final String REGISTRO_EXITO_DELETE = 
      "El registro se ha eliminado satisfactoriamente";
  private static final String REGISTRO_ERROR_SELECT = 
      "No se ha podido consultar el registro";
  private static final String REGISTRO_ERROR_INSERT = 
      "No se ha podido insertar el registro";
  private static final String REGISTRO_ERROR_RESET = 
      "No se ha podido resetear el registro";
  private static final String REGISTRO_ERROR_DELETE = 
      "No se ha podido eliminar el registro";
  private static final String ENTRADA_INVALIDA = 
      "\nDebes introducir un valor numerico que se corresponda con las instrucciones.\n";
  private static final String ERROR_NO_SUPERGUERRERO = 
      "No hay ningun Super Guerrero";
  private static final String ERROR_NO_SUPERESPECIE = 
      "No hay ninguna Super Especie";

  private static final String INSERT_SUPERESPECIE = 
      "INSERT INTO superespecie (nombre) VALUES (?);";
  private static final String INSERT_SUPERGUERRERO = 
      "INSERT INTO superguerrero "
      + "(idsuperespecie, nombre, descripcion, tipopoder, nivelpoder) VALUES (?,?,?,?,?);";
  private static final String UPDATE_PODER = 
      "UPDATE superguerrero SET tipopoder=(?), nivelpoder=(?) WHERE idsuperguerrero=(?)";
  private static final String SELECT_SUPERGUERRERO = 
      "SELECT * FROM superguerrero";
  private static final String RESET_PODER_SUPERGUERRERO = 
      "UPDATE superguerrero SET tipopoder = null, nivelpoder = null WHERE idsuperguerrero=(?);";
  private static final String DELETE_SUPERGUERRERO = 
      "DELETE FROM superguerrero WHERE idsuperguerrero=(?)";
  private static final String DELETE_SUPERESPECIE = 
      "DELETE FROM superespecie WHERE idsuperespecie=(?)";
  private static final String SELECT_SUPERESPECIE = 
      "SELECT * FROM superespecie";
  private static final String OUTPUT_FORMAT_SUPERGUERRERO = 
      "Super Guerrero #%d:\n\t · ID SuperEspecie: %d "
      + "· Nombre: %s · Descripcion: %s · Tipo de poder: %s · Nivel de poder: %d";
  private static final String OUTPUT_FORMAT_SUPERESPECIE = 
      "Super Especie #%d: \n\t· Nombre: %s";

  private static final String DESCRIPCION_SUPERGUERRERO = 
      "descripcion";
  private static final String NOMBRE = 
      "nombre";
  private static final String TIPO_PODER_SUPERGUERRERO = 
      "tipopoder";
  private static final String NIVEL_PODER_SUPERGUERRERO = 
      "nivelpoder";
  private static final String ID_SUPERGUERRERO = 
      "idsuperguerrero";
  private static final String ID_SUPERESPECIE = 
      "idsuperespecie";

  private static final String ESQUELETO_LATERAL = 
      "\n*                                             *";
  private static final String ESQUELETO_VERTICAL = 
      "\n***********************************************";

  private static StringBuilder builderBienvenidaPrograma = new StringBuilder();

  private static final StringBuilder BIENVENIDA_PROGRAMA = 
      builderBienvenidaPrograma.append(ESQUELETO_VERTICAL)
      .append(ESQUELETO_LATERAL)
      .append("\n*        Elija una opcion:                    *")
      .append(ESQUELETO_LATERAL)
      .append("\n")
      .append("*     0: Salir del programa                   *")
      .append("\n")
      .append("*     1: Crear Super Especie                  *")
      .append("\n")
      .append("*     2: Crear Super Guerrero                 *")
      .append("\n")
      .append("*     3: Consultar Super Especie              *")
      .append("\n")
      .append("*     4: Consultar Super Guerrero             *")
      .append("\n")
      .append("*     5: Añadir poder a Super Guerrero        *")
      .append("\n")
      .append("*     6: Resetear poderes de Super Guerrero   *")
      .append("\n")
      .append("*     7: Eliminar Super Guerrero              *")
      .append("\n")
      .append("*     8: Eliminar Super Especie               *")
      .append("\n")
      .append("*     9: Ver instrucciones                    *")
      .append(ESQUELETO_LATERAL).append(ESQUELETO_LATERAL).append(ESQUELETO_VERTICAL);

  public static StringBuilder getBienvenidaPrograma() {
    return BIENVENIDA_PROGRAMA;
  }

  public static String getSalidaPrograma() {
    return SALIDA_PROGRAMA;
  }

  public static String getIntroduceNombreGuerrero() {
    return INTRODUCE_NOMBRE_GUERRERO;
  }

  public static String getIntroduceDescripcionGuerrero() {
    return INTRODUCE_DESCRIPCION_GUERRERO;
  }

  public static String getIntroduceTipopoderGuerrero() {
    return INTRODUCE_TIPOPODER_GUERRERO;
  }

  public static String getIntroduceNivelpoderGuerrero() {
    return INTRODUCE_NIVELPODER_GUERRERO;
  }

  public static String getIntroduceNombreEspecie() {
    return INTRODUCE_NOMBRE_ESPECIE;
  }

  public static String getInsertSuperEspecie() {
    return INSERT_SUPERESPECIE;
  }

  public static String getInsertSuperGuerrero() {
    return INSERT_SUPERGUERRERO;
  }

  public static String getUpdatePoder() {
    return UPDATE_PODER;
  }

  public static String getSelectSuperGuerrero() {
    return SELECT_SUPERGUERRERO;
  }

  public static String getResetPoderSuperGuerrero() {
    return RESET_PODER_SUPERGUERRERO;
  }

  public static String getDeleteSuperGuerrero() {
    return DELETE_SUPERGUERRERO;
  }

  public static String getDeleteSuperEspecie() {
    return DELETE_SUPERESPECIE;
  }

  public static String getRegistroExitoInsert() {
    return REGISTRO_EXITO_INSERT;
  }

  public static String getRegistroErrorInsert() {
    return REGISTRO_ERROR_INSERT;
  }

  public static String getIntroducePoderError() {
    return INTRODUCE_PODER_ERROR;
  }

  public static String getRegistroErrorSelect() {
    return REGISTRO_ERROR_SELECT;
  }

  public static String getRegistroErrorReset() {
    return REGISTRO_ERROR_RESET;
  }

  public static String getRegistroErrorDelete() {
    return REGISTRO_ERROR_DELETE;
  }

  public static String getEntradaInvalida() {
    return ENTRADA_INVALIDA;
  }

  public static String getRegistroExitoReset() {
    return REGISTRO_EXITO_RESET;
  }

  public static String getRegistroExitoDelete() {
    return REGISTRO_EXITO_DELETE;
  }

  public static String getIntroduceTipoEspecie() {
    return INTRODUCE_TIPO_ESPECIE;
  }

  public static String getSelectSuperespecie() {
    return SELECT_SUPERESPECIE;
  }

  public static String getIntroduceIdError() {
    return INTRODUCE_ID_ERROR;
  }

  public static String getConexionEstablecida() {
    return CONEXION_ESTABLECIDA;
  }

  public static String getConexionError() {
    return CONEXION_ERROR;
  }

  public static String getUser() {
    return USER;
  }

  public static String getPass() {
    return PASS;
  }

  public static String getUrl() {
    return URL;
  }

  public static String getOutputFormatSuperGuerrero() {
    return OUTPUT_FORMAT_SUPERGUERRERO;
  }

  public static String getIntroduceIdSuperguerrero() {
    return INTRODUCE_ID_SUPERGUERRERO;
  }

  public static String getErrorNoSuperGuerrero() {
    return ERROR_NO_SUPERGUERRERO;
  }

  public static String getIntroduceIdSuperespecie() {
    return INTRODUCE_ID_SUPERESPECIE;
  }

  public static String getOutputFormatSuperespecie() {
    return OUTPUT_FORMAT_SUPERESPECIE;
  }

  public static String getIntroduceIdResetSuperguerrero() {
    return INTRODUCE_ID_RESET_SUPERGUERRERO;
  }

  public static String getIntroduceIdUpdateSuperguerrero() {
    return INTRODUCE_ID_UPDATE_SUPERGUERRERO;
  }

  public static String getTipoPoderSuperguerrero() {
    return TIPO_PODER_SUPERGUERRERO;
  }

  public static String getNivelPoderSuperguerrero() {
    return NIVEL_PODER_SUPERGUERRERO;
  }

  public static String getDescripcionSuperguerrero() {
    return DESCRIPCION_SUPERGUERRERO;
  }

  public static String getIdSuperguerrero() {
    return ID_SUPERGUERRERO;
  }

  public static String getIdSuperespecie() {
    return ID_SUPERESPECIE;
  }

  public static String getNombre() {
    return NOMBRE;
  }

  public static String getErrorNoSuperespecie() {
    return ERROR_NO_SUPERESPECIE;
  }

}
