package co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.dto;

import java.time.LocalDate;
import java.util.UUID;

public final class SubmitPQRDTO {

    private final LocalDate date;
    private final UUID status;
    private final UUID risk;
    private final UUID sector;
    private final UUID person;
    private final String photographicRecordPath;

    public SubmitPQRDTO(LocalDate date, UUID status, UUID sector,
            UUID risk, UUID person, String photographicRecordPath) {
        this.date = date;
        this.status = status;
        this.sector = sector;
        this.risk = risk;
        this.person = person;
        this.photographicRecordPath = photographicRecordPath;
    }

    public LocalDate getDate() {
        return date;
    }

    public UUID getStatus() {
        return status;
    }

    public UUID getRisk() {
        return risk;
    }

    public UUID getSector() {
        return sector;
    }

    public UUID getPerson() {
        return person;
    }

    public String getPhotographicRecordPath() {
        return photographicRecordPath;
    }
}
