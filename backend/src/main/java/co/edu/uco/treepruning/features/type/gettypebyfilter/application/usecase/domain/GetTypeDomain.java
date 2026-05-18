package co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain;

import java.util.UUID;

public final class GetTypeDomain {
    private UUID id;
    private String name;

    public GetTypeDomain(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public UUID getId() { return id; }
    public String getName() { return name; }

    private void setId(final UUID id) { this.id = id; }
    private void setName(final String name) { this.name = name; }
}
