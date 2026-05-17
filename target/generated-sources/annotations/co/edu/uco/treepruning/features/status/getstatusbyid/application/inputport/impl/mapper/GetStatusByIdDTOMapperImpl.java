package co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.impl.mapper;

import co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.dto.GetStatusByIdDTO;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.usecase.domain.GetStatusByIdDomain;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T19:01:12-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260421-0704, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class GetStatusByIdDTOMapperImpl implements GetStatusByIdDTOMapper {

    @Override
    public GetStatusByIdDTO toDTO(GetStatusByIdDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = domain.getId();
        name = domain.getName();

        GetStatusByIdDTO getStatusByIdDTO = new GetStatusByIdDTO( id, name );

        return getStatusByIdDTO;
    }
}
