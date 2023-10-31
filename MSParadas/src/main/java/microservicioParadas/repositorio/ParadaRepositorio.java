package microservicioParadas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import microservicioParadas.modelo.Parada;

public interface ParadaRepositorio extends JpaRepository<Parada, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Parada p SET p.latitud = :latitud, p.longitud = :longitud WHERE p.id = :idParada")
	void actualizarParada(int idParada, float latitud, float longitud);
}
