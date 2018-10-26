package com.rfm.utils;

public class Literales {
	
	private static final String SALIDA_PROGRAMA = "Saliendo del programa...";
	private static final String INTRODUCE_NOMBRE_GUERRERO = "Introduce un nombre para el nuevo Super Guerrero: ";
	private static final String INTRODUCE_DESCRIPCION_GUERRERO = "Introduce una descripción para ";
	private static final String INTRODUCE_TIPOPODER_GUERRERO = "Introduce un tipo de poder (Agua, Fuego, Viento) para ";
	private static final String INTRODUCE_NIVELPODER_GUERRERO = "Introduce el nivel de poder (1-5) para ";
	private static final String INTRODUCE_NOMBRE_ESPECIE = "Introduce un nombre para la nueva Super Especie: ";
	private static final String INTRODUCE_PODER_ERROR = "Debe introducir un poder de la lista";
	private static final String REGISTRO_EXITO_INSERT = "El registro se ha insertado satisfactoriamente";
	private static final String REGISTRO_EXITO_RESET = "El registro se ha reseteado satisfactoriamente";
	private static final String REGISTRO_EXITO_DELETE = "El registro se ha reseteado satisfactoriamente";
	private static final String REGISTRO_ERROR_SELECT = "No se ha podido consultar el registro";
	private static final String REGISTRO_ERROR_INSERT = "No se ha podido insertar el registro";
	private static final String REGISTRO_ERROR_RESET = "No se ha podido resetear el registro";
	private static final String REGISTRO_ERROR_DELETE = "No se ha podido eliminar el registro";
	private static final String ENTRADA_INVALIDA = "\nDebe introducir un valor numerico que se corresponda con las instrucciones.\n";

	private static final String ADDSUPERESPECIE = "INSERT INTO superespecie (nombre) VALUES (?);";
	private static final String ADDGUERRERO = "INSERT INTO superguerrero (idsuperespecie, nombre, descripcion, tipopoder, nivelpoder) VALUES (?,?,?,?,?);";
	private static final String ADDPODER = "";
	private static final String READ = "SELECT * FROM superespecie";
	private static final String RESET = "";
	private static final String DELETEGUERRERO = "DELETE FROM superguerrero WHERE idsuperguerrero=(?)";
	private static final String DELETEESPECIE = "DELETE FROM superespecie WHERE idsuperguerrero=(?)";
	
	private static StringBuilder builderBienvenidaPrograma = new StringBuilder();
	
	private static final StringBuilder BIENVENIDA_PROGRAMA = builderBienvenidaPrograma
			.append("\n*********************************************************************************")
			.append("\n*										*")
			.append("\n*				Elija una opcion:				*")
			.append("\n*										*")
			.append("\n")
			.append("*	0: Salir del programa							*")
			.append("\n")
			.append("*	1: Crear Super Especie							*")
			.append("\n")
			.append("*	2: Añadir Super Guerrero						*")
			.append("\n")
			.append("*	3: Insertar nivel de poder en Super Guerrero				*")
			.append("\n")
			.append("*	4: Consultar								*")
			.append("\n")
			.append("*	5: Resetear Super Guerrero						*")
			.append("\n")
			.append("*	6: Eliminar Super Guerrero						*")
			.append("\n")
			.append("*	7: Eliminar Super Especie						*")
			.append("\n")
			.append("*	8: Ver instrucciones							*")
			.append("\n*										*")
			.append("\n*										*")
			.append("\n*********************************************************************************");

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

	public static String getAddsuperespecie() {
		return ADDSUPERESPECIE;
	}

	public static String getAddguerrero() {
		return ADDGUERRERO;
	}

	public static String getAddpoder() {
		return ADDPODER;
	}

	public static String getRead() {
		return READ;
	}

	public static String getReset() {
		return RESET;
	}

	public static String getDeleteguerrero() {
		return DELETEGUERRERO;
	}

	public static String getDeleteespecie() {
		return DELETEESPECIE;
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

}
