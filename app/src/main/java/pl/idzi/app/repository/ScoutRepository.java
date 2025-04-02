package pl.idzi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.idzi.app.model.scout.Scout;

import java.util.List;
import java.util.UUID;

@Repository
public interface ScoutRepository extends JpaRepository<Scout, UUID> {
    List<Scout> findAllByFirstname(String firstname);
    List<Scout> findAllBySurname(String surname);
}
