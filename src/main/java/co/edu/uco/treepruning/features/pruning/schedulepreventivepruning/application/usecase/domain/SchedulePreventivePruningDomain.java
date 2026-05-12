package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.usecase.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.exception
        .TreePruningException;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class SchedulePreventivePruningDomain {

    private UUID id;
    private UUID status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private UUID tree;
    private UUID quadrille;
    private UUID type;
    private UUID pqr;
    private String photographicRecordPath;
    private String observations;

    public SchedulePreventivePruningDomain(
            UUID status,
            LocalDate plannedDate,
            LocalDate executedDate,
            UUID tree,
            UUID quadrille,
            UUID type,
            UUID pqr,
            String photographicRecordPath,
            String observations) {
        generateId();
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

    private void generateId() {
        this.id = UUIDHelper.getUUIDHelper().generateNewUUID();
    }

    public void regenerateId() {
        generateId();
    }

    private void setStatus(UUID status) {
        if (UUIDHelper.getUUIDHelper().isDefaultUUID(
                UUIDHelper.getUUIDHelper().getDefault(status))) {
            throw TreePruningException.create(
                "El estado de la poda es obligatorio.",
                "SchedulePreventivePruningDomain.status: " +
                "null or default UUID"
            );
        }
        this.status = status;
    }

    private void setPlannedDate(LocalDate plannedDate) {
        if (DateHelper.getDateHelper().isDefaultDate(
                DateHelper.getDateHelper().getDefault(plannedDate))) {
            throw TreePruningException.create(
                "La fecha programada de la poda es obligatoria.",
                "SchedulePreventivePruningDomain.plannedDate: null"
            );
        }
        if (!DateHelper.getDateHelper()
                .isLocalDateAfterOrEquals(plannedDate)) {
            throw TreePruningException.create(
                "La fecha programada de la poda no puede ser una fecha pasada.",
                "SchedulePreventivePruningDomain.plannedDate: date is in the past"
            );
        }
        this.plannedDate = plannedDate;
    }

    private void setExecutedDate(LocalDate executedDate) {

        if (executedDate != null &&
                !DateHelper.getDateHelper().isDefaultDate(executedDate)) {
            if (executedDate.isBefore(this.plannedDate)) {
                throw TreePruningException.create(
                    "La fecha de ejecución no puede ser anterior a la fecha programada.",
                    "SchedulePreventivePruningDomain.executedDate: before plannedDate"
                );
            }
        }
        this.executedDate = DateHelper.getDateHelper()
                .getDefault(executedDate);
    }

    private void setTree(UUID tree) {
        if (UUIDHelper.getUUIDHelper().isDefaultUUID(
                UUIDHelper.getUUIDHelper().getDefault(tree))) {
            throw TreePruningException.create(
                "El árbol a intervenir es obligatorio.",
                "SchedulePreventivePruningDomain.tree: null or default UUID"
            );
        }
        this.tree = tree;
    }

    private void setQuadrille(UUID quadrille) {
        if (UUIDHelper.getUUIDHelper().isDefaultUUID(
                UUIDHelper.getUUIDHelper().getDefault(quadrille))) {
            throw TreePruningException.create(
                "La cuadrilla asignada es obligatoria.",
                "SchedulePreventivePruningDomain.quadrille: null or default UUID"
            );
        }
        this.quadrille = quadrille;
    }

    private void setType(UUID type) {
        if (UUIDHelper.getUUIDHelper().isDefaultUUID(
                UUIDHelper.getUUIDHelper().getDefault(type))) {
            throw TreePruningException.create(
                "El tipo de poda es obligatorio.",
                "SchedulePreventivePruningDomain.type: null or default UUID"
            );
        }
        this.type = type;
    }

    private void setPqr(UUID pqr) {
        this.pqr = UUIDHelper.getUUIDHelper().getDefault(pqr);
    }

    private void setPhotographicRecordPath(
            String photographicRecordPath) {
        if (TextHelper.isEmptyWithTrim(photographicRecordPath)) {
            throw TreePruningException.create(
                "El registro fotográfico de la poda es obligatorio.",
                "SchedulePreventivePruningDomain.photographicRecordPath: null or empty"
            );
        }
        if (!TextHelper.lengthIsValidWithTrim(
                photographicRecordPath, 1, 500)) {
            throw TreePruningException.create(
                "La ruta del registro fotográfico no puede superar los 500 caracteres.",
                "SchedulePreventivePruningDomain.photographicRecordPath: exceeds 500 characters"
            );
        }
        this.photographicRecordPath = TextHelper
                .getDefaultWithTrim(photographicRecordPath);
    }

    private void setObservations(String observations) {
        if (TextHelper.isEmptyWithTrim(observations)) {
            throw TreePruningException.create(
                "Las observaciones de la poda son obligatorias.",
                "SchedulePreventivePruningDomain.observations: null or empty"
            );
        }
        if (!TextHelper.lengthIsValidWithTrim(
                observations, 10, 500)) {
            throw TreePruningException.create(
                "Las observaciones deben tener entre 10 y 500 caracteres.",
                "SchedulePreventivePruningDomain.observations: length out of range [10, 500]"
            );
        }
        this.observations = TextHelper
                .getDefaultWithTrim(observations);
    }

    public UUID getId() {
        return id;
    }

    public UUID getStatus() {
        return status;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public LocalDate getExecutedDate() {
        return executedDate;
    }

    public UUID getTree() {
        return tree;
    }

    public UUID getQuadrille() {
        return quadrille;
    }

    public UUID getType() {
        return type;
    }

    public UUID getPqr() {
        return pqr;
    }

    public String getPhotographicRecordPath() {
        return photographicRecordPath;
    }

    public String getObservations() {
        return observations;
    }
}
