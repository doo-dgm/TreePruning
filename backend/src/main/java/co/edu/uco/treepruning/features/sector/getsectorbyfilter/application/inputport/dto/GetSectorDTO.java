package co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetSectorDTO {
    private UUID id;
    private String name;

    public GetSectorDTO(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public UUID getId() { return id; }
    public String getName() { return name; }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
}
