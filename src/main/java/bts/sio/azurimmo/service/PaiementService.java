package bts.sio.azurimmo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import bts.sio.azurimmo.model.Paiement;
import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.model.dto.PaiementDTO;
import bts.sio.azurimmo.model.mapper.PaiementMapper;
import bts.sio.azurimmo.repository.PaiementRepository;
import bts.sio.azurimmo.repository.ContratRepository;

@Service
public class PaiementService {

    private final PaiementRepository paiementRepository;
    private final ContratRepository contratRepository;

    public PaiementService(PaiementRepository paiementRepository, ContratRepository contratRepository) {
        this.paiementRepository = paiementRepository;
        this.contratRepository = contratRepository;
    }

    public List<PaiementDTO> getAllPaiements() {
        return paiementRepository.findAll().stream()
                .map(PaiementMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PaiementDTO createPaiement(PaiementDTO paiementDTO) {
        Paiement paiement = PaiementMapper.toEntity(paiementDTO);

        // On vérifie que le contrat renseigné existe bien en base
        if (paiementDTO.getContratId() != null) {
            Contrat contrat = contratRepository.findById(paiementDTO.getContratId())
                .orElseThrow(() -> new RuntimeException("Contrat introuvable !"));
            
            paiement.setContrat(contrat);
        }

        Paiement savedPaiement = paiementRepository.save(paiement);
        return PaiementMapper.toDTO(savedPaiement);
    }
}
