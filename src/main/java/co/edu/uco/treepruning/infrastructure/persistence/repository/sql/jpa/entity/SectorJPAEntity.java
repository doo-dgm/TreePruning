package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.MunicipalityEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "")
public class SectorJPAEntity {
	@Id
	@Column(name = "")
	private UUID id;
	
	@Column(name = "")
    private String name;
	
	@Column(name = "")
    private MunicipalityEntity municipality;
    
    
	public SectorJPAEntity(UUID id, String name, MunicipalityEntity municipality) {
		super();
		setId(id);
		setName(name);
		setMunicipality(municipality);
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public MunicipalityEntity getMunicipality() {
		return municipality;
	}
	
	private void setId(UUID id) {
		this.id = id;
	}
	private void setName(String name) {
		this.name = name;
	}
	private void setMunicipality(MunicipalityEntity municipality) {
		this.municipality = municipality;
	}
}
