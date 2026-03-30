package bts.sio.azurimmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import bts.sio.azurimmo.model.dto.ContratDTO;
import bts.sio.azurimmo.service.ContratService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@CrossOrigin("http://localhost:5173")
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
	
	@GetMapping("/appartement/{appartementId}")
    @Operation(summary = "Récupère les contrats liés à un appartement précis")
    public List<ContratDTO> getContratsByAppartement(@PathVariable Long appartementId) {
        return service.getContratsByAppartementId(appartementId);
    }

}
