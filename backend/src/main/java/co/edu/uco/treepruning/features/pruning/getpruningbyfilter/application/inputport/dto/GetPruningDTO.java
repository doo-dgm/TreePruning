package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto;

import java.time.LocalDate;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;

public final class GetPruningDTO {
    private UUID id;
    private GetStatusDTO status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private GetTreeDTO tree;
    private GetQuadrilleDTO quadrille;
    private GetTypeDTO type;
    private UUID pqr;
    private String photographicRecordPath;
    private String observations;

    public GetPruningDTO(UUID id, GetStatusDTO status,
            LocalDate plannedDate, LocalDate executedDate,
            GetTreeDTO tree, GetQuadrilleDTO quadrille, GetTypeDTO type,
            UUID pqr, String photographicRecordPath, String observations) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
        this.status = status;
        this.plannedDate = DateHelper.getDateHelper().getDefault(plannedDate);
        this.executedDate = DateHelper.getDateHelper().getDefault(executedDate);
        this.tree = tree;
        this.quadrille = quadrille;
        this.type = type;
        this.pqr = UUIDHelper.getUUIDHelper().getDefault(pqr);
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
        this.observations = TextHelper.getDefaultWithTrim(observations);
    }

    public UUID getId() { return id; }
    public GetStatusDTO getStatus() { return status; }
    public LocalDate getPlannedDate() { return plannedDate; }
    public LocalDate getExecutedDate() { return executedDate; }
    public GetTreeDTO getTree() { return tree; }
    public GetQuadrilleDTO getQuadrille() { return quadrille; }
    public GetTypeDTO getType() { return type; }
    public UUID getPqr() { return pqr; }
    public String getPhotographicRecordPath() { return photographicRecordPath; }
    public String getObservations() { return observations; }
}
