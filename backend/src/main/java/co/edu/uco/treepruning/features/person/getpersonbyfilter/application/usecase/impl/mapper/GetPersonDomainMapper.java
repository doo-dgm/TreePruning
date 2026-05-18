package co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;

@Mapper(componentModel = "spring")
public interface GetPersonDomainMapper {

    default GetPersonDomain toDomain(PersonEntity entity) {
        if (ObjectHelper.isNull(entity)) {
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
                UUIDHelper.getUUIDHelper().getDefault(entity.getId()),
                TextHelper.getDefaultWithTrim(entity.getFirstName()),
                TextHelper.getDefaultWithTrim(entity.getSecondName()),
                TextHelper.getDefaultWithTrim(entity.getFirstLastName()),
                TextHelper.getDefaultWithTrim(entity.getSecondLastName()),
                TextHelper.getDefaultWithTrim(entity.getDocumentNumber()),
                DateHelper.getDateHelper().getDefault(entity.getBirthDate()),
                TextHelper.getDefaultWithTrim(entity.getAddress()),
                TextHelper.getDefaultWithTrim(entity.getEmail()),
                TextHelper.getDefaultWithTrim(entity.getPhone()),
                NumericHelper.getDefaultInt(entity.getAge()));
    }
}
