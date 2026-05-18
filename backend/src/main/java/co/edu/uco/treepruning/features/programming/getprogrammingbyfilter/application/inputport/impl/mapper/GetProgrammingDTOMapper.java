package co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;

@Mapper(componentModel = "spring")
public interface GetProgrammingDTOMapper {

    default GetProgrammingDTO toDTO(GetProgrammingDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            return new GetProgrammingDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    DateHelper.getDateHelper().getDefault(),
                    NumericHelper.getDefaultInt(),
                    NumericHelper.getDefaultInt());
        }
        return new GetProgrammingDTO(
                domain.getId(),
                domain.getInitialDate(),
                domain.getFrequencyMonths(),
                domain.getAmount());
    }
}
