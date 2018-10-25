package com.rfm.modelos;

public class SuperGuerrero extends SuperEspecie {

	private long idSuperGuerrero;
	private long idSuperEspecie;
	private String nombre;
	private String descripción;
	private TiposPoder tipoPoder;
	private int nivelPoder;

	public SuperGuerrero() {

	}

	public SuperGuerrero(long idSuperEspecie, String nombre, long idSuperGuerrero, String descripción,
			TiposPoder tipoPoder, int nivelPoder) {
		super(idSuperEspecie, nombre);
		this.idSuperGuerrero = idSuperGuerrero;
		this.descripción = descripción;
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

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public TiposPoder getTipoPoder() {
		return tipoPoder;
	}

	public void setTipoPoder(TiposPoder tipoPoder) {
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
		builder.append(descripción);
		builder.append(", tipoPoder=");
		builder.append(tipoPoder);
		builder.append(", nivelPoder=");
		builder.append(nivelPoder);
		builder.append("]");
		return builder.toString();
	}

}
