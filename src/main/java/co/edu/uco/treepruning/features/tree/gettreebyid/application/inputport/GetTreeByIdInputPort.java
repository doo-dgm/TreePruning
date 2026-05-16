package co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport;

import java.util.UUID;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.dto.GetTreeByIdDTO;

public interface GetTreeByIdInputPort extends InputPort<UUID, GetTreeByIdDTO> {
}
