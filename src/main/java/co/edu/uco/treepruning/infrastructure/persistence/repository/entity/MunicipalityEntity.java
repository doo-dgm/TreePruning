package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

public class MunicipalityEntity {
    private UUID id;
    private String name;
    private StateEntity state;
    
	public MunicipalityEntity(UUID id, String name, StateEntity state) {
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
