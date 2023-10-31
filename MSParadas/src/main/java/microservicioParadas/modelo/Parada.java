package microservicioParadas.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parada {
	// id viaje
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// posicion
	@Column
	private float latitud;
	@Column
	private float longitud;

	public Parada() {
	}

	public Parada(float latitud, float longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
}
