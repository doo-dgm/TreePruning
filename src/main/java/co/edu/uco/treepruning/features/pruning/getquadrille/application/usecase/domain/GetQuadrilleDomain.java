package co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.domain;

import java.util.UUID;

public final class GetQuadrilleDomain {

    private UUID id;
    private String quadrilleName;
    private UUID manager;

    public GetQuadrilleDomain(UUID id, String quadrilleName,
            UUID manager) {
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
