package co.edu.uco.treepruning.infrastructure.controller.request;

import java.time.LocalDate;
import java.util.UUID;

public record SubmitPQRRequest(
        LocalDate date,
        UUID status,
        UUID sector,
        UUID risk,
        UUID person,
        String photographicRecordPath
) {
}
