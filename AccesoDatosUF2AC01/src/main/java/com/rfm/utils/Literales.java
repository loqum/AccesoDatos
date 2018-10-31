package com.rfm.utils;

public class Literales {

	private Literales() {
		throw new IllegalStateException("Utility class");
	}

	private static final String SALIDA_PROGRAMA = "Saliendo del programa...";
	private static final String CONEXION_ESTABLECIDA = "Conexión establecida...";
	private static final String CONEXION_ERROR = "No se ha podido establecer la conexión: ";
	private static final String USER = "root";
	private static final String PASS = "fihoca";
	private static final String URL = "jdbc:mysql://localhost:3306/accesodatos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	private static final String INTRODUCE_NOMBRE_GUERRERO = "Introduce un nombre para el nuevo Super Guerrero: ";
	private static final String INTRODUCE_DESCRIPCION_GUERRERO = "Introduce una descripcion para ";
	private static final String INTRODUCE_TIPOPODER_GUERRERO = "Introduce un tipo de poder (Agua, Fuego, Viento) para ";
	private static final String INTRODUCE_NIVELPODER_GUERRERO = "Introduce el nivel de poder (1-5) para ";
	private static final String INTRODUCE_NOMBRE_ESPECIE = "Introduce un nombre para la nueva Super Especie: ";
	private static final String INTRODUCE_PODER_ERROR = "Debe introducir un poder de la lista";
	private static final String INTRODUCE_TIPO_ESPECIE = "¿A que Super Especie quieres que pertenezca este Super Guerrero? Introduzca el Id: ";
	private static final String INTRODUCE_ID_ERROR = "Debe introducir un Id que aparezca en la lista";
	private static final String REGISTRO_EXITO_INSERT = "El registro se ha insertado satisfactoriamente";
	private static final String REGISTRO_EXITO_RESET = "El registro se ha reseteado satisfactoriamente";
	private static final String REGISTRO_EXITO_DELETE = "El registro se ha reseteado satisfactoriamente";
	private static final String REGISTRO_ERROR_SELECT = "No se ha podido consultar el registro";
	private static final String REGISTRO_ERROR_INSERT = "No se ha podido insertar el registro";
	private static final String REGISTRO_ERROR_RESET = "No se ha podido resetear el registro";
	private static final String REGISTRO_ERROR_DELETE = "No se ha podido eliminar el registro";
	private static final String ENTRADA_INVALIDA = "\nDebe introducir un valor numerico que se corresponda con las instrucciones.\n";

	private static final String INSERT_SUPERESPECIE = "INSERT INTO superespecie (nombre) VALUES (?);";
	private static final String INSERT_SUPERGUERRERO = "INSERT INTO superguerrero (idsuperespecie, nombre, descripcion, tipopoder, nivelpoder) VALUES (?,?,?,?,?);";
	private static final String UPDATE_PODER = "";
	private static final String SELECT_SUPERGUERRERO = "SELECT * FROM superguerrero";
	private static final String RESET_SUPERGUERRERO = "";
	private static final String DELETE_SUPERGUERRERO = "DELETE FROM superguerrero WHERE idsuperguerrero=(?)";
	private static final String DELETE_SUPERESPECIE = "DELETE FROM superespecie WHERE idsuperespecie=(?)";
	private static final String SELECT_SUPERESPECIE = "SELECT * FROM superespecie";

	private static final String ESQUELETO_LATERAL = "\n*										*";
	private static final String ESQUELETO_VERTICAL = "\n*********************************************************************************";

	private static StringBuilder builderBienvenidaPrograma = new StringBuilder();

	private static final StringBuilder BIENVENIDA_PROGRAMA = builderBienvenidaPrograma.append(ESQUELETO_VERTICAL)
			.append(ESQUELETO_LATERAL).append("\n*				Elija una opcion:				*")
			.append(ESQUELETO_LATERAL).append("\n").append("*	0: Salir del programa							*")
			.append("\n").append("*	1: Crear Super Especie							*").append("\n")
			.append("*	2: Añadir Super Guerrero						*").append("\n")
			.append("*	3: Insertar nivel de poder en Super Guerrero				*").append("\n")
			.append("*	4: Consultar								*").append("\n")
			.append("*	5: Resetear Super Guerrero						*").append("\n")
			.append("*	6: Eliminar Super Guerrero						*").append("\n")
			.append("*	7: Eliminar Super Especie						*").append("\n")
			.append("*	8: Ver instrucciones							*").append(ESQUELETO_LATERAL)
			.append(ESQUELETO_LATERAL).append(ESQUELETO_VERTICAL);

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

	public static String getReserSuperGuerrero() {
		return RESET_SUPERGUERRERO;
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

}
