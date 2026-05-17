package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto;

import java.time.LocalDate;
import java.util.UUID;

public final class GetPruningFilterDTO {
    private final UUID id;
    private final UUID statusId;
    private final UUID treeId;
    private final UUID quadrilleId;
    private final UUID typeId;
    private final LocalDate plannedDate;

    public GetPruningFilterDTO(UUID id, UUID statusId, UUID treeId,
            UUID quadrilleId, UUID typeId, LocalDate plannedDate) {
        this.id = id;
        this.statusId = statusId;
        this.treeId = treeId;
        this.quadrilleId = quadrilleId;
        this.typeId = typeId;
        this.plannedDate = plannedDate;
    }

    public UUID getId() { return id; }
    public UUID getStatusId() { return statusId; }
    public UUID getTreeId() { return treeId; }
    public UUID getQuadrilleId() { return quadrilleId; }
    public UUID getTypeId() { return typeId; }
    public LocalDate getPlannedDate() { return plannedDate; }
}
