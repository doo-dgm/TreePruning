package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto;

import java.time.LocalDate;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
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
        setId(id);
        setStatus(status);
        setPlannedDate(plannedDate);
        setExecutedDate(executedDate);
        setTree(tree);
        setQuadrille(quadrille);
        setType(type);
        setPqr(pqr);
        setPhotographicRecordPath(photographicRecordPath);
        setObservations(observations);
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

    private void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
    private void setStatus(final GetStatusDTO status) {
        this.status = ObjectHelper.isNull(status)
                ? new GetStatusDTO(null, null)
                : status;
    }
    private void setPlannedDate(final LocalDate plannedDate) {
        this.plannedDate = DateHelper.getDateHelper().getDefault(plannedDate);
    }
    private void setExecutedDate(final LocalDate executedDate) {
        this.executedDate = DateHelper.getDateHelper().getDefault(executedDate);
    }
    private void setTree(final GetTreeDTO tree) {
        this.tree = ObjectHelper.isNull(tree)
                ? new GetTreeDTO(null, null, null, null, null, null)
                : tree;
    }
    private void setQuadrille(final GetQuadrilleDTO quadrille) {
        this.quadrille = ObjectHelper.isNull(quadrille)
                ? new GetQuadrilleDTO(null, null, null)
                : quadrille;
    }
    private void setType(final GetTypeDTO type) {
        this.type = ObjectHelper.isNull(type)
                ? new GetTypeDTO(null, null)
                : type;
    }
    private void setPqr(final UUID pqr) {
        this.pqr = UUIDHelper.getUUIDHelper().getDefault(pqr);
    }
    private void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
    private void setObservations(final String observations) {
        this.observations = TextHelper.getDefaultWithTrim(observations);
    }
}
