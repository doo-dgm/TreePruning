package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.CountryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "")
public class StateJPAEntity {
	@Id
	@Column(name = "")
	private UUID id;
	
	@Column(name = "")
    private String name;
	
	@Column(name = "")
    private CountryEntity country;
    
    
	public StateJPAEntity(UUID id, String name, CountryEntity country) {
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
