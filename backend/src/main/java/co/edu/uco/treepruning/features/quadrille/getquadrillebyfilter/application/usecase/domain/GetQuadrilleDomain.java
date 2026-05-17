package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain;

import java.util.UUID;

public final class GetQuadrilleDomain {
    private final UUID id;
    private final String quadrilleName;
    private final UUID manager;
    private final String managerName;

    public GetQuadrilleDomain(UUID id, String quadrilleName, UUID manager, String managerName) {
        this.id = id;
        this.quadrilleName = quadrilleName;
        this.manager = manager;
        this.managerName = managerName;
    }

    public UUID getId() { return id; }
    public String getQuadrilleName() { return quadrilleName; }
    public UUID getManager() { return manager; }
    public String getManagerName() { return managerName; }
}
