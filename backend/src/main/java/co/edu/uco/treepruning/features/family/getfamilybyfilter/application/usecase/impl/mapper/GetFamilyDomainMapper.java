package co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;

@Mapper(componentModel = "spring")
public interface GetFamilyDomainMapper {

    default GetFamilyDomain toDomain(FamilyEntity entity) {
        if (ObjectHelper.isNull(entity)) {
            return new GetFamilyDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(),
                    TextHelper.getDefault());
        }
        return new GetFamilyDomain(
                UUIDHelper.getUUIDHelper().getDefault(entity.getId()),
                TextHelper.getDefaultWithTrim(entity.getCommonName()),
                TextHelper.getDefaultWithTrim(entity.getScientificName()));
    }
}
