package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto;

import java.util.UUID;

public final class GetStatusFilterDTO {
    private final UUID id;
    private final String name;

    public GetStatusFilterDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
}
