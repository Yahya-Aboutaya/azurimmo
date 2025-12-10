package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.service.AppartementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/appartements")
@Tag(name = "Appartements", description = "Gestion des appartements")
public class AppartementController {
	
   @Autowired
    private AppartementService appartementService;
   
   @GetMapping("/")
   @Operation(summary = "Récupère tous les appartements")
   public List<AppartementDTO> getAllAppartements() {
       return appartementService.getAppartementsDTO(); 
   }

   @PostMapping("/")
   public ResponseEntity<AppartementDTO> createAppartement(@RequestBody AppartementDTO dto) {
    
	   AppartementDTO savedDTO = appartementService.saveAppartementDTO(dto);
    
	   return ResponseEntity.status(201).body(savedDTO);
   }
    
    @GetMapping("/ville/{ville}")
    public List<Appartement> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }
    
    @GetMapping("/batiment/{batimentId}")
    public List<Appartement> getAppartementsParBatiment(@PathVariable long batimentId) {
            return appartementService.getAppartementsParBatiment(batimentId);
     }
    
    @GetMapping("/surface/{surface}")
    public List<Appartement> getAppartementsParSurface(@PathVariable double surface) {
        return appartementService.getAppartementsBySurfaceGreatherThan(surface);
    }

}