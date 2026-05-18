package co.edu.uco.treepruning.infrastructure.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.GetPruningByFilterInputPort;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;

@RestController
@RequestMapping("/api/v1/prunings")
public class GetPruningController {

    private final GetPruningByFilterInputPort inputPort;

    public GetPruningController(GetPruningByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetPruningDTO>>> getByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) UUID statusId,
            @RequestParam(required = false) UUID treeId,
            @RequestParam(required = false) UUID quadrilleId,
            @RequestParam(required = false) UUID typeId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate plannedDate) {
        List<GetPruningDTO> results = inputPort.execute(
                new GetPruningDTO(id,
                        new GetStatusDTO(statusId, null),
                        plannedDate, null,
                        new GetTreeDTO(treeId, null, null, null, null, null),
                        new GetQuadrilleDTO(quadrilleId, null, null),
                        new GetTypeDTO(typeId, null),
                        null, null, null));
        return ResponseEntity.ok(ApiResponse.ok("Podas obtenidas exitosamente.", results));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetPruningDTO>> getById(@PathVariable UUID id) {
        List<GetPruningDTO> results = inputPort.execute(
                new GetPruningDTO(id, null, null, null, null, null, null, null, null, null));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Pruning", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Poda obtenida exitosamente.", results.get(0)));
    }
}
