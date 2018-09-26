package com.rfm.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rfm.model.Persona;
import com.rfm.model.Usuario;
import com.rfm.utils.Factory;
import com.rfm.utils.FactoryBinary;
import com.rfm.utils.FactoryTxt;

public class Main {

	private static final String TXT = "archivo.txt";
	private static final String BINARIO = "archivo.dat";
	static Factory factoriaTxt = new FactoryTxt();
	static Factory factoriaBinario = new FactoryBinary();
	static List<Persona> personas = new ArrayList<Persona>();
	static List<Usuario> usuarios = new ArrayList<Usuario>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		while (personas.size() < 5) {
			personas.add(new Persona());
			usuarios.add(new Usuario());
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("Introduzca un nombre, un apellido y un idioma para la persona " + i + ": ");
			personas.get(i).setNombre(scanner.nextLine());
			personas.get(i).setApellido(scanner.nextLine());
			personas.get(i).setIdioma(scanner.nextLine());
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("Introduzca un nombre de usuario y una contraseña para el usuario " + i + ": ");
			usuarios.get(i).setNombre(scanner.nextLine());
			usuarios.get(i).setContrasenya(scanner.nextLine());
		}

		factoriaTxt.writeFile(TXT, personas);
		factoriaTxt.readFile(TXT);

		factoriaBinario.writeFile(BINARIO, usuarios);
		factoriaBinario.readFile(BINARIO);

	}

}
