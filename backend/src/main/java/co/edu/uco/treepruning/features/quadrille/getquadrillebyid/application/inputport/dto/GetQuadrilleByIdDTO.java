package co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetQuadrilleByIdDTO {

    private UUID id;
    private String quadrilleName;
    private UUID manager;

    public GetQuadrilleByIdDTO(UUID id, String quadrilleName, UUID manager) {
        setId(id);
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public UUID getId() {
        return id;
    }

    public String getQuadrilleName() {
        return quadrilleName;
    }

    public UUID getManager() {
        return manager;
    }

    private void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    private void setQuadrilleName(String quadrilleName) {
        this.quadrilleName = TextHelper.getDefaultWithTrim(quadrilleName);
    }

    private void setManager(UUID manager) {
        this.manager = UUIDHelper.getUUIDHelper().getDefault(manager);
    }
}
