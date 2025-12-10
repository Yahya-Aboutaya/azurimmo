package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.service.BatimentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/batiments")
@Tag(name = "Batiments", description = "Gestion des batiments")
public class BatimentController {

    @Autowired
    private BatimentService batimentService;

    @PostMapping("/")
    public ResponseEntity<BatimentDTO> createBatiment(@RequestBody BatimentDTO dto) {
        BatimentDTO savedDTO = batimentService.saveBatimentDTO(dto);
        return ResponseEntity.status(201).body(savedDTO); // 201 Created
    }

    @GetMapping("/{id}")
    public Batiment getBatimentById(@PathVariable Long id) {
        return batimentService.getBatimentById(id);
    }

    
    @GetMapping("/ville/{ville}")
    public List<Batiment> getBatimentsByVille(@PathVariable String ville) {
        return batimentService.getBatimentsByVille(ville);
    }
    
    //@GetMapping("/{batimentId}")
    //public Optional <BatimentDTO> getBatimentDTO(@PathVariable long batimentId) {
      //  return batimentService.getBatimentDTO(batimentId);
    //}
    
    
    @GetMapping("/re/{batimentId}")
    public ResponseEntity<BatimentDTO> getBatimentReDTO(@PathVariable long batimentId) {
            return batimentService.getBatimentDTO(batimentId)
                                  .map(ResponseEntity::ok)   // batiment trouvé → 200
                                  .orElse(ResponseEntity.notFound().build()); // pas trouvé → 404
    }
    
    @GetMapping("/")
    @Operation(summary = "Récupère tous les batiments")
    public List<BatimentDTO> getAllBatiments() {
        return batimentService.getBatimentsDTO(); 
    }
}