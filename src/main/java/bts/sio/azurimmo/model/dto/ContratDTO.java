package bts.sio.azurimmo.model.dto;

import java.sql.Date;

import lombok.Data;
@Data
public class ContratDTO {
	private Integer numeroBail;
	private Date dateDebut;
	private Date dateFin;
	private Double loyersanscharge;
	private Double montantcharge;
	private Long appartementId;
}
