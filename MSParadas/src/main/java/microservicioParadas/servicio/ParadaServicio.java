package microservicioParadas.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservicioParadas.controlador.ParadaControlador;
import microservicioParadas.modelo.Parada;
import microservicioParadas.repositorio.ParadaRepositorio;

@Service
public class ParadaServicio {
	@Autowired
	private ParadaRepositorio paradaRepositorio;

	public List<Parada> traerParadasCercanas(float latitud, float longitud, float margen) {
		List<Parada> paradas = paradaRepositorio.findAll();
		List<Parada> resultado = new ArrayList<Parada>();
		for (int i = 0; i < paradas.size(); i++) {
			double diferenciaLat = paradas.get(i).getLatitud() - latitud;
			double diferenciaLon = paradas.get(i).getLongitud() - longitud;
			if (diferenciaLat < 0) {
				diferenciaLat *= -1;
			}
			if (diferenciaLon < 0) {
				diferenciaLon *= -1;
			}
			if ((diferenciaLat <= margen) && (diferenciaLon <= margen)) {
				resultado.add(paradas.get(i));
			}
		}
		return resultado;
	}

	public void actualizarParada(ObjectId idParada, double latitud, double longitud) {
		// TODO Auto-generated method stub
		Optional<Parada> paradaExistente = paradaRepositorio.findById(idParada);
		if (paradaExistente.isPresent()) {
			Parada parada = paradaExistente.get();
			parada.setLatitud(latitud);
			parada.setLongitud(longitud);
			paradaRepositorio.save(parada);
		}
	}

}
