package co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;

@Mapper(componentModel = "spring")
public interface GetManagerDTOMapper {

    default GetManagerDTO toDTO(GetManagerDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetManagerDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    toPersonDTO(null));
        }
        return new GetManagerDTO(domain.getId(), toPersonDTO(domain.getPerson()));
    }

    default GetPersonDTO toPersonDTO(GetPersonDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetPersonDTO(
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
        return new GetPersonDTO(
                d.getId(),
                d.getFirstName(),
                d.getSecondName(),
                d.getFirstLastName(),
                d.getSecondLastName(),
                d.getDocumentNumber(),
                d.getBirthDate(),
                d.getAddress(),
                d.getEmail(),
                d.getPhone(),
                d.getAge());
    }
}
