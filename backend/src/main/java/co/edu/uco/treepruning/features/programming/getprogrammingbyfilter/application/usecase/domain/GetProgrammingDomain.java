package co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain;

import java.time.LocalDate;
import java.util.UUID;

public final class GetProgrammingDomain {
    private UUID id;
    private LocalDate initialDate;
    private int frequencyMonths;
    private int amount;

    public GetProgrammingDomain(UUID id, LocalDate initialDate, int frequencyMonths, int amount) {
        setId(id);
        setInitialDate(initialDate);
        setFrequencyMonths(frequencyMonths);
        setAmount(amount);
    }

    public UUID getId() { return id; }
    public LocalDate getInitialDate() { return initialDate; }
    public int getFrequencyMonths() { return frequencyMonths; }
    public int getAmount() { return amount; }

    private void setId(final UUID id) { this.id = id; }
    private void setInitialDate(final LocalDate initialDate) { this.initialDate = initialDate; }
    private void setFrequencyMonths(final int frequencyMonths) { this.frequencyMonths = frequencyMonths; }
    private void setAmount(final int amount) { this.amount = amount; }
}
