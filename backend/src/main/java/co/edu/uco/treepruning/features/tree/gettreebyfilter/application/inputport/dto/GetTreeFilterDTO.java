package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto;

import java.util.UUID;

public final class GetTreeFilterDTO {
    private final UUID id;
    private final UUID familyId;
    private final UUID sectorId;

    public GetTreeFilterDTO(UUID id, UUID familyId, UUID sectorId) {
        this.id = id;
        this.familyId = familyId;
        this.sectorId = sectorId;
    }

    public UUID getId() { return id; }
    public UUID getFamilyId() { return familyId; }
    public UUID getSectorId() { return sectorId; }
}
