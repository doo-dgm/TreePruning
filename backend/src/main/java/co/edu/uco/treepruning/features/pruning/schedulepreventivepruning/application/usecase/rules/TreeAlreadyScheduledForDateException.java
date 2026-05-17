package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import java.time.LocalDate;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class TreeAlreadyScheduledForDateException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private TreeAlreadyScheduledForDateException(String userMessage,
            String technicalMessage) {
        super(userMessage, technicalMessage, 409);
    }

    public static TreeAlreadyScheduledForDateException create(UUID treeId,
            LocalDate plannedDate) {
        return new TreeAlreadyScheduledForDateException(
            "El árbol ya tiene una poda programada para la fecha indicada. " +
            "No es posible registrar dos podas para el mismo árbol en el mismo día.",
            "SchedulePreventivePruning: tree " + treeId +
            " already has a pruning scheduled for " + plannedDate
        );
    }
}
