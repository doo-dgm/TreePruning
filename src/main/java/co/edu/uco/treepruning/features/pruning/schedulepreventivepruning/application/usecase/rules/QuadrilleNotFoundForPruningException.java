package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.usecase.rules;

import java.util.UUID;

public final class QuadrilleNotFoundForPruningException 
        extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String userMessage;

    private QuadrilleNotFoundForPruningException(String userMessage,
            String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static QuadrilleNotFoundForPruningException create(
            UUID quadrilleId) {
        return new QuadrilleNotFoundForPruningException(
            "No se encontró la cuadrilla seleccionada para programar la poda.",
            "SchedulePreventivePruning: quadrille not found with id=" + quadrilleId
        );
    }

    public String getUserMessage() {
        return userMessage;
    }
}