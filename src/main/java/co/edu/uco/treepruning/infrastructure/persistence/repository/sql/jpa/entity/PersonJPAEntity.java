package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.DocumentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "")
public class PersonJPAEntity {
	@Id
	@Column(name = "")
	private UUID id;
	
	@Column(name = "")
    private String firstName;
	
	@Column(name = "")
    private String secondName;
	
	@Column(name = "")
    private String firstLastName;
	
	@Column(name = "")
    private String secondLastName;
	
	@Column(name = "")
    private DocumentEntity document;
	
	@Column(name = "")
    private String documentNumber;
	
	@Column(name = "")
    private LocalDate birthDate;
	
	@Column(name = "")
    private String address;
	
	@Column(name = "")
    private String email;
	
	@Column(name = "")
    private boolean emailConfirmed;
	
	@Column(name = "")
    private String phone;
	
	@Column(name = "")
    private boolean phoneConfirmed;
	
	@Column(name = "")
    private int age;
    
    
    
    
	public PersonJPAEntity(UUID id, String firstName, String secondName, String firstLastName, String secondLastName,
			DocumentEntity document, String documentNumber, LocalDate birthDate, String address, String email,
			boolean emailConfirmed, String phone, boolean phoneConfirmed, int age) {
		super();
		setId(id);
		setFirstName(firstName);
		setSecondName(secondName);
		setFirstLastName(firstLastName);
		setSecondLastName(secondLastName);
		setDocument(document);
		setDocumentNumber(documentNumber);
		setBirthDate(birthDate);
		setAddress(address);
		setEmail(email);
		setEmailConfirmed(emailConfirmed);
		setPhone(phone);
		setPhoneConfirmed(phoneConfirmed);
		setAge(age);
	}
	
	public UUID getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public String getFirstLastName() {
		return firstLastName;
	}
	public String getSecondLastName() {
		return secondLastName;
	}
	public DocumentEntity getDocument() {
		return document;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}
	public String getPhone() {
		return phone;
	}
	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}
	public int getAge() {
		return age;
	}
	
	private void setId(UUID id) {
		this.id = id;
	}
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	private void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}
	private void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	private void setDocument(DocumentEntity document) {
		this.document = document;
	}
	private void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	private void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	private void setAddress(String address) {
		this.address = address;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	private void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	private void setPhone(String phone) {
		this.phone = phone;
	}
	private void setPhoneConfirmed(boolean phoneConfirmed) {
		this.phoneConfirmed = phoneConfirmed;
	}
	private void setAge(int age) {
		this.age = age;
	}
}
