package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.dto.InterventionDTO;
import bts.sio.azurimmo.service.InterventionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/interventions")
@Tag(name = "Interventions", description = "Gestion des réparations et interventions")
public class InterventionController {

    @Autowired
    private InterventionService interventionService;

    @GetMapping("/")
    @Operation(summary = "Récupère toutes les interventions")
    public List<InterventionDTO> getAllInterventions() {
        return interventionService.getAllInterventions();
    }
    
    @GetMapping("/appartement/{appartementId}")
    @Operation(summary = "Récupère toutes les interventions d'un appartement précis")
    public List<InterventionDTO> getInterventionsByAppartement(@PathVariable Long appartementId) {
        return interventionService.getInterventionsByAppartementId(appartementId);
    }

    @PostMapping("/")
    @Operation(summary = "Crée une nouvelle intervention (liée à un appartement)")
    public ResponseEntity<InterventionDTO> createIntervention(@RequestBody InterventionDTO dto) {
        InterventionDTO savedDTO = interventionService.createIntervention(dto);
        return ResponseEntity.status(201).body(savedDTO);
    }
}
