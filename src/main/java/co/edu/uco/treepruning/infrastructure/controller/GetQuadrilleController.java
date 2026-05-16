package co.edu.uco.treepruning.infrastructure.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.quadrille.getquadrille.application.inputport.GetQuadrilleInputPort;
import co.edu.uco.treepruning.features.quadrille.getquadrille.application.inputport.dto.GetQuadrilleDTO;

@RestController
@RequestMapping("/api/v1/quadrilles")
public class GetQuadrilleController {

    private final GetQuadrilleInputPort inputPort;

    public GetQuadrilleController(GetQuadrilleInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetQuadrilleDTO>>> getAll() {
        List<GetQuadrilleDTO> quadrilles = inputPort.execute(null);
        return ResponseEntity.ok(
            ApiResponse.ok(
                "Cuadrillas obtenidas exitosamente.", quadrilles)
        );
    }
}
