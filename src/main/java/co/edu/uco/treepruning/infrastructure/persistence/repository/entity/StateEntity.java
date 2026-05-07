package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

public class StateEntity {
    private UUID id;
    private String name;
    private CountryEntity country;
    
    
	public StateEntity(UUID id, String name, CountryEntity country) {
		super();
		setId(id);
		setName(name);
		setCountry(country);
	}
	
	private UUID getId() {
		return id;
	}
	private String getName() {
		return name;
	}
	private CountryEntity getCountry() {
		return country;
	}
	
	private void setId(UUID id) {
		this.id = id;
	}
	private void setName(String name) {
		this.name = name;
	}
	private void setCountry(CountryEntity country) {
		this.country = country;
	}
    
    
}
