package co.edu.uco.treepruning.features.pruning.getstatus.application.usecase.domain;

import java.util.UUID;

public final class GetStatusDomain {

    private UUID id;
    private String name;

    public GetStatusDomain(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public UUID getId() {
    	return id;
    	}
    public String getName() { 
    	return name;
    	}

    private void setId(UUID id) { 
    	this.id = id;
    	}
    private void setName(String name) {
    	this.name = name;
    	}
}