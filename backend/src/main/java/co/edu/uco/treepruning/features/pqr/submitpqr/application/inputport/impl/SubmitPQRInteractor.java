package co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.impl;

import co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.SubmitPQRInputPort;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.dto.SubmitPQRDTO;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.SubmitPQRUseCase;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.domain.SubmitPQRDomain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SubmitPQRInteractor implements SubmitPQRInputPort {

private final SubmitPQRUseCase submitPQRUseCase;

	public SubmitPQRInteractor(SubmitPQRUseCase submitPQRUseCase) {
		this.submitPQRUseCase = submitPQRUseCase;
		
		}

	@Override
	public Void execute(SubmitPQRDTO data) {// Paso de DTO a Domain
	SubmitPQRDomain domain = new SubmitPQRDomain(
			data.getDate(),
			data.getStatus(),
			data.getSector(),
			data.getRisk(),
			data.getPerson(),
			data.getPhotographicRecordPath()
			
			);

	submitPQRUseCase.execute(domain); //Paso de Domain al UseCase

	return null;
	}
}