package co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto;

import java.util.UUID;

public final class GetTypeFilterDTO {
    private final UUID id;
    private final String name;

    public GetTypeFilterDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
}
