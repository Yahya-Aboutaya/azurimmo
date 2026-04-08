package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.dto.AssocieDTO;
import bts.sio.azurimmo.service.AssocieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/associes")
@Tag(name = "Associés", description = "Gestion des associés (gestionnaires)")
public class AssocieController {

    @Autowired
    private AssocieService associeService;

    @GetMapping("/")
    @Operation(summary = "Récupère tous les associés")
    public List<AssocieDTO> getAllAssocies() {
        return associeService.getAllAssocies(); 
    }

    @PostMapping("/")
    @Operation(summary = "Crée un nouvel associé")
    public ResponseEntity<AssocieDTO> createAssocie(@RequestBody AssocieDTO dto) {
        AssocieDTO savedDTO = associeService.createAssocie(dto);
        return ResponseEntity.status(201).body(savedDTO);
    }
}