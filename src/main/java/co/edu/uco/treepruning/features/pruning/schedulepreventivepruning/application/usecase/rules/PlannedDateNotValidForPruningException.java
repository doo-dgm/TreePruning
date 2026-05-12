package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.usecase.rules;

public final class PlannedDateNotValidForPruningException 
        extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String userMessage;

    private PlannedDateNotValidForPruningException(String userMessage,
            String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static PlannedDateNotValidForPruningException 
            createDateInPast() {
        return new PlannedDateNotValidForPruningException(
            "La fecha programada de la poda no puede ser una fecha pasada.",
            "SchedulePreventivePruning: plannedDate is in the past"
        );
    }

    public static PlannedDateNotValidForPruningException 
            createDateIsNull() {
        return new PlannedDateNotValidForPruningException(
            "La fecha programada de la poda es obligatoria.",
            "SchedulePreventivePruning: plannedDate is null"
        );
    }

    public String getUserMessage() {
        return userMessage;
    }
}