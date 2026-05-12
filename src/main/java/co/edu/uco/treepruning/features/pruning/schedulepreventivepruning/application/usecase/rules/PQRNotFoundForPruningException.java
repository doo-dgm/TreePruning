package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.usecase.rules;

import java.util.UUID;

public final class PQRNotFoundForPruningException 
        extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String userMessage;

    private PQRNotFoundForPruningException(String userMessage,
            String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static PQRNotFoundForPruningException create(UUID pqrId) {
        return new PQRNotFoundForPruningException(
            "No se encontró la PQR asociada a la poda.",
            "SchedulePreventivePruning: pqr not found with id=" + pqrId
        );
    }

    public String getUserMessage() {
        return userMessage;
    }
}
