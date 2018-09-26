package com.rfm.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rfm.model.Persona;
import com.rfm.utils.Factory;
import com.rfm.utils.FactoryBinary;
import com.rfm.utils.FactoryTxt;

@SuppressWarnings("unused")
public class Main {

	
	private static final String PRUEBA = "prueba.txt";
	private static final String ESCRITURA = "escritura.txt";
	static Factory factoriaTxt = new FactoryTxt();
	static Factory factoriaBinario = new FactoryBinary();
	static List<Persona> personas = new ArrayList<Persona>();
	static Scanner scanner = new Scanner(System.in);
	static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) throws IOException {

//		factoriaTxt.readFile(PRUEBA);

		builder
			.append("Introduzca un nombre, un apellido y un idioma para la persona ");
		
		while (personas.size() < 5) {
			personas.add(new Persona());
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Introduzca un nombre, un apellido y un idioma para la persona " + i + ": ");
			personas.get(i).setNombre(scanner.nextLine());
			personas.get(i).setApellido(scanner.nextLine());
			personas.get(i).setIdioma(scanner.nextLine());
		}
		
		
		
//		personas.get(0).setNombre("Ruben");
//		personas.get(0).setApellido("Fernandez");
//		personas.get(0).setIdioma("Ingles");
//		
//		personas.get(1).setNombre("Pepe");
//		personas.get(1).setApellido("Sacristán");
//		personas.get(1).setIdioma("Italiano");
//		
//		personas.get(2).setNombre("Marta");
//		personas.get(2).setApellido("Hernandez");
//		personas.get(2).setIdioma("Castellano");
//		
//		personas.get(3).setNombre("Dimitri");
//		personas.get(3).setApellido("Ascuas");
//		personas.get(3).setIdioma("Ruso");

		factoriaTxt.writeFile(ESCRITURA, personas);

	}

}
