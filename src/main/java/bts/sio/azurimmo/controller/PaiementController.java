package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.dto.PaiementDTO;
import bts.sio.azurimmo.service.PaiementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/paiements")
@Tag(name = "Paiements", description = "Gestion de la comptabilité et des loyers")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @GetMapping("/")
    @Operation(summary = "Récupère tous les paiements")
    public List<PaiementDTO> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @PostMapping("/")
    @Operation(summary = "Enregistre un nouveau paiement (lié à un contrat)")
    public ResponseEntity<PaiementDTO> createPaiement(@RequestBody PaiementDTO dto) {
        PaiementDTO savedDTO = paiementService.createPaiement(dto);
        return ResponseEntity.status(201).body(savedDTO);
    }
}