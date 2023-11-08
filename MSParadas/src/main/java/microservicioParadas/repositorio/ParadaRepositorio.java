package microservicioParadas.repositorio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import microservicioParadas.modelo.Parada;

public interface ParadaRepositorio extends MongoRepository<Parada, ObjectId> {

	

}
