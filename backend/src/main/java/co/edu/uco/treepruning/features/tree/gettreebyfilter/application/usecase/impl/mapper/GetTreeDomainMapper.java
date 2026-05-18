package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;

@Mapper(componentModel = "spring")
public interface GetTreeDomainMapper {

    @Mapping(target = "family",      expression = "java(buildFamily(entity.getFamily()))")
    @Mapping(target = "sector",      expression = "java(buildSector(entity.getSector()))")
    @Mapping(target = "programming", expression = "java(buildProgramming(entity.getProgramming()))")
    GetTreeDomain toDomain(TreeEntity entity);

    default GetFamilyDomain buildFamily(FamilyEntity f) {
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

    default GetSectorDomain buildSector(SectorEntity s) {
        if (ObjectHelper.isNull(s)) {
            return new GetSectorDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        return new GetSectorDomain(
                UUIDHelper.getUUIDHelper().getDefault(s.getId()),
                TextHelper.getDefaultWithTrim(s.getName()));
    }

    default GetProgrammingDomain buildProgramming(ProgrammingEntity p) {
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
}
