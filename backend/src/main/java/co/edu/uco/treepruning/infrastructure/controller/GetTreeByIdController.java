package co.edu.uco.treepruning.infrastructure.controller;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.GetTreeByIdInputPort;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.dto.GetTreeByIdDTO;

@RestController
@RequestMapping("/api/v1/trees")
public class GetTreeByIdController {

    private final GetTreeByIdInputPort inputPort;

    public GetTreeByIdController(GetTreeByIdInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetTreeByIdDTO>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(
            ApiResponse.ok("Arbol obtenido exitosamente.", inputPort.execute(id))
        );
    }
}
