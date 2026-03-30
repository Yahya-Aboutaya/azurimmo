package bts.sio.azurimmo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.dto.InterventionDTO;
import bts.sio.azurimmo.model.mapper.InterventionMapper;
import bts.sio.azurimmo.repository.InterventionRepository;
import bts.sio.azurimmo.repository.AppartementRepository;

@Service
public class InterventionService {

  
    private final InterventionRepository interventionRepository;
    private final AppartementRepository appartementRepository;

    public InterventionService(InterventionRepository interventionRepository, AppartementRepository appartementRepository) {
        this.interventionRepository = interventionRepository;
        this.appartementRepository = appartementRepository;
    }

    public List<InterventionDTO> getAllInterventions() {
        return interventionRepository.findAll().stream()
                .map(InterventionMapper::toDTO)
                .collect(Collectors.toList());
    }
    
 // trouver toutes les interventions d'un appartement précis
    public List<InterventionDTO> getInterventionsByAppartementId(Long appartementId) {
        return interventionRepository.findByAppartement_Id(appartementId).stream()
                .map(InterventionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public InterventionDTO createIntervention(InterventionDTO interventionDTO) {
        Intervention intervention = InterventionMapper.toEntity(interventionDTO);
        
        if (interventionDTO.getAppartementId() != null) {
            Appartement appartement = appartementRepository.findById(interventionDTO.getAppartementId())
                .orElseThrow(() -> new RuntimeException("Appartement non trouvé !")); // Si l'ID n'existe pas, on bloque
            
            intervention.setAppartement(appartement);
        }

        // 3. On sauvegarde le tout
        Intervention savedIntervention = interventionRepository.save(intervention);
        return InterventionMapper.toDTO(savedIntervention);
    }
}