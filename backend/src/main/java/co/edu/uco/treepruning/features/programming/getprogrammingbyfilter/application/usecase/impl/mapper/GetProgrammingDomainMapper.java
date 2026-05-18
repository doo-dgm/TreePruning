package co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;

@Mapper(componentModel = "spring")
public interface GetProgrammingDomainMapper {

    default GetProgrammingDomain toDomain(ProgrammingEntity entity) {
        if (ObjectHelper.isNull(entity)) {
            return new GetProgrammingDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    DateHelper.getDateHelper().getDefault(),
                    NumericHelper.getDefaultInt(),
                    NumericHelper.getDefaultInt());
        }
        return new GetProgrammingDomain(
                UUIDHelper.getUUIDHelper().getDefault(entity.getId()),
                DateHelper.getDateHelper().getDefault(entity.getInitialDate()),
                NumericHelper.getDefaultInt(entity.getFrequencyMonths()),
                NumericHelper.getDefaultInt(entity.getAmount()));
    }
}
