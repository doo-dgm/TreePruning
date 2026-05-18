package co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain;

import java.util.UUID;

public final class GetSectorDomain {
    private UUID id;
    private String name;

    public GetSectorDomain(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public UUID getId() { return id; }
    public String getName() { return name; }

    private void setId(final UUID id) { this.id = id; }
    private void setName(final String name) { this.name = name; }
}
