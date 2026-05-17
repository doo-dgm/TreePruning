package co.edu.uco.treepruning.features.type.gettypebyid.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetTypeByIdDTO {

    private UUID id;
    private String name;

    public GetTypeByIdDTO(UUID id, String name) {
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
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    private void setName(String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
}
