package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.domain.GetFamilyDomain;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.domain.GetProgrammingDomain;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain.GetPruningDomain;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.domain.GetSectorDomain;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;

@Mapper(componentModel = "spring")
public interface GetPruningDTOMapper {

    GetPruningDTO toDTO(GetPruningDomain domain);

    default GetStatusDTO toStatusDTO(GetStatusDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetStatusDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        return new GetStatusDTO(d.getId(), d.getName());
    }

    default GetTreeDTO toTreeDTO(GetTreeDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetTreeDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(),
                    TextHelper.getDefault(),
                    toFamilyDTO(null),
                    toSectorDTO(null),
                    toProgrammingDTO(null));
        }
        return new GetTreeDTO(
                d.getId(),
                d.getLongitude(),
                d.getLatitude(),
                toFamilyDTO(d.getFamily()),
                toSectorDTO(d.getSector()),
                toProgrammingDTO(d.getProgramming()));
    }

    default GetFamilyDTO toFamilyDTO(GetFamilyDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetFamilyDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(),
                    TextHelper.getDefault());
        }
        return new GetFamilyDTO(d.getId(), d.getCommonName(), d.getScientificName());
    }

    default GetSectorDTO toSectorDTO(GetSectorDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetSectorDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        return new GetSectorDTO(d.getId(), d.getName());
    }

    default GetProgrammingDTO toProgrammingDTO(GetProgrammingDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetProgrammingDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    DateHelper.getDateHelper().getDefault(),
                    NumericHelper.getDefaultInt(),
                    NumericHelper.getDefaultInt());
        }
        return new GetProgrammingDTO(d.getId(), d.getInitialDate(), d.getFrequencyMonths(), d.getAmount());
    }

    default GetQuadrilleDTO toQuadrilleDTO(GetQuadrilleDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetQuadrilleDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(),
                    toManagerDTO(null));
        }
        return new GetQuadrilleDTO(d.getId(), d.getQuadrilleName(), toManagerDTO(d.getManager()));
    }

    default GetManagerDTO toManagerDTO(GetManagerDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetManagerDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    toPersonDTO(null));
        }
        return new GetManagerDTO(d.getId(), toPersonDTO(d.getPerson()));
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

    default GetTypeDTO toTypeDTO(GetTypeDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetTypeDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        return new GetTypeDTO(d.getId(), d.getName());
    }
}
