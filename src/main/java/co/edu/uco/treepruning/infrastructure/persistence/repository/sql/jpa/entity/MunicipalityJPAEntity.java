package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StateEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "")
public class MunicipalityJPAEntity {
	@Id
	@Column(name = "")
	private UUID id;
	
	@Column(name = "")
    private String name;
	
	@Column(name = "")
    private StateEntity state;
    
	public MunicipalityJPAEntity(UUID id, String name, StateEntity state) {
		super();
		setId(id);
		setName(name);
		setState(state);
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public StateEntity getState() {
		return state;
	}
	
	private void setId(UUID id) {
		this.id = id;
	}
	private void setName(String name) {
		this.name = name;
	}
	private void setState(StateEntity state) {
		this.state = state;
	}
}
