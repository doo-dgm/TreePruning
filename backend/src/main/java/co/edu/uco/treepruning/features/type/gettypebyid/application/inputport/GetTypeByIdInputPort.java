package co.edu.uco.treepruning.features.type.gettypebyid.application.inputport;

import java.util.UUID;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.type.gettypebyid.application.inputport.dto.GetTypeByIdDTO;

public interface GetTypeByIdInputPort extends InputPort<UUID, GetTypeByIdDTO> {
}
