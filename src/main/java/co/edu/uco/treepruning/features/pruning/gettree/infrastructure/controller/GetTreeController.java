package co.edu.uco.treepruning.features.pruning.gettree.infrastructure.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruning.gettree.application.inputport.GetTreeInputPort;
import co.edu.uco.treepruning.features.pruning.gettree.application.inputport.dto.GetTreeDTO;

@RestController
@RequestMapping("/api/v1/trees")
public class GetTreeController {

    private final GetTreeInputPort inputPort;

    public GetTreeController(GetTreeInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetTreeDTO>>> getAll() {
        List<GetTreeDTO> trees = inputPort.execute(null);
        return ResponseEntity.ok(
            ApiResponse.ok(
                "Árboles obtenidos exitosamente.", trees)
        );
    }
}
