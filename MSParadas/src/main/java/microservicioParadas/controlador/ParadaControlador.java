package microservicioParadas.controlador;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import microservicioParadas.dtos.ParadaDto;
import microservicioParadas.modelo.Parada;
import microservicioParadas.repositorio.ParadaRepositorio;
import microservicioParadas.servicio.ParadaServicio;

@RestController
@RequestMapping("/MSParada")
@Tag(name = "Servicio Parada", description = "se encarga de todo lo referente a las paradas")
public class ParadaControlador {

	@Autowired
	private ParadaRepositorio paradaRepositorio;
	@Autowired
	private ParadaServicio paradaServicio;

	// crear Parada
	@PostMapping
	public void crearParada(@RequestBody ParadaDto p) {
		paradaServicio.crearParada(p);
	}

	// eliminar parada
	@DeleteMapping("/borrar/{idParada}")
	public void eliminarParada(@PathVariable ObjectId idParada) {
		paradaRepositorio.deleteById(idParada);
	}

	// actualizar parada
	@PutMapping("/actualizarParada/{idParada}/{latitud}/{longitud}")
	public void modificarParada(@PathVariable ObjectId idParada, @PathVariable double latitud,
			@PathVariable double longitud) {
		paradaServicio.actualizarParada(idParada, latitud, longitud);
	}

	// buscar paradas cercanas
	@GetMapping("/buscarParadas/{latitud}/{longitud}/{margen}")
	public List<Parada> buscarParadas(@PathVariable float latitud, @PathVariable float longitud,
			@PathVariable float margen) {
		return paradaServicio.traerParadasCercanas(latitud, longitud, margen);
	}
}
