package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto;

import java.util.UUID;

public final class GetQuadrilleFilterDTO {
    private final UUID id;
    private final String quadrilleName;
    private final UUID managerId;

    public GetQuadrilleFilterDTO(UUID id, String quadrilleName, UUID managerId) {
        this.id = id;
        this.quadrilleName = quadrilleName;
        this.managerId = managerId;
    }

    public UUID getId() { return id; }
    public String getQuadrilleName() { return quadrilleName; }
    public UUID getManagerId() { return managerId; }
}
