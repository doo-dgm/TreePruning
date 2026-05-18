package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PersonEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;

@Mapper(componentModel = "spring")
public interface GetQuadrilleDomainMapper {

    @Mapping(target = "manager", expression = "java(buildManager(entity.getManager()))")
    GetQuadrilleDomain toDomain(QuadrilleEntity entity);

    default GetManagerDomain buildManager(ManagerEntity manager) {
        if (ObjectHelper.isNull(manager)) {
            return new GetManagerDomain(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    buildPerson(null));
        }
        return new GetManagerDomain(
                UUIDHelper.getUUIDHelper().getDefault(manager.getId()),
                buildPerson(manager.getPerson()));
    }

    default GetPersonDomain buildPerson(PersonEntity person) {
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
}
