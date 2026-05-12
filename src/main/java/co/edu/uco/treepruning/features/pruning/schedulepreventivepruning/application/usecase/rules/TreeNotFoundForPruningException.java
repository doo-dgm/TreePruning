package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.usecase.rules;

import java.util.UUID;

public final class TreeNotFoundForPruningException 
        extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String userMessage;

    private TreeNotFoundForPruningException(String userMessage,
            String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static TreeNotFoundForPruningException create(UUID treeId) {
        return new TreeNotFoundForPruningException(
            "No se encontró el árbol seleccionado para " +
            "programar la poda.",
            "SchedulePreventivePruning: tree not found " +
            "with id=" + treeId
        );
    }

    public String getUserMessage() {
        return userMessage;
    }
}