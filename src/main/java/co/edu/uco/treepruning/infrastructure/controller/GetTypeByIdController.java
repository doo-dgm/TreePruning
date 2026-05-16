package co.edu.uco.treepruning.infrastructure.controller;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.type.gettypebyid.application.inputport.GetTypeByIdInputPort;
import co.edu.uco.treepruning.features.type.gettypebyid.application.inputport.dto.GetTypeByIdDTO;

@RestController
@RequestMapping("/api/v1/pruning-types")
public class GetTypeByIdController {

    private final GetTypeByIdInputPort inputPort;

    public GetTypeByIdController(GetTypeByIdInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetTypeByIdDTO>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(
            ApiResponse.ok("Tipo de poda obtenido exitosamente.", inputPort.execute(id))
        );
    }
}
