package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain.GetPruningDomain;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;

@Mapper(componentModel = "spring")
public interface GetPruningDomainMapper {

    @Mapping(target = "status",    expression = "java(buildStatus(entity.getStatus()))")
    @Mapping(target = "tree",      expression = "java(buildTree(entity.getTree()))")
    @Mapping(target = "quadrille", expression = "java(buildQuadrille(entity.getQuadrille()))")
    @Mapping(target = "type",      expression = "java(buildType(entity.getType()))")
    @Mapping(source = "pqr.id",   target = "pqr")
    GetPruningDomain toDomain(PruningEntity entity);

    default GetStatusDomain buildStatus(StatusEntity s) {
        if (ObjectHelper.isNull(s)) {
            return new GetStatusDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        return new GetStatusDomain(
                UUIDHelper.getUUIDHelper().getDefault(s.getId()),
                TextHelper.getDefaultWithTrim(s.getName()));
    }

    default GetTreeDomain buildTree(TreeEntity t) {
        if (ObjectHelper.isNull(t)) {
            return new GetTreeDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(), TextHelper.getDefault(),
                    UUIDHelper.getUUIDHelper().getDefault(), TextHelper.getDefault(), TextHelper.getDefault(),
                    UUIDHelper.getUUIDHelper().getDefault(), TextHelper.getDefault(),
                    UUIDHelper.getUUIDHelper().getDefault());
        }
        return new GetTreeDomain(
                UUIDHelper.getUUIDHelper().getDefault(t.getId()),
                TextHelper.getDefaultWithTrim(t.getLongitude()),
                TextHelper.getDefaultWithTrim(t.getLatitude()),
                UUIDHelper.getUUIDHelper().getDefault(!ObjectHelper.isNull(t.getFamily()) ? t.getFamily().getId() : null),
                TextHelper.getDefaultWithTrim(!ObjectHelper.isNull(t.getFamily()) ? t.getFamily().getCommonName() : null),
                TextHelper.getDefaultWithTrim(!ObjectHelper.isNull(t.getFamily()) ? t.getFamily().getScientificName() : null),
                UUIDHelper.getUUIDHelper().getDefault(!ObjectHelper.isNull(t.getSector()) ? t.getSector().getId() : null),
                TextHelper.getDefaultWithTrim(!ObjectHelper.isNull(t.getSector()) ? t.getSector().getName() : null),
                UUIDHelper.getUUIDHelper().getDefault(!ObjectHelper.isNull(t.getProgramming()) ? t.getProgramming().getId() : null));
    }

    default GetQuadrilleDomain buildQuadrille(QuadrilleEntity q) {
        if (ObjectHelper.isNull(q)) {
            return new GetQuadrilleDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(),
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        String managerName = TextHelper.getDefault();
        if (!ObjectHelper.isNull(q.getManager()) && !ObjectHelper.isNull(q.getManager().getPerson())) {
            managerName = TextHelper.getDefaultWithTrim(
                    TextHelper.getDefault(q.getManager().getPerson().getFirstName()) + " " +
                    TextHelper.getDefault(q.getManager().getPerson().getFirstLastName()));
        }
        return new GetQuadrilleDomain(
                UUIDHelper.getUUIDHelper().getDefault(q.getId()),
                TextHelper.getDefaultWithTrim(q.getQuadrilleName()),
                UUIDHelper.getUUIDHelper().getDefault(!ObjectHelper.isNull(q.getManager()) ? q.getManager().getId() : null),
                managerName);
    }

    default GetTypeDomain buildType(TypeEntity t) {
        if (ObjectHelper.isNull(t)) {
            return new GetTypeDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        return new GetTypeDomain(
                UUIDHelper.getUUIDHelper().getDefault(t.getId()),
                TextHelper.getDefaultWithTrim(t.getName()));
    }
}
