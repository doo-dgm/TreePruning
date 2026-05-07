package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "")
public class DocumentJPAEntity {

	@Id
	@Column(name = "")
    private UUID id;
	
	@Column(name = "")
    private String name;
	
	@Column(name = "")
    private String code;
    
    
	public DocumentJPAEntity(UUID id, String name, String code) {
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
