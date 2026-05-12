package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.usecase.rules;

import java.util.UUID;

public final class PruningTypeNotFoundForPruningException 
        extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String userMessage;

    private PruningTypeNotFoundForPruningException(String userMessage,
            String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static PruningTypeNotFoundForPruningException create(
            UUID pruningTypeId) {
        return new PruningTypeNotFoundForPruningException(
            "No se encontró el tipo de poda seleccionado.",
            "SchedulePreventivePruning: pruningType not found with id=" + pruningTypeId
        );
    }

    public String getUserMessage() {
        return userMessage;
    }
}
