package bts.sio.azurimmo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import bts.sio.azurimmo.model.Associe;
import bts.sio.azurimmo.model.dto.AssocieDTO;
import bts.sio.azurimmo.model.mapper.AssocieMapper;
import bts.sio.azurimmo.repository.AssocieRepository;


@Service
public class AssocieService {

    private final AssocieRepository locataireRepository;

    // Spring injecte le Repository automatiquement ici
    public AssocieService(AssocieRepository locataireRepository) {
        this.locataireRepository = locataireRepository;
    }

    public List<AssocieDTO> getAllAssocies() {
        return locataireRepository.findAll().stream()
                .map(AssocieMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AssocieDTO createAssocie(AssocieDTO locataireDTO) {
        Associe associe = AssocieMapper.toEntity(locataireDTO);
        Associe savedAssocie = locataireRepository.save(associe);
        return AssocieMapper.toDTO(savedAssocie);
    }
}
