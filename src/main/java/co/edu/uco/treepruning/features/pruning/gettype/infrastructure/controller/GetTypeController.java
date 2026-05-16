package co.edu.uco.treepruning.features.pruning.gettype.infrastructure.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruning.gettype.application.inputport.GetTypeInputPort;
import co.edu.uco.treepruning.features.pruning.gettype.application.inputport.dto.GetTypeDTO;

@RestController
@RequestMapping("/api/v1/pruning-types")
public class GetTypeController {

    private final GetTypeInputPort inputPort;

    public GetTypeController(GetTypeInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetTypeDTO>>> getAll() {
        List<GetTypeDTO> types = inputPort.execute(null);
        return ResponseEntity.ok(
            ApiResponse.ok(
                "Tipos de poda obtenidos exitosamente.", types)
        );
    }
}
