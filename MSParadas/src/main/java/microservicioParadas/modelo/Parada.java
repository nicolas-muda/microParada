package microservicioParadas.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parada")
public class Parada {
	@Id
	private ObjectId id;

    private double latitud; 
    private double longitud; 

    public Parada() {
    }

    public Parada(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}