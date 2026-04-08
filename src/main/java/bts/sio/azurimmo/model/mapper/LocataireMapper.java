package bts.sio.azurimmo.model.mapper;

import org.springframework.beans.BeanUtils;
import bts.sio.azurimmo.model.Locataire;
import bts.sio.azurimmo.model.dto.LocataireDTO;

public class LocataireMapper {

    public static LocataireDTO toDTO(Locataire entity) {
        LocataireDTO dto = new LocataireDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    // Sens 2 : Postman -> Base de données (On reçoit le colis et on l'ouvre)
    public static Locataire toEntity(LocataireDTO dto) {
        Locataire entity = new Locataire();
        // Idem dans l'autre sens
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}