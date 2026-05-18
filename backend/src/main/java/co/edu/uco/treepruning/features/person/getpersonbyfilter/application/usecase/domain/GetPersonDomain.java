package co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain;

import java.time.LocalDate;
import java.util.UUID;

public final class GetPersonDomain {
    private UUID id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String documentNumber;
    private LocalDate birthDate;
    private String address;
    private String email;
    private String phone;
    private int age;

    public GetPersonDomain(UUID id, String firstName, String secondName,
            String firstLastName, String secondLastName, String documentNumber,
            LocalDate birthDate, String address, String email, String phone, int age) {
        setId(id);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstLastName(firstLastName);
        setSecondLastName(secondLastName);
        setDocumentNumber(documentNumber);
        setBirthDate(birthDate);
        setAddress(address);
        setEmail(email);
        setPhone(phone);
        setAge(age);
    }

    public UUID getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getSecondName() { return secondName; }
    public String getFirstLastName() { return firstLastName; }
    public String getSecondLastName() { return secondLastName; }
    public String getDocumentNumber() { return documentNumber; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public int getAge() { return age; }

    private void setId(final UUID id) { this.id = id; }
    private void setFirstName(final String firstName) { this.firstName = firstName; }
    private void setSecondName(final String secondName) { this.secondName = secondName; }
    private void setFirstLastName(final String firstLastName) { this.firstLastName = firstLastName; }
    private void setSecondLastName(final String secondLastName) { this.secondLastName = secondLastName; }
    private void setDocumentNumber(final String documentNumber) { this.documentNumber = documentNumber; }
    private void setBirthDate(final LocalDate birthDate) { this.birthDate = birthDate; }
    private void setAddress(final String address) { this.address = address; }
    private void setEmail(final String email) { this.email = email; }
    private void setPhone(final String phone) { this.phone = phone; }
    private void setAge(final int age) { this.age = age; }
}
