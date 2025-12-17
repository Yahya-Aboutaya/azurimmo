package bts.sio.azurimmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import bts.sio.azurimmo.model.dto.ContratDTO;
import bts.sio.azurimmo.service.ContratService;


@RestController
@RequestMapping("/api/contrats")
public class ContratController {
	@Autowired private ContratService service;
	
	@PostMapping
	public ContratDTO ajouter(@RequestBody ContratDTO dto) {
		return service.createContrat(dto);
		
	}
	
	@GetMapping
	public List<ContratDTO> lister(){
		return service.getTousLesContrats();
	}

}
