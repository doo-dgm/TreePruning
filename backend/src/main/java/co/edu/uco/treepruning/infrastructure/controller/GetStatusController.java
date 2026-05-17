package co.edu.uco.treepruning.infrastructure.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.status.getstatus.application.inputport.GetStatusInputPort;
import co.edu.uco.treepruning.features.status.getstatus.application.inputport.dto.GetStatusDTO;

@RestController
@RequestMapping("/api/v1/statuses")
public class GetStatusController {

    private final GetStatusInputPort inputPort;

    public GetStatusController(GetStatusInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetStatusDTO>>> getAll() {
        List<GetStatusDTO> statuses = inputPort.execute(null);
        return ResponseEntity.ok(
            ApiResponse.ok(
                "Estados obtenidos exitosamente.", statuses)
        );
    }
}
