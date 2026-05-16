package co.edu.uco.treepruning.features.pruning.getstatus.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.pruning.getstatus.application.inputport.dto.GetStatusDTO;

public interface GetStatusInputPort extends InputPort<Void, List<GetStatusDTO>> {
}
