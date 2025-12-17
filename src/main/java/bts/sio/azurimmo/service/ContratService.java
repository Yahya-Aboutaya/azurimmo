package bts.sio.azurimmo.service;

import java.util.List;
import java.util.stream.Collectors; 

import org.springframework.stereotype.Service;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.model.dto.ContratDTO;
import bts.sio.azurimmo.model.mapper.ContratMapper;
import bts.sio.azurimmo.repository.AppartementRepository;
import bts.sio.azurimmo.repository.ContratRepository;
import lombok.Data;

@Data
@Service
public class ContratService {

    private final ContratRepository repository;
    private final AppartementRepository appartementRepository;
     
    public ContratService(ContratRepository repository, AppartementRepository appartementRepository) {
        this.repository = repository;
        this.appartementRepository = appartementRepository; 
    }
    
    public ContratDTO createContrat(ContratDTO dto) {
        
        Contrat c = ContratMapper.toEntity(dto);
        
        if (dto.getAppartementId() != null) {
            Appartement appart = appartementRepository.findById(dto.getAppartementId())
                    .orElse(null); 
            
            c.setAppartement(appart);
        }
        
        Contrat saved = repository.save(c);
        
        return ContratMapper.toDTO(saved);
    }
    
    public List<ContratDTO> getTousLesContrats() {
        return repository.findAll() 
                .stream()           
                .map(ContratMapper::toDTO) 
                .toList(); 
    }

}