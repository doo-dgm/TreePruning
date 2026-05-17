package co.edu.uco.treepruning.features.type.gettypebyid.application.usecase.domain;

import java.util.UUID;

public final class GetTypeByIdDomain {

    private UUID id;
    private String name;

    public GetTypeByIdDomain(UUID id, String name) {
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
