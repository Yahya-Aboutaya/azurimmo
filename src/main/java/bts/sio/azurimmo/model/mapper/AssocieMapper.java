package bts.sio.azurimmo.model.mapper;

import org.springframework.beans.BeanUtils;
import bts.sio.azurimmo.model.Associe;
import bts.sio.azurimmo.model.dto.AssocieDTO;

public class AssocieMapper {

    public static AssocieDTO toDTO(Associe entity) {
        AssocieDTO dto = new AssocieDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static Associe toEntity(AssocieDTO dto) {
        Associe entity = new Associe();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
