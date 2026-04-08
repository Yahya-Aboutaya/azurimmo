package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.dto.LocataireDTO;
import bts.sio.azurimmo.service.LocataireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/locataires")
@Tag(name = "Locataires", description = "Gestion des locataires de l'agence")
public class LocataireController {

    @Autowired
    private LocataireService locataireService;

    @GetMapping("/")
    @Operation(summary = "Récupère tous les locataires")
    public List<LocataireDTO> getAllLocataires() {
        return locataireService.getAllLocataires();
    }

    @PostMapping("/")
    @Operation(summary = "Crée un nouveau locataire")
    public ResponseEntity<LocataireDTO> createLocataire(@RequestBody LocataireDTO dto) {
        LocataireDTO savedDTO = locataireService.createLocataire(dto);
        return ResponseEntity.status(201).body(savedDTO);
    }
}