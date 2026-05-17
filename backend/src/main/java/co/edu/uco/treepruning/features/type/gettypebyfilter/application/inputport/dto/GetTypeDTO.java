package co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetTypeDTO {
    private UUID id;
    private String name;

    public GetTypeDTO(UUID id, String name) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
}
