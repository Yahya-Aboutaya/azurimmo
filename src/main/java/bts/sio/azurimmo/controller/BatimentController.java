package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.service.BatimentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/batiments")
public class BatimentController {

    @Autowired
    private BatimentService batimentService;

    @PostMapping("/")
    public Batiment createBatiment(@RequestBody Batiment batiment) {
        return batimentService.saveBatiment(batiment);
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
}