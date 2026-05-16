package co.edu.uco.treepruning.features.pruning.gettype.application.usecase.domain;

import java.util.UUID;

public final class GetTypeDomain {

    private UUID id;
    private String name;

    public GetTypeDomain(UUID id, String name) {
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
