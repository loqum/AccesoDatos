package com.rfm.modelos;

public class SuperGuerrero extends SuperEspecie {

	private long idSuperGuerrero;
	private long idSuperEspecie;
	private String nombre;
	private String descripcion;
	private String tipoPoder;
	private int nivelPoder;

	public SuperGuerrero() {

	}

	public SuperGuerrero(long idSuperEspecie, String nombre, long idSuperGuerrero, String descripcion,
			String tipoPoder, int nivelPoder) {
		super(idSuperEspecie, nombre);
		this.idSuperGuerrero = idSuperGuerrero;
		this.descripcion = descripcion;
		this.tipoPoder = tipoPoder;
		this.nivelPoder = nivelPoder;
	}

	public long getIdSuperGuerrero() {
		return idSuperGuerrero;
	}

	public long getIdSuperEspecie() {
		return idSuperEspecie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoPoder() {
		return tipoPoder;
	}

	public void setTipoPoder(String tipoPoder) {
		this.tipoPoder = tipoPoder;
	}

	public int getNivelPoder() {
		return nivelPoder;
	}

	public void setNivelPoder(int nivelPoder) {
		this.nivelPoder = nivelPoder;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SuperGuerrero [idSuperGuerrero=");
		builder.append(idSuperGuerrero);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripción=");
		builder.append(descripcion);
		builder.append(", tipoPoder=");
		builder.append(tipoPoder);
		builder.append(", nivelPoder=");
		builder.append(nivelPoder);
		builder.append("]");
		return builder.toString();
	}

}
