package bts.sio.azurimmo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import bts.sio.azurimmo.model.Locataire;
import bts.sio.azurimmo.model.dto.LocataireDTO;
import bts.sio.azurimmo.model.mapper.LocataireMapper;
import bts.sio.azurimmo.repository.LocataireRepository;


@Service 
public class LocataireService {

    private final LocataireRepository locataireRepository;

    public LocataireService(LocataireRepository locataireRepository) {
        this.locataireRepository = locataireRepository;
    }

    public List<LocataireDTO> getAllLocataires() {
        return locataireRepository.findAll().stream()
                .map(LocataireMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LocataireDTO createLocataire(LocataireDTO locataireDTO) {
        Locataire locataire = LocataireMapper.toEntity(locataireDTO);
        Locataire savedLocataire = locataireRepository.save(locataire);
        return LocataireMapper.toDTO(savedLocataire);
    }
}