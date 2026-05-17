package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.StatusRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.StatusEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.StatusJPARepository;

@Repository
public class StatusJPARepositoryAdapter implements StatusRepository {

    private final StatusJPARepository repository;
    private final StatusEntityMapper mapper;

    public StatusJPARepositoryAdapter(StatusJPARepository repository,
            StatusEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<StatusEntity> findByFilter(UUID id, String name) {
        return mapper.toEntityList(repository.findByFilter(id, name));
    }
}
