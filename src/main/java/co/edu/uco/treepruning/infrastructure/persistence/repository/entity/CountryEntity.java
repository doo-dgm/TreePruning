package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

public class CountryEntity {
    private UUID id;
    private String name;
    
    
	public CountryEntity(UUID id, String name) {
		super();
		setId(id);
		setName(name);
	}
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	private void setId(UUID id) {
		this.id = id;
	}
	private void setName(String name) {
		this.name = name;
	}
    
    
}	
