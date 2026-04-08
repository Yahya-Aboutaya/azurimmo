package bts.sio.azurimmo.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterventionDTO {
	private Long id;
	private LocalDate date;
	private String sujet;
	private Double cout;
	private String etat;
	private Long appartementId;
}
