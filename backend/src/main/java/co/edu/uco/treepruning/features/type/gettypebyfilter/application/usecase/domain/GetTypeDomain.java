package co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain;

import java.util.UUID;

public final class GetTypeDomain {
    private final UUID id;
    private final String name;

    public GetTypeDomain(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
}
