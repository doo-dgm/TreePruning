package co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport;

import java.util.UUID;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.dto.GetStatusByIdDTO;

public interface GetStatusByIdInputPort extends InputPort<UUID, GetStatusByIdDTO> {
}
