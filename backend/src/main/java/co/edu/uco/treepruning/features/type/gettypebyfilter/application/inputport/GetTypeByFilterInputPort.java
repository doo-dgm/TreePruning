package co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeFilterDTO;

public interface GetTypeByFilterInputPort extends InputPort<GetTypeFilterDTO, List<GetTypeDTO>> {
}
