package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain;

import java.util.UUID;

public final class GetStatusDomain {
    private final UUID id;
    private final String name;

    public GetStatusDomain(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
}
