package com.flores.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flores.model.CronogramaEvento;
import com.flores.model.dto.CronogramaEventoDto;
import com.flores.repository.CronogramaEventoRepository;

@RestController
@RequestMapping("/cronogramaevento")
public class CronogramaEventoController {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private CronogramaEventoRepository cronogramaEventoRepository;
	
	//Obtener cronograma segun tipo evento
	@GetMapping(path="/tipoEvento/{tipoEvento}")
	private List<CronogramaEventoDto> ListarSegunTipoEvento(@PathVariable String tipoEvento){
		Query sql = em.createNativeQuery("select ce.id, ce.fecha,ce.remove,ce.descripcion,ce.id_evento,ce.id_dia_semana from evento.cronograma_evento ce\r\n"
				+ "inner join evento.evento e on ce.id_evento = e.id\r\n"
				+ "inner join evento.tipo_evento t on e.tipo_evento_id = t.id and t.nombre = ?");
		sql.setParameter(1, tipoEvento);
		List<CronogramaEventoDto> listaCronogramaEvento =  new ArrayList<CronogramaEventoDto>();
		List<Object[]> result = sql.getResultList();
		for(Object[] r : result) {
			CronogramaEventoDto data = new CronogramaEventoDto(((Integer) r[0]).intValue(),(Date) r[1],(Boolean) r[2],String.valueOf(r[3]),((Integer) r[4]).intValue(),((Integer) r[5]).intValue());
			listaCronogramaEvento.add(data);
		}
		return listaCronogramaEvento;
	}
	//
	
	@GetMapping("/listar")
	private List<CronogramaEvento> show(){
		return cronogramaEventoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<CronogramaEvento> show(@PathVariable int id) {
		return cronogramaEventoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private CronogramaEvento create(@RequestBody CronogramaEventoDto cronogramaEvento) {
		CronogramaEvento cronogramaEventoNow = new CronogramaEvento();
		Instant date = Instant.now();
		cronogramaEventoNow.setFecha(cronogramaEvento.getFecha());
		cronogramaEventoNow.setIdEvento(cronogramaEvento.getIdEvento());
		cronogramaEventoNow.setIdDiaSemana(cronogramaEvento.getIdDiaSemana());
		cronogramaEventoNow.setCreatedAt(Timestamp.from(date));
		cronogramaEventoNow.setUpdatedAt(Timestamp.from(date));
		cronogramaEventoNow.setRemove(cronogramaEvento.isRemove());
		cronogramaEventoNow.setDescripcion(cronogramaEvento.getDescripcion());
		return cronogramaEventoRepository.save(cronogramaEventoNow);
	}
	
	@PutMapping(path ="/{id}")
	private CronogramaEvento update(@RequestBody CronogramaEventoDto cronogramaEvento,@PathVariable int id) {
		CronogramaEvento cronogramaEventoNow = cronogramaEventoRepository.findById(id).orElse(null);
		Instant date = Instant.now();
		cronogramaEventoNow.setFecha(cronogramaEvento.getFecha());
		cronogramaEventoNow.setIdEvento(cronogramaEvento.getIdEvento());
		cronogramaEventoNow.setIdDiaSemana(cronogramaEvento.getIdDiaSemana());
		cronogramaEventoNow.setCreatedAt(Timestamp.from(date));
		cronogramaEventoNow.setUpdatedAt(Timestamp.from(date));
		cronogramaEventoNow.setRemove(cronogramaEvento.isRemove());
		cronogramaEventoNow.setDescripcion(cronogramaEvento.getDescripcion());
		
		return cronogramaEventoRepository.save(cronogramaEventoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		cronogramaEventoRepository.deleteById(id);
	}
}
