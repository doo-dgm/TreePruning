package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetStatusDTO {
    private UUID id;
    private String name;

    public GetStatusDTO(UUID id, String name) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
}
