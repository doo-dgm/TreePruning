package co.edu.uco.treepruning.features.status.getstatus.application.inputport.impl.mapper;

import co.edu.uco.treepruning.features.status.getstatus.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.status.getstatus.application.usecase.domain.GetStatusDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T19:01:12-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260421-0704, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class GetStatusDTOMapperImpl implements GetStatusDTOMapper {

    @Override
    public GetStatusDTO toDTO(GetStatusDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = domain.getId();
        name = domain.getName();

        GetStatusDTO getStatusDTO = new GetStatusDTO( id, name );

        return getStatusDTO;
    }

    @Override
    public List<GetStatusDTO> toDTOList(List<GetStatusDomain> domains) {
        if ( domains == null ) {
            return null;
        }

        List<GetStatusDTO> list = new ArrayList<GetStatusDTO>( domains.size() );
        for ( GetStatusDomain getStatusDomain : domains ) {
            list.add( toDTO( getStatusDomain ) );
        }

        return list;
    }
}
