package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.usecase.rules;

import java.util.UUID;

public final class StatusNotFoundForPruningException 
        extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String userMessage;

    private StatusNotFoundForPruningException(String userMessage,
            String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static StatusNotFoundForPruningException create(
            UUID statusId) {
        return new StatusNotFoundForPruningException(
            "No se encontró el estado seleccionado para la poda.",
            "SchedulePreventivePruning: status not found with id=" + statusId
        );
    }

    public String getUserMessage() {
        return userMessage;
    }
}
