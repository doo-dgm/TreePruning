package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetQuadrilleDTO {
    private UUID id;
    private String quadrilleName;
    private UUID manager;
    private String managerName;

    public GetQuadrilleDTO(UUID id, String quadrilleName, UUID manager, String managerName) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
        this.quadrilleName = TextHelper.getDefaultWithTrim(quadrilleName);
        this.manager = UUIDHelper.getUUIDHelper().getDefault(manager);
        this.managerName = TextHelper.getDefaultWithTrim(managerName);
    }

    public UUID getId() { return id; }
    public String getQuadrilleName() { return quadrilleName; }
    public UUID getManager() { return manager; }
    public String getManagerName() { return managerName; }
}
