package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

public class DocumentEntity {

    private UUID id;
    private String name;
    private String code;
    
    
	public DocumentEntity(UUID id, String name, String code) {
		super();
		setId(id);
		setName(name);
		setCode(code);
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	
	private void setId(UUID id) {
		this.id = id;
	}
	private void setName(String name) {
		this.name = name;
	}
	private void setCode(String code) {
		this.code = code;
	}
    
    
}
