package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.PruningEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PruningJPARepository;

@Repository
public class PruningJPARepositoryAdapter implements PruningRepository {

    private final PruningJPARepository repository;
    private final PruningEntityMapper mapper;

    public PruningJPARepositoryAdapter(PruningJPARepository repository,
            PruningEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(final PruningEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(final UUID id, final PruningEntity entity) {
        // TODO
    }

    @Override
    public void delete(final UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<PruningEntity> findByFilter(UUID id, UUID statusId, UUID treeId,
            UUID quadrilleId, UUID typeId, LocalDate plannedDate) {
        return mapper.toEntityList(
            repository.findByFilter(id, statusId, treeId, quadrilleId, typeId, plannedDate)
        );
    }

    @Override
    public boolean existsByTreeAndPlannedDate(final UUID treeId, final LocalDate plannedDate) {
        return repository.existsByTree_IdAndPlannedDate(treeId, plannedDate);
    }
}
