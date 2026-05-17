package co.edu.uco.treepruning.infrastructure.controller;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.GetStatusByIdInputPort;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.dto.GetStatusByIdDTO;

@RestController
@RequestMapping("/api/v1/statuses")
public class GetStatusByIdController {

    private final GetStatusByIdInputPort inputPort;

    public GetStatusByIdController(GetStatusByIdInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetStatusByIdDTO>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(
            ApiResponse.ok("Estado obtenido exitosamente.", inputPort.execute(id))
        );
    }
}
