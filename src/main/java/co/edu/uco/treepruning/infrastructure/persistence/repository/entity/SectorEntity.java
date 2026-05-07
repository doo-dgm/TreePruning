package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

public class SectorEntity {
    private UUID id;
    private String name;
    private MunicipalityEntity municipality;
    
    
	public SectorEntity(UUID id, String name, MunicipalityEntity municipality) {
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
