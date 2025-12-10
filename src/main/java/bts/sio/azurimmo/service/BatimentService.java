package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.model.mapper.BatimentMapper;
import bts.sio.azurimmo.repository.BatimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BatimentService {

    @Autowired
    private BatimentRepository batimentRepository;

    public Batiment saveBatiment(Batiment batiment) {
        return batimentRepository.save(batiment);
    }

    public Batiment getBatimentById(Long id) {
        Optional<Batiment> batiment = batimentRepository.findById(id);
        return batiment.orElse(null);
    }

    public List<Batiment> getBatimentsByVille(String ville) {
        return batimentRepository.findByVille(ville);
    }

    public Optional<BatimentDTO> getBatimentDTO(Long id) {
    	  return batimentRepository.findById(id)
                  .map(BatimentMapper::toDTO);
    }
    
    public List<BatimentDTO> getBatimentsDTO() {
        return batimentRepository.findAll()
                                 .stream()
                                 .map(BatimentMapper::toDTO)
                                 .collect(Collectors.toList());
    }
    
    public BatimentDTO saveBatimentDTO(BatimentDTO dto) {
        Batiment entity = BatimentMapper.toEntity(dto);
        Batiment saved = batimentRepository.save(entity);
        return BatimentMapper.toDTO(saved);
    }
    
}