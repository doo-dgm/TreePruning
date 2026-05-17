package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain;

import java.time.LocalDate;
import java.util.UUID;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;

public final class GetPruningDomain {
    private final UUID id;
    private final GetStatusDomain status;
    private final LocalDate plannedDate;
    private final LocalDate executedDate;
    private final GetTreeDomain tree;
    private final GetQuadrilleDomain quadrille;
    private final GetTypeDomain type;
    private final UUID pqr;
    private final String photographicRecordPath;
    private final String observations;

    public GetPruningDomain(UUID id, GetStatusDomain status,
            LocalDate plannedDate, LocalDate executedDate,
            GetTreeDomain tree, GetQuadrilleDomain quadrille, GetTypeDomain type,
            UUID pqr, String photographicRecordPath, String observations) {
        this.id = id;
        this.status = status;
        this.plannedDate = plannedDate;
        this.executedDate = executedDate;
        this.tree = tree;
        this.quadrille = quadrille;
        this.type = type;
        this.pqr = pqr;
        this.photographicRecordPath = photographicRecordPath;
        this.observations = observations;
    }

    public UUID getId() { return id; }
    public GetStatusDomain getStatus() { return status; }
    public LocalDate getPlannedDate() { return plannedDate; }
    public LocalDate getExecutedDate() { return executedDate; }
    public GetTreeDomain getTree() { return tree; }
    public GetQuadrilleDomain getQuadrille() { return quadrille; }
    public GetTypeDomain getType() { return type; }
    public UUID getPqr() { return pqr; }
    public String getPhotographicRecordPath() { return photographicRecordPath; }
    public String getObservations() { return observations; }
}
