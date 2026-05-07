package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.RiskEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pqr")
public class PQRJPAEntity {
	@Id
	@Column(name = "")
	private UUID id;
	
	@Column(name = "")
    private LocalDate date;
	
	@Column(name = "")
    private StatusEntity status;
	
	@Column(name = "")
    private RiskEntity risk;
	
	@Column(name = "")
    private SectorEntity sector;
	
	@Column(name = "")
    private PersonEntity person;
	
	@Column(name = "")
    private String photographicRecordPath;
    
    
	public PQRJPAEntity(UUID id, LocalDate date, StatusEntity status, RiskEntity risk, SectorEntity sector,
			PersonEntity person, String photographicRecordPath) {
		super();
		setId(id);
		setDate(date);
		setStatus(status);
		setRisk(risk);
		setSector(sector);
		setPerson(person);
		setPhotographicRecordPath(photographicRecordPath);
	}
	
	public UUID getId() {
		return id;
	}
	public LocalDate getDate() {
		return date;
	}
	public StatusEntity getStatus() {
		return status;
	}
	public RiskEntity getRisk() {
		return risk;
	}
	public SectorEntity getSector() {
		return sector;
	}
	public PersonEntity getPerson() {
		return person;
	}
	public String getPhotographicRecordPath() {
		return photographicRecordPath;
	}
	
	private void setId(UUID id) {
		this.id = id;
	}
	private void setDate(LocalDate date) {
		this.date = date;
	}
	private void setStatus(StatusEntity status) {
		this.status = status;
	}
	private void setRisk(RiskEntity risk) {
		this.risk = risk;
	}
	private void setSector(SectorEntity sector) {
		this.sector = sector;
	}
	private void setPerson(PersonEntity person) {
		this.person = person;
	}
	private void setPhotographicRecordPath(String photographicRecordPath) {
		this.photographicRecordPath = photographicRecordPath;
	}
    
}
