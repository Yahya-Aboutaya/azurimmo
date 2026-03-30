package bts.sio.azurimmo.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssocieDTO {
	private Long id;
    private String nom;
    private String prenom;
    private String tel;
    private String mail;
    private List<Long> batimentIds;
}
