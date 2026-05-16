package co.edu.uco.treepruning.infrastructure.controller;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.GetQuadrilleByIdInputPort;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.dto.GetQuadrilleByIdDTO;

@RestController
@RequestMapping("/api/v1/quadrilles")
public class GetQuadrilleByIdController {

    private final GetQuadrilleByIdInputPort inputPort;

    public GetQuadrilleByIdController(GetQuadrilleByIdInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetQuadrilleByIdDTO>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(
            ApiResponse.ok("Cuadrilla obtenida exitosamente.", inputPort.execute(id))
        );
    }
}
