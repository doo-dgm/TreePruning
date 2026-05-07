package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.time.LocalDate;
import java.util.UUID;

public class PQREntity {
    private UUID id;
    private LocalDate date;
    private StatusEntity status;
    private RiskEntity risk;
    private SectorEntity sector;
    private PersonEntity person;
    private String photographicRecordPath;
    
    
	public PQREntity(UUID id, LocalDate date, StatusEntity status, RiskEntity risk, SectorEntity sector,
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
