package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain.GetPruningDomain;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
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
                    TextHelper.getDefault(),
                    TextHelper.getDefault(),
                    buildTreeFamily(null),
                    buildTreeSector(null),
                    buildTreeProgramming(null));
        }
        return new GetTreeDomain(
                UUIDHelper.getUUIDHelper().getDefault(t.getId()),
                TextHelper.getDefaultWithTrim(t.getLongitude()),
                TextHelper.getDefaultWithTrim(t.getLatitude()),
                buildTreeFamily(t.getFamily()),
                buildTreeSector(t.getSector()),
                buildTreeProgramming(t.getProgramming()));
    }

    default GetFamilyDomain buildTreeFamily(FamilyEntity f) {
        if (ObjectHelper.isNull(f)) {
            return new GetFamilyDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(),
                    TextHelper.getDefault());
        }
        return new GetFamilyDomain(
                UUIDHelper.getUUIDHelper().getDefault(f.getId()),
                TextHelper.getDefaultWithTrim(f.getCommonName()),
                TextHelper.getDefaultWithTrim(f.getScientificName()));
    }

    default GetSectorDomain buildTreeSector(SectorEntity s) {
        if (ObjectHelper.isNull(s)) {
            return new GetSectorDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        return new GetSectorDomain(
                UUIDHelper.getUUIDHelper().getDefault(s.getId()),
                TextHelper.getDefaultWithTrim(s.getName()));
    }

    default GetProgrammingDomain buildTreeProgramming(ProgrammingEntity p) {
        if (ObjectHelper.isNull(p)) {
            return new GetProgrammingDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    DateHelper.getDateHelper().getDefault(),
                    NumericHelper.getDefaultInt(),
                    NumericHelper.getDefaultInt());
        }
        return new GetProgrammingDomain(
                UUIDHelper.getUUIDHelper().getDefault(p.getId()),
                DateHelper.getDateHelper().getDefault(p.getInitialDate()),
                NumericHelper.getDefaultInt(p.getFrequencyMonths()),
                NumericHelper.getDefaultInt(p.getAmount()));
    }

    default GetQuadrilleDomain buildQuadrille(QuadrilleEntity q) {
        if (ObjectHelper.isNull(q)) {
            return new GetQuadrilleDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(),
                    buildQuadrilleManager(null));
        }
        return new GetQuadrilleDomain(
                UUIDHelper.getUUIDHelper().getDefault(q.getId()),
                TextHelper.getDefaultWithTrim(q.getQuadrilleName()),
                buildQuadrilleManager(q.getManager()));
    }

    default GetManagerDomain buildQuadrilleManager(ManagerEntity manager) {
        if (ObjectHelper.isNull(manager)) {
            return new GetManagerDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    buildQuadrillePerson(null));
        }
        return new GetManagerDomain(
                UUIDHelper.getUUIDHelper().getDefault(manager.getId()),
                buildQuadrillePerson(manager.getPerson()));
    }

    default GetPersonDomain buildQuadrillePerson(PersonEntity person) {
        if (ObjectHelper.isNull(person)) {
            return new GetPersonDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(),
                    TextHelper.getDefault(),
                    TextHelper.getDefault(),
                    TextHelper.getDefault(),
                    TextHelper.getDefault(),
                    DateHelper.getDateHelper().getDefault(),
                    TextHelper.getDefault(),
                    TextHelper.getDefault(),
                    TextHelper.getDefault(),
                    NumericHelper.getDefaultInt());
        }
        return new GetPersonDomain(
                UUIDHelper.getUUIDHelper().getDefault(person.getId()),
                TextHelper.getDefaultWithTrim(person.getFirstName()),
                TextHelper.getDefaultWithTrim(person.getSecondName()),
                TextHelper.getDefaultWithTrim(person.getFirstLastName()),
                TextHelper.getDefaultWithTrim(person.getSecondLastName()),
                TextHelper.getDefaultWithTrim(person.getDocumentNumber()),
                DateHelper.getDateHelper().getDefault(person.getBirthDate()),
                TextHelper.getDefaultWithTrim(person.getAddress()),
                TextHelper.getDefaultWithTrim(person.getEmail()),
                TextHelper.getDefaultWithTrim(person.getPhone()),
                NumericHelper.getDefaultInt(person.getAge()));
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
