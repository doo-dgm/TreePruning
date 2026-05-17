package co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase.domain;

import java.util.UUID;

public final class GetQuadrilleByIdDomain {

    private UUID id;
    private String quadrilleName;
    private UUID manager;

    public GetQuadrilleByIdDomain(UUID id, String quadrilleName, UUID manager) {
        setId(id);
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public UUID getId() {
        return id;
    }

    public String getQuadrilleName() {
        return quadrilleName;
    }

    public UUID getManager() {
        return manager;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    private void setQuadrilleName(String quadrilleName) {
        this.quadrilleName = quadrilleName;
    }

    private void setManager(UUID manager) {
        this.manager = manager;
    }
}
