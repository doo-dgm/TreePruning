package co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;

@Mapper(componentModel = "spring")
public interface GetPersonDTOMapper {

    default GetPersonDTO toDTO(GetPersonDomain domain) {
        if (ObjectHelper.isNull(domain)) {
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
                domain.getId(),
                domain.getFirstName(),
                domain.getSecondName(),
                domain.getFirstLastName(),
                domain.getSecondLastName(),
                domain.getDocumentNumber(),
                domain.getBirthDate(),
                domain.getAddress(),
                domain.getEmail(),
                domain.getPhone(),
                domain.getAge());
    }
}
