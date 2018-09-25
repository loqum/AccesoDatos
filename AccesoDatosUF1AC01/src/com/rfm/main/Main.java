package com.rfm.main;

import com.rfm.pojo.Persona;

public class Main {

	public static void main(String[] args) {

		Persona personaUno = new Persona();

		personaUno.setNombre("Juan");
		personaUno.setApellido("Garcia");
		personaUno.setContrasenya("12345Juan");
		personaUno.setIdioma("Ingles");
		personaUno.setUsuario("JuanGar");

		System.out.println(personaUno.toString());

		Persona personaDos = new Persona("Pepe", "Fernandez", "Italiano", "PepeFer", "12974hjuj");

		System.out.println(personaDos.toString());

	}

}
